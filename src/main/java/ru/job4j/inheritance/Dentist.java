package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String toothSnapshot;

    public Dentist(String name, String surname, String education, String birthday, String specialization, String toothSnapshot) {
        super(name, surname, education, birthday, specialization);
        this.toothSnapshot = toothSnapshot;
    }

    public void treatTooth() {

    }

    public String getToothSnapshot() {
        return toothSnapshot;
    }
}
