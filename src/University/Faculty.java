package University;

import Interfaces.FacultyRefactor;
import Models.ArrList;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class Faculty implements FacultyRefactor{
    private int numberOfKafedra;
    private String nameFaculty = "";
    private String nameOfDecan = "";
    public List<Faculty> arrFaculty = new ArrList<>();

    private Kafedra[] listKafedra;

    public Faculty(String nameFaculty, String nameOfDecan) {
        this.nameFaculty = nameFaculty;
        this.nameOfDecan = nameOfDecan;
    }

    public Faculty() {
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < arrFaculty.size(); ++i){
            s += "Факультет: " + arrFaculty.get(i).nameFaculty + "\n";
        }

        return s;
    }

    @Override
    public void addFaculty(Faculty el) {
        arrFaculty.add(el);
    }

    @Override
    public void remove(int pos) {
        arrFaculty.remove(pos);
    }

    @Override
    public void changeName(int pos, String newName) {
        arrFaculty.get(pos).nameFaculty = newName;
    }
}
