package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String housePlan;

    public Builder(String name, String surname, String education, String birthday, String projectName, String housePlan) {
        super(name, surname, education, birthday, projectName);
        this.housePlan = housePlan;
    }

    public void buildHouse() {

    }

    public String getHousePlan() {
        return housePlan;
    }
}
