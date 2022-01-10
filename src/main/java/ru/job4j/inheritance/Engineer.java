package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String projectName;

    public Engineer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Engineer(String name, String surname, String education, String birthday, String projectName) {
        super(name, surname, education, birthday);
        this.projectName = projectName;
    }

    public void buildMechanism() {

    }

    public String getProjectName() {
        return projectName;
    }
}
