package University;

import Models.ArrList;
import People.Student;
import People.Teacher;

import java.util.List;

public class Kafedra{
    Teacher tch;
    int numberOfSudents;

    String name;
    public List<Student> arrFaculty = new ArrList<>();

    public Teacher getTch() {
        return tch;
    }

    public int getNumberOfSudents() {
        return numberOfSudents;
    }

    public String getName() {
        return name;
    }

    public void setTch(Teacher tch) {
        this.tch = tch;
    }

    public void setNumberOfSudents(int numberOfSudents) {
        this.numberOfSudents = numberOfSudents;
    }

    public void setName(String name) {
        this.name = name;
    }
}
