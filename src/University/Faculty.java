package University;

import Interfaces.FacultyRefactor;
import Interfaces.KafedraRefactor;
import Models.ArrList;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class Faculty implements FacultyRefactor{

    private String nameFaculty = "";
    private String nameOfDecan = "";
    private List<Faculty> arrFaculty = new ArrList<>();
    private int id;

    public Faculty(String nameFaculty, String nameOfDecan) {
        this.nameFaculty = nameFaculty;
        this.nameOfDecan = nameOfDecan;
    }

    public Faculty() {
    }

    public List<Faculty> getArrFaculty() {
        return arrFaculty;
    }

    public void setArrFaculty(List<Faculty> arrFaculty) {
        this.arrFaculty = arrFaculty;
    }

    public int getNumberOfKafedra() {
        return arrFaculty.size();
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public String getNameOfDecan() {
        return nameOfDecan;
    }

    public void setNameOfDecan(String nameOfDecan) {
        this.nameOfDecan = nameOfDecan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void addFaculty(Faculty el) {
        el.id = arrFaculty.size();
        arrFaculty.add(el);
    }

    @Override
    public void remove(int pos) {
        arrFaculty.remove(pos);
    }

    @Override
    public void changeName(int pos, String newName) {
        arrFaculty.get(pos).setNameFaculty(newName);
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < arrFaculty.size(); ++i)
            s += arrFaculty.get(i).nameFaculty + "\n";

        return s;
    }
}
