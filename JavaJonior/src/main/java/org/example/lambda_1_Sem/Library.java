package org.example.lambda_1_Sem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Преступление и наказание", "Фёдор Достоевский", 1866));
        bookList.add(new Book("Евгений Онегин", "Флександр Пушкин", 1833));
        bookList.add(new Book("Война и мир", "Лев Толстой", 1869));
        bookList.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));


        List<Book> newBookList = bookList.stream().filter(el -> el.getAuthor().equals("Лев Толстой")).collect(Collectors.toList());
        newBookList.forEach(System.out::println);
        System.out.println(bookList.stream().filter(el -> el.getYear() >= 1869).collect(Collectors.toSet()));
        bookList.stream().map(Book::getName).distinct().forEach(System.out::println);

    }


}
