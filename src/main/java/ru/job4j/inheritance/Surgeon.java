package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String bodySnapshot;

    public Surgeon(String name, String surname, String education, String birthday, String bodySnapshot) {
        super(name, surname, education, birthday);
        this.bodySnapshot = bodySnapshot;
    }

    public Surgeon(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public void performOperation() {

    }

    public String getBodySnapshot() {
        return bodySnapshot;
    }
}
