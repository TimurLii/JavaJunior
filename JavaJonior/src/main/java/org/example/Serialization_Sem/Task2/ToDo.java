package org.example.Serialization_Sem.Task2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ToDo implements Externalizable {

    //region Field

    private String title;
    private boolean isDone;

    //endregion

    //region Constructor
    public ToDo(String newTaskTitle) {
this.title = newTaskTitle;
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

    //region ImplMethod
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeBoolean(isDone);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title  = (String) in.readObject();
        isDone = in.readBoolean();
    }
    //endregion


}
