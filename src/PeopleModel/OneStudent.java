package PeopleModel;

public class OneStudent extends People implements Cloneable{
    int id = 0;
    int year = 0;
    String name = "";
    String surName = "";

    public OneStudent(String name, String surName, String nameFaculty, String nameKafedra, int year) {
        super(name, surName, nameFaculty, nameKafedra);
        this.year = year;
    }

    public OneStudent(String name, String surName) {
        super(name, surName);
    }

    public OneStudent(String name, String surName, String nameFaculty, String nameKafedra, int id, int year) {
        super(name, surName, nameFaculty, nameKafedra);
        this.id = id;
        this.year = year;
    }

    public OneStudent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "OneStudent{" +
                "year=" + year +
                ", name='" + getName() + '\'' +
                ", surName='" + getSurName() + '\'' +
                ", nameFaculty='" + nameFaculty + '\'' +
                ", nameKafedra='" + nameKafedra + '\'' +
                "} " + super.toString();
    }



    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
