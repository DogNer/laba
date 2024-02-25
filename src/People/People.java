package People;

public class People {
    String name;
    String surName;
    String nameFaculty;

    public People(String name, String surName, String nameFaculty) {
        this.name = name;
        this.surName = surName;
        this.nameFaculty = nameFaculty;
    }

    public People(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public People() {
    }
}
