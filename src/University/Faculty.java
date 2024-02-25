package University;

import Interfaces.FacultyRefactor;
import Interfaces.KafedraRefactor;
import Models.ArrList;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class Faculty implements KafedraRefactor {

    private String nameFaculty = "";
    private String nameOfDecan = "";
    public List<Kafedra> arrKafedra = new ArrList<>();

    public Faculty(String nameFaculty, String nameOfDecan) {
        this.nameFaculty = nameFaculty;
        this.nameOfDecan = nameOfDecan;
    }

    public Faculty() {
    }

    public int getNumberOfKafedra() {
        return arrKafedra.size();
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


    @Override
    public void addKafedra(Kafedra el) {
        arrKafedra.add(el);
    }

    @Override
    public void remove(int pos) {
        arrKafedra.remove(pos);
    }

    @Override
    public void changeName(int pos, String newName) {
        arrKafedra.get(pos).setName(newName);
    }
}
