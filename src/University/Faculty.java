package University;

public class Faculty {
    private int numberOfKafedra;
    private String nameFaculty = "";
    private String nameOfDecan = "";

    private Kafedra[] listKafedra;

    public Faculty(String nameFaculty, String nameOfDecan) {
        this.nameFaculty = nameFaculty;
        this.nameOfDecan = nameOfDecan;
    }

    public Faculty() {
    }

    @Override
    public String toString() {
        return "Name " + nameFaculty;
    }
}
