package org.example.HW.HW4;



import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            ArrayList<Person> personList = new ArrayList<>();
            personList.add(new Person("Ivan", 13));
            personList.add(new Person("Alex", 23));
            personList.add(new Person("Ivan", 13));
            personList.forEach(el -> session.save(el));
            System.out.println("Save person");




            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
