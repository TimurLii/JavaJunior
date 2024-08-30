package org.example.Serialization_Sem.Task1;

import java.io.*;

public class Program {
    public static void main(String[] args) {
        UserData user = new UserData("Timur", 27, "kaka");

        try (FileOutputStream fileOutputStream = new FileOutputStream("Sem_Ser.bin")) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(user);
                System.out.println("Объект UserData сериализован.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream fileInputStream= new FileInputStream("Sem_Ser.bin")) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                user = (UserData) objectInputStream.readObject();
                System.out.println("Объект UserData прочитан.");
                System.out.println(user.toString());
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
