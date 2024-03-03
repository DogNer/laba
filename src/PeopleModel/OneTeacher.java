package PeopleModel;

public class OneTeacher extends People{
    String kafedra;
    String faculty;
    String name;
    String surName;
    int id = 0;

    public OneTeacher(String name, String surName, String nameFaculty, String nameKafedra) {
        super(name, surName, nameFaculty, nameKafedra);
    }

    public OneTeacher(String name, String surName) {
        super(name, surName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
