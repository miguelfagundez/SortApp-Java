package com.devproject.miguelfagundez.mysortapplication;

import com.devproject.miguelfagundez.mysortapplication.model.CommentBlock;

import java.util.List;

/********************************************
 * Interface - MVP
 * This is the interface that needs to be
 * implemented in order to have MVP architecture
 * @author: Miguel Fagundez
 * @date: March 26th, 2020
 * @version: 1.0
 * *******************************************/
public interface Interface {
    interface view{
        void sendMessage(String message);
    }

    interface presenter{
        List<CommentBlock> getData();
        boolean takeSortOption();
        void setSortOption(boolean value);
        boolean getSortOption();
        void setChangeOption(boolean value);
        boolean getChangeOption();
        void sendMessage(String message);
    }

    interface model{
        List<CommentBlock> dataModel();
    }
}
