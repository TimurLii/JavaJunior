package org.example.Serialization_Sem.Task2;

import java.io.Serializable;

public class ToDoV1 implements Serializable {

    //region Field
    private String title;
    private boolean isDone;

    //endregion

    //region Constructor
public ToDoV1(){

}

    //endregion

    //region Getter/Setter


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }


    //endregion

    //region Method

    @Override
    public String toString() {
        return "ToDoV1{" +
                "title='" + title + '\'' +
                ", isDone=" + isDone +
                '}';
    }

    //endregion

}
