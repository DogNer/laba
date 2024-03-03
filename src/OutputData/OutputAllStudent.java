package OutputData;

import Models.ArrList;
import PeopleModel.OneStudent;
import Tables.DrawTablePeople;
import University.Faculty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class OutputAllStudent {

    List<Faculty> listStudent = new ArrList<>();
    List<OneStudent> stList = new ArrList<>();

    public void setListStudent(List<Faculty> listStudent) {
        this.listStudent = listStudent;
    }

    public void getSortStudents() throws CloneNotSupportedException{
        formTableWithEveryone();
        sortCourse();
        DrawTablePeople dw = new DrawTablePeople();
        dw.getTable(stList);
    }

    public void formTableWithEveryone() throws CloneNotSupportedException {
        int sizeFaculty = listStudent.size();

        for(int i = 0; i < sizeFaculty; ++i){
            for(int j = 0; j < listStudent.get(i).getListKafedra().size(); ++j){
                for(int g = 0; g < listStudent.get(i).getListKafedra().get(j).getStList().size(); ++g) {
                    stList.add((OneStudent) listStudent.get(i).getListKafedra().get(j).getStList().get(g).clone());
                }
            }
        }
    }

    public void sortCourse(){
        for(int j = 0; j < stList.size() - 1; ++j)
            for(int i = 0; i < stList.size() - 1; ++i) {
                if (stList.get(i).getYear() > stList.get(i + 1).getYear())
                    sortEl(stList.get(i), stList.get(i + 1));
        }
    }

    private void sortEl(OneStudent a, OneStudent b){
        OneStudent tmp = new OneStudent();
        setField(tmp, a);
        setField(a, b);
        setField(b, tmp);
    }

    private void setField(OneStudent a, OneStudent b){
        a.setId(b.getId());
        a.setName(b.getName());
        a.setSurName(b.getSurName());
        a.setYear(b.getYear());
        a.setNameKafedra(b.getNameKafedra());
        a.setNameFaculty(b.getNameFaculty());
    }
}
