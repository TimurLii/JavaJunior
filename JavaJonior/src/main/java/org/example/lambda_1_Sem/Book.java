package org.example.lambda_1_Sem;

public class Book {

    //region Constructor

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    //endregion

    //region Поля
    private final String name;
    private final String author;
    private final int year;
    //endregion

    //region Method

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    //endregion


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
