package PeopleModel;

public class OneStudent extends People {
    int year = 0;

    String name;
    String surName;

    public OneStudent(String name, String surName, int year) {
        this.year = year;
        this.name = name;
        this.surName = surName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
