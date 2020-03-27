package com.devproject.miguelfagundez.mysortapplication.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.devproject.miguelfagundez.mysortapplication.Interface;
import com.devproject.miguelfagundez.mysortapplication.R;
import com.devproject.miguelfagundez.mysortapplication.adapter.MySortListAdapter;
import com.devproject.miguelfagundez.mysortapplication.presenter.MainPresenter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/********************************************
 * MainActivity - Launcher activity
 * This is the first activity
 * @author: Miguel Fagundez
 * @date: March 26th, 2020
 * @version: 1.0
 * *******************************************/
public class MainActivity extends AppCompatActivity implements Interface.view {

    // Private members
    private RecyclerView recyclerView;
    private MySortListAdapter adapter;

    // Presenter layer
    private Interface.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        bindViews();
    }

    //*************************************************
    // Connecting recyclerview with data
    //*************************************************
    private void bindViews(){
        adapter = new MySortListAdapter(presenter.takeSortOption());
        adapter.createBlocks(presenter.getData());

        recyclerView = findViewById(R.id.sortListRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    //*************************************************
    // Menu inflater - Action Bar
    //*************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //*************************************************
    // Actions when menu item is pressed
    //*************************************************
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // Optimization change - Avoiding to create the same data many times
        presenter.setChangeOption(false);

        switch (item.getItemId()){
            case R.id.menu_order_asc:
            case R.id.menu_order_asc_arrow:
                if(!presenter.getSortOption()) {
                    presenter.setSortOption(true);
                    presenter.setChangeOption(true);
                }
                break;
            default:
                if(presenter.getSortOption()) {
                    presenter.setSortOption(false);
                    presenter.setChangeOption(true);
                }
                break;
        }

        // Avoinding change adapter and recyclerview many times with
        // the same option value
        if(presenter.getChangeOption()){
            // Creating a new adapter
            adapter = new MySortListAdapter(presenter.takeSortOption());
            adapter.createBlocks(presenter.getData());
            adapter.notifyDataSetChanged();

            // Changing the recyclerview layout and adapter
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            recyclerView.setAdapter(adapter);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void sendMessage(String message) {
        // Message communication from presenter
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
