package com.devproject.miguelfagundez.mysortapplication.model;

/********************************************
 * CommentBlock - Base Model class
 * This class handle basic information that
 * is showed in the RecyclerView
 * @author: Miguel Fagundez
 * @date: March 26th, 2020
 * @version: 1.0
 * *******************************************/
public class CommentBlock {

    private String name;
    private int numberOfFriends;
    private int messages;

    public CommentBlock(String name, int numberOfFriends, int messages) {
        this.name = name;
        this.numberOfFriends = numberOfFriends;
        this.messages = messages;
    }

    //**************************************
    // In this example only needs getters
    //**************************************
    public String getName() {
        return name;
    }

    public int getNumberOfFriends() {
        return numberOfFriends;
    }

    public int getMessages() {
        return messages;
    }

}

