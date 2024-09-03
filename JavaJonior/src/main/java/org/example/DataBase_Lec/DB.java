package org.example.DataBase_Lec;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.*;

public class DB {
//    private static final String url = "jdbc:mysql://localhost:3306";
//    private static final String USER = "root";
//    private static final String PASSWORD = "1234";

    public static void con() {

         StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() //configures settings from hibernate.cfg.xml
                .build();
        SessionFactory sessionFactory = new MetadataSources( registry
        ).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Magic magic = new Magic("Волшебная стрела", 10, 0);
        session.beginTransaction();
        session.save(magic);
        session.getTransaction().commit();
        session.close();



        // код jdbc
//        try {
//            Connection con = DriverManager.getConnection(url, USER, PASSWORD);
//            Statement statement = con.createStatement();
//            statement.execute("DROP DATABASE  test");
//            statement.execute("CREATE DATABASE  test");
//            statement.execute("CREATE TABLE test.table (id int not null  , firstname varchar(45) null,lastname varchar(45) null ,  primary key (id))  ");
//            statement.execute("INSERT INTO test.table (id, firstname, lastname) VALUES (1, 'Иванов', 'Иван' );");
//            statement.execute("INSERT INTO test.table (id, firstname, lastname) VALUES (2, 'Петров', 'Пётр' );");
//            statement.execute("INSERT INTO test.table (id, firstname, lastname) VALUES (3, 'Сидоров', 'Иван' );");
//
//            ResultSet set = statement.executeQuery("SELECT  * FROM  test.table");
//            while(set.next()){
//                System.out.println(set.getString(3) + " "+ set.getString(2) + "  " + set.getInt(1));
//            }
//
//        } catch (SQLException e) {
//        }
    }
}
