package PeopleModel;

public class People {
    String name;
    String surName;
    String nameFaculty;
    String nameKafedra;

    public People(String name, String surName, String nameFaculty, String nameKafedra) {
        this.name = name;
        this.surName = surName;
        this.nameFaculty = nameFaculty;
        this.nameKafedra = nameKafedra;
    }

    public People(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public People() {
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

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public String getNameKafedra() {
        return nameKafedra;
    }

    public void setNameKafedra(String nameKafedra) {
        this.nameKafedra = nameKafedra;
    }
}
