package org.example.Serialization_Lec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        String s = (String)objectInputStream.readObject();
        System.out.println(s);
    }
}
