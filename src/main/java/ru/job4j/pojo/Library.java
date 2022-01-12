package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book firstBook = new Book("Clean Code", 500);
        Book secondBook = new Book("Head First Java", 600);
        Book thirdBook = new Book("Spring in Action", 700);
        Book fourthBook = new Book("Hibernate in Action", 800);

        Book[] bookArray = {firstBook, secondBook, thirdBook, fourthBook};
        for (int i = 0; i < bookArray.length; i++) {
            Book book = bookArray[i];
            System.out.println("Название: " + book.getName() + ", количество страниц: " + book.getPageNumbers());
        }
        Book tmpBook = bookArray[0];
        bookArray[0] = bookArray[3];
        bookArray[3] = tmpBook;
        for (Book book : bookArray) {
            System.out.println("Название: " + book.getName() + ", количество страниц: " + book.getPageNumbers());
        }
        for (Book book : bookArray) {
            if ("Clean Code".equals(book.getName())) {
                System.out.println("Название: " + book.getName() + ", количество страниц: " + book.getPageNumbers());
            }
        }
    }
}
