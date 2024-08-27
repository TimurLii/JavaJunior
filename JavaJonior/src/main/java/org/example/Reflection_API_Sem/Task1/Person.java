package org.example.Reflection_API_Sem.Task1;

public class Person {
    //region fields

    private String name;
    private int age;
    //endregion

    //region Constructor

    public Person() {
        age = 23;
        name = "Name";
    }

    //endregion

    //region Method
    public void displayInfo() {
        System.out.printf("Имя : %s ; Возвраст : %d \n %n" , name, age);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
//endregion

}
