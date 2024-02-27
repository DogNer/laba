import Models.ArrList;
import Tables.FacultyTab;
import University.Faculty;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Faculty fac = new Faculty();
        fac.addFaculty(new Faculty("FEN", "GLIBA"));
        fac.addFaculty(new Faculty("FI", "Neznau"));
        System.out.println(fac);

        FacultyTab tab = new FacultyTab(fac.getArrFaculty());
        List<String> names = new ArrList<>();
        names.add("id");
        names.add("Name");
        tab.getTable(names);
    }
}