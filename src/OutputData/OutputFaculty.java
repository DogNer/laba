package OutputData;

import PeopleModel.OneStudent;
import Tables.DrawTablePeople;
import University.Faculty;

import java.util.ArrayList;
import java.util.List;

/**
 * Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом.
 */
public class OutputFaculty {
    private List<OneStudent> listPeople = new ArrayList<>();
    public OutputFaculty() {
    }

    public void getSortStudents(Faculty faculty, int pos){
        formTableWithEveryone(faculty, pos - 1);
        DrawTablePeople dw = new DrawTablePeople();
        sortCourse();
        dw.getTable(listPeople);
    }

    public void formTableWithEveryone(Faculty faculty, int pos){
        for(int j = 0; j < faculty.getArrFaculty().get(pos).getListKafedra().size(); ++j){
            for(int g = 0; g < faculty.getArrFaculty().get(pos).getListKafedra().get(j).getStList().size(); ++g) {
                    listPeople.add(faculty.getArrFaculty().get(pos).getListKafedra().get(j).getStList().get(g));
            }
        }
    }

    public void sortCourse(){
        for(int j = 0; j < listPeople.size() - 1; ++j)
            for(int i = 0; i < listPeople.size() - 1; ++i) {
                if (comp(listPeople.get(i).getSurName(), listPeople.get(i + 1).getSurName()))
                    sortEl(listPeople.get(i), listPeople.get(i + 1));
            }
    }

    private boolean comp(String a, String b){
        String uaAlSmall = "абвгдеґіїжзийклмнопрстуфхцчшщьєюя";

        if (uaAlSmall.indexOf(Character.toLowerCase(a.charAt(0))) == -1) {
            for (int i = 0; i < Math.min(a.length(), b.length()); ++i)
                if (a.charAt(i) > b.charAt(i))
                    return true;
                else if (a.charAt(i) < b.charAt(i))
                    return false;
        }
        else {
            for (int i = 0; i < Math.min(a.length(), b.length()); ++i)
                if (Character.toLowerCase(a.charAt(i)) > Character.toLowerCase(b.charAt(i)))
                    return true;
                else if (Character.toLowerCase(a.charAt(i)) < Character.toLowerCase(b.charAt(i)))
                    return false;
        }

        return false;
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
