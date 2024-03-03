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

    public PeopleOnCourse(String nameFaculty, String nameKaf, OneStudent st) {
        super(nameFaculty, nameKaf);
        this.st = st;
    }

    public PeopleOnCourse(String nameFaculty, String nameKaf, OneTeacher teacher) {
        super(nameFaculty, nameKaf);
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

}
