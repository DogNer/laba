package University;

import Interfaces.KafedraRefactor;
import Models.ArrList;
import People.Student;
import People.Teacher;
import Tables.DrawTable;

import javax.xml.crypto.Data;
import java.util.List;

public class Kafedra extends Faculty implements KafedraRefactor{
    private Teacher tch;
    private int numberOfSudents;
    private String nameKaf;
    private int id = 0;
    private List<Kafedra> arrKafedra = new ArrList<>();
    public String[][] arrData = new String[4][1000];

    DrawTable dw = new DrawTable();

    public Kafedra(String nameFaculty, String nameKaf, Teacher tch) {
        super(nameFaculty);
        this.tch = tch;
        this.nameKaf = nameKaf;

    }

    public Kafedra() {
    }

    @Override
    public void addKafedra(Kafedra el) {
        arrKafedra.add(el);

        arrData[0][0] = "id";
        arrData[1][0] = "Name";
        id++;
        arrData[0][id] = id + "";
        arrData[1][id] = el.nameKaf;
        arrData[2][id] = el.tch.getKafedra();
    }

    public Teacher getTch() {
        return tch;
    }

    public void setTch(Teacher tch) {
        this.tch = tch;
    }

    public int getNumberOfSudents() {
        return numberOfSudents;
    }

    public void setNumberOfSudents(int numberOfSudents) {
        this.numberOfSudents = numberOfSudents;
    }

    public String getNameKaf() {
        return nameKaf;
    }

    public void setNameKaf(String nameKaf) {
        this.nameKaf = nameKaf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Kafedra> getArrKafedra() {
        return arrKafedra;
    }

    public void setArrKafedra(List<Kafedra> arrKafedra) {
        this.arrKafedra = arrKafedra;
    }

    public String[][] getArrData() {
        return arrData;
    }

    public void setArrData(String[][] arrData) {
        this.arrData = arrData;
    }

    @Override
    public void remove(int pos) {
        arrKafedra.remove(pos-1);
        moveArrToDelete(pos);
    }

    private void moveArrToDelete(int pos){
        for(int i = 0 ; i < 2 ; ++i)
            for(int j = pos; j <= arrKafedra.size(); ++j)
                arrData[i][j] = arrData[i][j + 1];
    }


    @Override
    public void changeName(int pos, String newName) {

    }

    @Override
    public void teacherName(int pos, String newSurname) {

    }
}
