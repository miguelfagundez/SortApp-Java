package com.devproject.miguelfagundez.mysortapplication.presenter;

import com.devproject.miguelfagundez.mysortapplication.Interface;
import com.devproject.miguelfagundez.mysortapplication.model.CommentBlock;
import com.devproject.miguelfagundez.mysortapplication.model.MainModel;

import java.util.List;

/********************************************
 * MainPresenter
 * This is the presenter layer
 * @author: Miguel Fagundez
 * @date: March 26th, 2020
 * @version: 1.0
 * *******************************************/
public class MainPresenter implements Interface.presenter {

    // Connecting with other layers
    private Interface.view view;
    private Interface.model model;

    // logical decision members
    private boolean isAscending = true;
    private boolean changeData = true;

    public MainPresenter(Interface.view view){
        this.view = view;
        this.model = new MainModel(this);
    }

    // Communication with model layer
    public List<CommentBlock> getData(){
        return model.dataModel();
    }

    // Logical changed in the presenter. Communication with
    // model is not necessary
    @Override
    public boolean takeSortOption() {
        return isAscending;
    }

    @Override
    public void setSortOption(boolean value) {
        isAscending = value;
    }

    @Override
    public boolean getSortOption(){ return isAscending; }

    @Override
    public void setChangeOption(boolean value) {
        changeData = value;
    }

    @Override
    public boolean getChangeOption() {
        return changeData;
    }

    // Communicating with view layer
    @Override
    public void sendMessage(String message) {
        view.sendMessage(message);
    }
}
