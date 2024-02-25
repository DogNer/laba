package University;

import Interfaces.FacultyRefactor;
import Models.ArrList;

import java.util.List;

public class Uni implements FacultyRefactor {
    private int numberOfFaculty = 0;
    public List<Faculty> arrFaculty = new ArrList<>();

    public Uni() {
    }

    @Override
    public void addFaculty(Faculty el) {
        arrFaculty.add(el);
        numberOfFaculty++;
    }

    @Override
    public void remove(int pos) {
        arrFaculty.remove(pos);
        numberOfFaculty--;
    }

    @Override
    public void changeName(int pos, String newName) {
        arrFaculty.get(pos).setNameFaculty(newName);
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < arrFaculty.size(); ++i)
            s += arrFaculty.get(i).getNameFaculty() + '\n';

        return s;
    }
}
