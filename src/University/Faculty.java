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
    private int id = 0, idKafedra = 0;

    private List<Kafedra> listKafedra = new ArrList<>();
    private String[][] dataKafedraList = new String[10][1000];

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

    public List<Kafedra> getListKafedra() {
        return listKafedra;
    }

    public void setListKafedra(List<Kafedra> listKafedra) {
        this.listKafedra = listKafedra;
    }

    public String[][] getDataKafedraList() {
        return dataKafedraList;
    }

    public void setDataKafedraList(String[][] dataKafedraList) {
        this.dataKafedraList = dataKafedraList;
    }

    @Override
    public void addFaculty(Faculty el) {
        id++;
        el.setId(id);
        arrFaculty.add(el);
    }

    @Override
    public void removeFaculty(int pos) {
        arrFaculty.remove(pos-1);
        id--;

        for(int i = 0; i < arrFaculty.size(); ++i)
            arrFaculty.get(i).setId(i + 1);
    }

    @Override
    public void changeName(int pos, String newName) {
        String oldName = arrFaculty.get(pos - 1).getNameFaculty();

        arrFaculty.get(pos - 1).setNameFaculty(newName);

        for(int i = 0; i < arrFaculty.get(pos - 1).getListKafedra().size(); ++i)
            if (oldName.equals(arrFaculty.get(pos - 1).getListKafedra().get(i).getNameFaculty()))
                arrFaculty.get(pos - 1).getListKafedra().get(i).setNameFaculty(newName);

        for(int i = 0; i < arrFaculty.get(pos - 1).getListKafedra().size(); ++i)
            for(int j = 0; j < arrFaculty.get(pos - 1).getListKafedra().get(i).getStList().size(); ++j)
                if (oldName.equals(arrFaculty.get(pos - 1).getListKafedra().get(i).getStList().get(j).getNameFaculty()))
                    arrFaculty.get(pos - 1).getListKafedra().get(i).getStList().get(j).setNameFaculty(newName);

        for(int i = 0; i < arrFaculty.get(pos - 1).getListKafedra().size(); ++i)
            for(int j = 0; j < arrFaculty.get(pos - 1).getListKafedra().get(i).getTcList().size(); ++j)
                if (oldName.equals(arrFaculty.get(pos - 1).getListKafedra().get(i).getTcList().get(j).getNameFaculty()))
                    arrFaculty.get(pos - 1).getListKafedra().get(i).getTcList().get(j).setNameFaculty(newName);
    }

    @Override
    public void addKafedra(Kafedra kf) {
        idKafedra++;
        kf.setId(idKafedra);
        listKafedra.add(kf);
    }

    @Override
    public void removeKafedra(int indexFac, int pos) {
        listKafedra.remove(pos-1);
        idKafedra--;

        for(int i = 0; i < listKafedra.size(); ++i)
            listKafedra.get(i).setId(i + 1);
    }

    @Override
    public void changeNameKafedra(int pos, String newName) {
        String oldName = listKafedra.get(pos - 1).getNameKaf();

        listKafedra.get(pos - 1).setNameKaf(newName);

        for (int i = 0; i < listKafedra.get(pos - 1).getStList().size(); ++i)
            if (oldName.equals(listKafedra.get(pos - 1).getStList().get(i).getNameKafedra()))
                listKafedra.get(pos - 1).getStList().get(i).setNameKafedra(newName);

        for (int i = 0; i < listKafedra.get(pos - 1).getTcList().size(); ++i)
            if (oldName.equals(listKafedra.get(pos - 1).getTcList().get(i).getNameKafedra()))
                listKafedra.get(pos - 1).getTcList().get(i).setNameKafedra(newName);
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < arrFaculty.size(); ++i)
            s += arrFaculty.get(i).nameFaculty + "\n";

        return s;
    }
}