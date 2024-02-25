import Models.ArrList;
import University.Faculty;

import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Faculty fac = new Faculty();
        fac.addFaculty(new Faculty("Fi", "Gliba"));
        fac.addFaculty(new Faculty("FEN", "Null"));
        fac.addFaculty(new Faculty("FSNST", "Null"));
        System.out.println(fac);

        fac.changeName(1, "Baba");
        System.out.println(fac);

        fac.remove(1);
        System.out.println(fac);

    }
}