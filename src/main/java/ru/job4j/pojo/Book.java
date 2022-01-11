package ru.job4j.pojo;

public class Book {
    private String name;
    private int pageNumbers;

    public Book(String name, int pageNumbers) {
        this.name = name;
        this.pageNumbers = pageNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(int pageNumbers) {
        this.pageNumbers = pageNumbers;
    }
}
