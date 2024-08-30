package org.example.Serialization_Lec;

import java.io.*;
import java.util.ArrayList;

public class Main3 {
    public static void main(String[] args) throws  Exception {
         ArrayList<String> list = new ArrayList<>();
         for(int i = 0; i < 10; i++){
             list.add(Character.getName(i));
         }
         serialObject(list, "ser");
         list = (ArrayList) deSerialObject("ser");
        System.out.println(list);

    }
    public static void serialObject(ArrayList<String> o , String file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(o);
        objectOutputStream.close();
    }
    public static Object deSerialObject(String file ) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();
    }
}
