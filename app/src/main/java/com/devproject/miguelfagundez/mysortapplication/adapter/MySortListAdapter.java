package com.devproject.miguelfagundez.mysortapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devproject.miguelfagundez.mysortapplication.model.CommentBlock;
import com.devproject.miguelfagundez.mysortapplication.R;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import java.util.List;

/********************************************
 * MySortListAdapter - Base Adapter
 * Adapter that implements RecyclerView methods
 * SortedList methods are implemented also
 * @author: Miguel Fagundez
 * @date: March 26th, 2020
 * @version: 1.0
 * *******************************************/
public class MySortListAdapter extends RecyclerView.Adapter<MySortListAdapter.ViewHolder> {

    SortedList<CommentBlock> commentBlockList;

    public MySortListAdapter(boolean isAscending) {
        sortingBlocks(isAscending);
    }

    //***************************************************
    // SortedList methods
    //***************************************************
    public void sortingBlocks(final Boolean mAscending){
        commentBlockList = new SortedList<>(CommentBlock.class, new SortedList.Callback<CommentBlock>() {
            @Override
            public int compare(CommentBlock block1, CommentBlock block2) {
                if(mAscending) return block1.getName().compareTo(block2.getName());
                else return block2.getName().compareTo(block1.getName());
            }

            @Override
            public boolean areContentsTheSame(CommentBlock block1, CommentBlock block2) {
                return block1.getName().equals(block2.getName());
            }

            @Override
            public void onChanged(int position, int count) {
                notifyItemRangeChanged(position, count);
            }

            @Override
            public boolean areItemsTheSame(CommentBlock block1, CommentBlock block2) {
                return block1.getName().equals(block2.getName());
            }

            @Override
            public void onInserted(int position, int count) {
                notifyItemRangeInserted(position, count);
            }

            @Override
            public void onRemoved(int position, int count) {
                notifyItemRangeRemoved(position, count);
            }

            @Override
            public void onMoved(int fromPosition, int toPosition) {
                notifyItemMoved(fromPosition, toPosition);
            }
        });

    }

    // Creating blocks to use into the Adapter
    public void createBlocks(List<CommentBlock> myBlockList) {
        commentBlockList.beginBatchedUpdates();
        for (int i = 0; i < myBlockList.size(); i++) {
            commentBlockList.add(myBlockList.get(i));
        }
        commentBlockList.endBatchedUpdates();
    }

    //***************************************************
    // Recycler View methods
    //***************************************************

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_model, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CommentBlock block = commentBlockList.get(position);
        holder.tvName.setText(block.getName());
        holder.tvNumberPeople.setText(String.valueOf(block.getNumberOfFriends()));
        holder.tvMessages.setText(String.valueOf(block.getMessages()));
    }

    @Override
    public int getItemCount() {
        return commentBlockList.size();
    }

    //***************************
    // Internal ViewHolder
    //***************************
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvNumberPeople;
        TextView tvMessages;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvNumberPeople = itemView.findViewById(R.id.tvNumberPeople);
            tvMessages = itemView.findViewById(R.id.tvMessages);
        }
    }
}
