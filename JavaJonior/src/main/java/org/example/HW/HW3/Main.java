package org.example.HW.HW3;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student1 = new Student("Timur", 27, 4.2);
        Student student2 = new Student("Andrey", 14, 4.4);
        Student student3 = new Student("Elena", 22, 5);

        List<Student> students = new ArrayList<>();

        students.add(student1);
        students.add(student2);
        students.add(student3);


        saveUser("StudentList.bin", students);
        List<Student> students1 = loadFromFile("StudentList.bin");
        students1.forEach(el-> System.out.println(el));
    }

    private static void saveUser(String fileName, List<Student> students) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(students);
            }
        }
    }
    public static List<Student> loadFromFile(String fileName) throws ClassNotFoundException, IOException {
        List<Student> studentList = new ArrayList<>();
        File file = new File(fileName);
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file) )){
            studentList = (List<Student>) objectInputStream.readObject();
        }
        return studentList;

    }
}
/**
 * Поля, объявленные как transient, не выводятся при десериализации, потому что их значение не сохраняется
 * и не восстанавливается.
 * Это значит, что после десериализации такое поле будет равно его значению по умолчанию
 * (ноль, false или null в зависимости от типа поля).
 */