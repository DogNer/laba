package University;

import Interfaces.FacultyRefactor;
import Interfaces.KafedraRefactor;
import Models.ArrList;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Faculty implements FacultyRefactor{

    private String nameFaculty = "Null";
    private String nameOfDecan = "Null";
    private List<Faculty> arrFaculty = new ArrList<>();
    public String[][] arrData = new String[4][1000];

    private int id = 0;

    public Faculty(String nameFaculty, String nameOfDecan) {
        this.nameFaculty = nameFaculty;
        this.nameOfDecan = nameOfDecan;
    }

    public Faculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public String[][] getArrData() {
        return arrData;
    }

    public void setArrData(String[][] arrData) {
        this.arrData = arrData;
    }

    public Faculty(String nameFaculty, String nameOfDecan, int id) {
        this.nameFaculty = nameFaculty;
        this.nameOfDecan = nameOfDecan;
        this.id = id;
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
        arrFaculty.add(el);

        arrData[0][0] = "id";
        arrData[1][0] = "Name";
        arrData[2][0] = "Decan";
        id++;
        arrData[0][id] = id + "";
        arrData[1][id] = el.nameFaculty;
        arrData[2][id] = el.nameOfDecan;
    }

    @Override
    public void remove(int pos) {
        arrFaculty.remove(pos-1);
        moveArrToDelete(pos);
    }

    private void moveArrToDelete(int pos){
        for(int i = 0 ; i < 3; ++i)
            for(int j = pos; j <= arrFaculty.size(); ++j)
                arrData[i][j] = arrData[i][j + 1];
    }

    @Override
    public void changeName(int pos, String newName) {
        arrFaculty.get(pos - 1).setNameFaculty(newName);
        arrData[1][pos] = newName;
    }

    @Override
    public void changeDecan(int pos, String newName) {
        arrFaculty.get(pos - 1).setNameOfDecan(newName);
        arrData[2][pos] = newName;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < arrFaculty.size(); ++i)
            s += arrFaculty.get(i).nameFaculty + "\n";

        return s;
    }
}