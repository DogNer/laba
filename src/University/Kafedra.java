package University;

import Interfaces.KafedraRefactor;
import Models.ArrList;
import People.Student;
import People.Teacher;

import java.util.List;

public class Kafedra implements KafedraRefactor {
    Teacher tch;
    int numberOfSudents;

    String name;
    int indexOfFaculty;
    public List<Kafedra> arrKafedra = new ArrList<>();

    public Kafedra(String name, int indexOfFaculty) {
        this.name = name;
        this.indexOfFaculty = indexOfFaculty;
    }

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

    public int getIndexOfFaculty() {
        return indexOfFaculty;
    }

    public void setIndexOfFaculty(int indexOfFaculty) {
        this.indexOfFaculty = indexOfFaculty;
    }

    @Override
    public void addKafedra(Kafedra el) {
        Faculty faculty = new Faculty();
        List<Faculty> arr = faculty.getArrFaculty();
        for (Faculty in : arr){
            if (in.getId() == el.indexOfFaculty)
                arrKafedra.add(el);
        }
    }

    @Override
    public void remove(int pos) {

    }

    @Override
    public void changeName(int pos, String newName) {

    }
}
