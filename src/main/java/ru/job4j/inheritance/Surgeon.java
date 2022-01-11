package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String bodySnapshot;

    public Surgeon(String name, String surname, String education, String birthday, String specialization, String bodySnapshot) {
        super(name, surname, education, birthday, specialization);
        this.bodySnapshot = bodySnapshot;
    }

    public void performOperation() {

    }

    public String getBodySnapshot() {
        return bodySnapshot;
    }
}
