package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String housePlan;

    public Builder(String name, String surname, String education, String birthday, String housePlan) {
        super(name, surname, education, birthday);
        this.housePlan = housePlan;
    }

    public Builder(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public void buildHouse() {

    }

    public String getHousePlan() {
        return housePlan;
    }
}
