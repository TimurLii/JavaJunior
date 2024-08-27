package org.example.Reflection_API_Sem.Task3;

import org.example.Reflection_API_Sem.Task3.Annotation.QueryBuilder;

import java.util.UUID;

public class Program {
    public static void main(String[] args) throws IllegalAccessException {
        Employee user = new Employee("Timur", "@mail.ru" );
        UUID pk = UUID.randomUUID();
        user.setId(pk);


        QueryBuilder queryBuilder = new QueryBuilder();


        String insertQuery = queryBuilder.buildInsertQuery(user);
        System.out.printf("Insert query: %s\n ", insertQuery );


        String SelectQuery = queryBuilder.buildSelectQuery(Employee.class,pk);
        System.out.printf("Select query: %s\n ", SelectQuery );

        String updateQuery = queryBuilder.buildUpdateQuery(user);
        System.out.println(updateQuery);


        String deleteQuery = queryBuilder.buildDeleteQuery(Employee.class, pk);
        System.out.println(deleteQuery);
    }
}
