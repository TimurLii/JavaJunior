package org.example.HW.HW3;

import java.io.Serializable;

public class Student  implements Serializable {
     private String name;
     private int age;
     private  transient   double GPA;


     public Student(String name, int age, double gpa)  {
          this.name = name;
          this.age = age;
          this.GPA = gpa;
     }

     @Override
     public String toString() {
          return "Student{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  ", GPA=" + GPA +
                  '}';
     }
}
