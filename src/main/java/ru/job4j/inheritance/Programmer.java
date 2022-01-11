package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private int yearsOfExperience;

    public Programmer(String name, String surname, String education, String birthday, String projectName, int yearsOfExperience) {
        super(name, surname, education, birthday, projectName);
        this.yearsOfExperience = yearsOfExperience;
    }

    public void writeCode() {

    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
}
