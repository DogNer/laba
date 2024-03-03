package University;

import Interfaces.FacultyRefactor;
import Interfaces.KafedraRefactor;
import Manager.UniManager;
import Models.ArrList;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Faculty implements FacultyRefactor{

    private String nameFaculty = "Null";
    private List<Faculty> arrFaculty = new ArrList<>();
    private String[][] arrDataFaculty = new String[4][1000];
    private int id = 0;

    public Faculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public String[][] getArrDataFaculty() {
        return arrDataFaculty;
    }

    public void setArrDataFaculty(String[][] arrDataFaculty) {
        this.arrDataFaculty = arrDataFaculty;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void addFaculty(Faculty el) {
        id++;
        el.setId(id);
        arrFaculty.add(el);

        arrDataFaculty[0][0] = "id";
        arrDataFaculty[1][0] = "Name";

        arrDataFaculty[0][id] = id + "";
        arrDataFaculty[1][id] = el.nameFaculty;
    }

    @Override
    public void removeFaculty(int pos) {
        arrFaculty.remove(pos-1);
        id--;
        moveArrToDelete(pos);
    }

    private void moveArrToDelete(int pos){
        for(int i = 1 ; i < 2; ++i)
            for(int j = pos; j <= arrFaculty.size(); ++j)
                arrDataFaculty[i][j] = arrDataFaculty[i][j + 1];
    }

    @Override
    public void changeName(int pos, String newName, Kafedra kf) {
        String oldName = arrFaculty.get(pos - 1).getNameFaculty();

        arrFaculty.get(pos - 1).setNameFaculty(newName);
        arrDataFaculty[1][pos] = newName;

        changeNameOnKafedra(oldName, newName, kf);
        changeNameInData(oldName, newName, kf);
    }

    //змінює назву кафедри у списку
    private void changeNameOnKafedra(String oldname, String newName, Kafedra kf){
        for(int i = 0; i < kf.getArrKafedra().size(); ++i)
            if (kf.getArrKafedra().get(i).getNameFaculty().equals(oldname))
                kf.getArrKafedra().get(i).setNameFaculty(newName);
    }

    private void changeNameInData(String oldname, String newName, Kafedra kf){
        for (int j = 0; j <= kf.getArrKafedra().size(); ++j)
            if (kf.getArrData()[2][j].equals(oldname))
                kf.getArrData()[2][j] = newName;
    }

    private static void outputAAArr(String[][] arr, int n, int m){
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < arrFaculty.size(); ++i)
            s += arrFaculty.get(i).nameFaculty + "\n";

        return s;
    }
}