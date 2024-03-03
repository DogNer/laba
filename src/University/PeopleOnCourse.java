package University;

import Interfaces.PeopleInterface;
import Models.ArrList;
import PeopleModel.OneStudent;
import PeopleModel.OneTeacher;

import java.util.List;

public class PeopleOnCourse extends Kafedra implements PeopleInterface {

    List<PeopleOnCourse> arrPeople = new ArrList<>();

    OneStudent st;
    OneTeacher teacher;
    private int id = 0;
    String status = "";
    private String[][] arrDataPeople = new String[10][1000];

    public PeopleOnCourse(String nameKaf, OneStudent st) {
        super(nameKaf);
        this.st = st;
    }

    public PeopleOnCourse(String nameKaf, OneTeacher teacher) {
        super(nameKaf);
        this.teacher = teacher;
    }

    public PeopleOnCourse() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public OneStudent getSt() {
        return st;
    }

    public void setSt(OneStudent st) {
        this.st = st;
    }

    public OneTeacher getTeacher() {
        return teacher;
    }

    public void setTeacher(OneTeacher teacher) {
        this.teacher = teacher;
    }

    public List<PeopleOnCourse> getArrPeople() {
        return arrPeople;
    }

    public void setArrPeople(List<PeopleOnCourse> arrPeople) {
        this.arrPeople = arrPeople;
    }

    public String[][] getArrDataPeople() {
        return arrDataPeople;
    }

    public void setArrDataPeople(String[][] arrDataPeople) {
        this.arrDataPeople = arrDataPeople;
    }

    @Override
    public void addStudent(PeopleOnCourse st) {
        id++;
        st.setId(id);
        st.status = "Студент";
        arrPeople.add(st);

        arrDataPeople[0][0] = "id";
        arrDataPeople[1][0] = "Ім'я";
        arrDataPeople[2][0] = "Прізвище";
        arrDataPeople[3][0] = "Статус";
        arrDataPeople[4][0] = "Курс";

        arrDataPeople[0][id] = id + "";
        arrDataPeople[1][id] = st.getSt().getName();
        arrDataPeople[2][id] = st.getSt().getSurName();
        arrDataPeople[3][id] = st.status;
        arrDataPeople[4][id] = st.getSt().getYear() + "";
    }

    @Override
    public void addTeacher(PeopleOnCourse tch) {
        id++;
        tch.setId(id);
        tch.status = "Викладач";
        arrPeople.add(tch);

        arrDataPeople[0][0] = "id";
        arrDataPeople[1][0] = "Ім'я";
        arrDataPeople[2][0] = "Прізвище";
        arrDataPeople[3][0] = "Статус";
        arrDataPeople[4][0] = "Курс";

        arrDataPeople[0][id] = id + "";
        arrDataPeople[1][id] = tch.getTeacher ().getName();
        arrDataPeople[2][id] = tch.getTeacher().getSurName();
        arrDataPeople[3][id] = tch.status;
        arrDataPeople[4][id] = "Null";
    }

    @Override
    public void remove(int pos) {
        arrPeople.remove(pos-1);
        id--;
    }

    @Override
    public void changeName(int pos, OneStudent st) {
        arrPeople.get(pos - 1).setSt(st);
    }
}
