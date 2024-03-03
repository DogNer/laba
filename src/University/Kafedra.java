package University;

import Interfaces.KafedraRefactor;
import Interfaces.PeopleInterface;
import Models.ArrList;
import PeopleModel.OneStudent;
import PeopleModel.OneTeacher;

import java.util.List;

public class Kafedra extends Faculty implements PeopleInterface {
    private String nameKaf;
    private int idSt = 0, idTch = 0;
    private List<OneStudent> stList = new ArrList<>();
    private List<OneTeacher> tcList = new ArrList<>();

    public Kafedra(String nameFaculty, String nameKaf) {
        super(nameFaculty);
        this.nameKaf = nameKaf;
    }

    public Kafedra(String nameKaf) {
        this.nameKaf = nameKaf;
    }

    public Kafedra() {
    }

    public String getNameKaf() {
        return nameKaf;
    }

    public void setNameKaf(String nameKaf) {
        this.nameKaf = nameKaf;
    }

    public List<OneStudent> getStList() {
        return stList;
    }

    public void setStList(List<OneStudent> stList) {
        this.stList = stList;
    }

    public List<OneTeacher> getTcList() {
        return tcList;
    }

    public void setTcList(List<OneTeacher> tcList) {
        this.tcList = tcList;
    }

    @Override
    public void addStudent(OneStudent st) {
        idSt++;
        st.setId(idSt);
        stList.add(st);
    }

    @Override
    public void addTeacher(OneTeacher tch) {
        idTch++;
        tch.setId(idTch);
        tcList.add(tch);
    }

    @Override
    public void removeSt(int pos) {
        stList.remove(pos-1);
        idSt--;

        for(int i = 0; i < stList.size(); ++i)
            stList.get(i).setId(i + 1);
    }

    @Override
    public void removeTeacher(int pos) {
        tcList.remove(pos-1);
        idTch--;

        for(int i = 0; i < tcList.size(); ++i)
            tcList.get(i).setId(i + 1);
    }

    @Override
    public void changeNameStudent(int pos, OneStudent st) {
        stList.get(pos - 1).setName(st.getName());
        stList.get(pos - 1).setSurName(st.getSurName());
    }

    @Override
    public void changeNameTeacher(int pos, OneTeacher tch) {
        tcList.get(pos - 1).setName(tch.getName());
        tcList.get(pos - 1).setSurName(tch.getSurName());
    }
}
