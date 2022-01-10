package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public void printInfo() {
        System.out.println("Состояние: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error emptyError = new Error();
        emptyError.printInfo();
        Error firstError = new Error(true, 404, "Not Found");
        firstError.printInfo();
        Error secondError = new Error(true, 502, "Bad Gateway");
        secondError.printInfo();
    }
}
