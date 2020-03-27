package com.devproject.miguelfagundez.mysortapplication.model;

import com.devproject.miguelfagundez.mysortapplication.Interface;

import java.util.ArrayList;
import java.util.List;

/********************************************
 * MainModel
 * This is the model layer
 * @author: Miguel Fagundez
 * @date: March 26th, 2020
 * @version: 1.0
 * *******************************************/
public class MainModel implements Interface.model {

    private Interface.presenter presenter;

    public MainModel(Interface.presenter presenter){
        this.presenter = presenter;
    }

    //*************************************************
    // Generate initial data
    //*************************************************
    public List<CommentBlock> dataModel(){

        List<CommentBlock> friendList = new ArrayList<>();

        //****************************
        // Creating example data
        //****************************
        CommentBlock friend =new CommentBlock("Andrea",43,9);
        friendList.add(friend);

        friend = new CommentBlock("Carlos",31,7);
        friendList.add(friend);

        friend = new CommentBlock("Armando",29,3);
        friendList.add(friend);

        friend = new CommentBlock("Cesar",91,6);
        friendList.add(friend);

        friend = new CommentBlock("Miguel",45,7);
        friendList.add(friend);

        friend = new CommentBlock("Karina",76,9);
        friendList.add(friend);

        friend = new CommentBlock("Juanes",21,4);
        friendList.add(friend);

        friend = new CommentBlock("Zulay",49,12);
        friendList.add(friend);

        friend = new CommentBlock("Samantha",61,8);
        friendList.add(friend);

        friend = new CommentBlock("Rebeca",66,17);
        friendList.add(friend);

        friend = new CommentBlock("Mathew",33,9);
        friendList.add(friend);

        friend = new CommentBlock("John",61,11);
        friendList.add(friend);

        friend = new CommentBlock("Nancy",49,13);
        friendList.add(friend);

        friend = new CommentBlock("Linda",55,17);
        friendList.add(friend);

        friend = new CommentBlock("Veronica",22,10);
        friendList.add(friend);

        friend = new CommentBlock("Daniel",45,5);
        friendList.add(friend);

        friend = new CommentBlock("Roman",44,12);
        friendList.add(friend);

        friend = new CommentBlock("Carmen",66,8);
        friendList.add(friend);

        friend = new CommentBlock("Keny",29,2);
        friendList.add(friend);

        friend = new CommentBlock("Yesika",33,16);
        friendList.add(friend);

        friend = new CommentBlock("William",45,17);
        friendList.add(friend);

        // Communicating with presenter layer
        presenter.sendMessage("Data change successfully");
        // returning data
        return friendList;
    }
}
