package PeopleModel;

public class OneTeacher extends People{
    String kafedra;
    String name;
    String surName;

    public OneTeacher(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public OneTeacher() {
    }

    public String getKafedra() {
        return kafedra;
    }

    public void setKafedra(String kafedra) {
        this.kafedra = kafedra;
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
