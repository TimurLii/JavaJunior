package org.example.Serialization_Sem.Task1;

import java.io.Serializable;

public class UserData implements Serializable {

    //region Field

    private String name;
    private int age;
    private transient String password;

    //endregion

    //region Getter/Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //endregion

    //region Constructor

    public UserData(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    //endregion

    //region Method

    @Override
    public String toString() {
        return "UserData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }

    //endregion

}
