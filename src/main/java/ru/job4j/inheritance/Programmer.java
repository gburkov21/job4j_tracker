package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private int yearsOfExperience;

    public Programmer(String name, String surname, String education, String birthday, int yearsOfExperience) {
        super(name, surname, education, birthday);
        this.yearsOfExperience = yearsOfExperience;
    }

    public Programmer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public void writeCode() {

    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
}
