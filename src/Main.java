import Models.ArrList;
import University.Faculty;
import University.Uni;

import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Uni university = new Uni();
        university.addFaculty(new Faculty("fsd", "sdf"));
        university.addFaculty(new Faculty("RET", "fi"));

        System.out.println(university);
    }
}