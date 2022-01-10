package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String toothSnapshot;

    public Dentist(String name, String surname, String education, String birthday, String toothSnapshot) {
        super(name, surname, education, birthday);
        this.toothSnapshot = toothSnapshot;
    }

    public Dentist(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public void treatTooth() {

    }

    public String getToothSnapshot() {
        return toothSnapshot;
    }
}
