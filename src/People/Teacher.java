package People;

public class Teacher extends People{
    String kafedra;

    public Teacher(String name, String surName, String kafedra) {
        super(name, surName);
        this.kafedra = kafedra;
    }

    public Teacher(String name, String surName) {
        super(name, surName);
    }

    public Teacher() {
    }

    public String getKafedra() {
        return kafedra;
    }

    public void setKafedra(String kafedra) {
        this.kafedra = kafedra;
    }
}
