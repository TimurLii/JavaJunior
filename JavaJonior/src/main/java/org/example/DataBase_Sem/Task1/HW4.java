package org.example.DataBase_Sem.Task1;


import org.example.DataBase_Sem.Task1.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class HW4 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306";
        String USER = "root";
        String PASSWORD = "1234";

        try {
            Connection connection = DriverManager.getConnection(url, USER, PASSWORD);
            createDatabase(connection);
            System.out.println("DB created");

            useDatabase(connection);
            System.out.println("Use DB");

            createTable(connection);
            System.out.println("Create table");

            Person person = new Person("Jon", 22);
            Person person1 = new Person("Tim", 23);
            Person person2 = new Person("Max", 21);
            insertData(connection, person);
            insertData(connection, person1);
            insertData(connection, person2);
            System.out.println("Insert data");


            Collection<Person> personList = readData(connection);
            for (var el : personList) {
                System.out.println(el);
            }
            System.out.println("Read data ");

            for(var el :  personList){
                System.out.println(el);
                deleteData(connection , el.getId());
             }
            System.out.println("Delete data");

            Collection<Person> personList1 = readData(connection);
            for (var el : personList1) {
                System.out.println(el);
            }
            System.out.println("Read data ");
            connection.close();
            System.out.println("Database close ");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void createDatabase(Connection connection) throws SQLException {
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS students;";
        try (PreparedStatement statement = connection.prepareStatement(createDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void useDatabase(Connection connection) throws SQLException {
        String userDatabaseSQL = "USE students;";
        try (PreparedStatement statement = connection.prepareStatement(userDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS  students (id INT  AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50) , age INT);";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }

    private static void insertData(Connection connection, Person person) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO  students (name , age ) VALUES(?,?);")) {
            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
            statement.executeUpdate();
        }
    }

    private static Collection<Person> readData(Connection connection) throws SQLException {
        ArrayList<Person> personList = new ArrayList<>();
        String readDataSQL = "SELECT * FROM students;";
        try (PreparedStatement statement = connection.prepareStatement(readDataSQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                personList.add(new Person(id, name, age));
            }
            return personList;
        }
    }


    private static void updateData(Connection connection, Person person) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE  students SET name =? , age = ? WHERE id = ?;")) {
            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
            statement.setInt(3, person.getId());
            statement.executeUpdate();
        }
    }

    private static void deleteData(Connection connection,int id) throws SQLException {
        String deleteDataSQL = "DELETE FROM students where id = ? ;";
        try (PreparedStatement statement = connection.prepareStatement(deleteDataSQL)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }

}
