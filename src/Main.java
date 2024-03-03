import OutputData.OutputAllStudent;
import OutputData.OutputFaculty;
import PeopleModel.OneStudent;
import Tables.DrawTableFaculty;
import Tables.DrawTableKafedra;
import Tables.DrawTablePeople;
import University.Faculty;
import University.Kafedra;
import University.UniversityMenu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        UniversityMenu menu = new UniversityMenu();
        //menu.runMenu();

        Faculty fac = new Faculty();
        fac.addFaculty(new Faculty("Fi"));
        fac.getArrFaculty().get(0).addKafedra(new Kafedra("Fi", "math"));
        fac.addFaculty(new Faculty("Fen"));
        fac.getArrFaculty().get(1).addKafedra(new Kafedra("Fen", "non"));

        fac.getArrFaculty().get(0).addKafedra(new Kafedra(fac.getArrFaculty().get(0).getNameFaculty(), "phisic"));
        fac.getArrFaculty().get(0).addKafedra(new Kafedra(fac.getArrFaculty().get(0).getNameFaculty(), "dfg"));

        DrawTableKafedra drawTableKafedra = new DrawTableKafedra();
        drawTableKafedra.getTable(fac.getArrFaculty().get(0).getListKafedra());

        fac.getArrFaculty().get(0).getListKafedra().get(0).addStudent(new OneStudent("nana", "mush",
                "Fi", "math", 1));
        fac.getArrFaculty().get(0).getListKafedra().get(0).addStudent(new OneStudent("df", "acb",
                "Fi", "SDF", 3));

        fac.getArrFaculty().get(1).getListKafedra().get(0).addStudent(new OneStudent("dansdf", "muasdfsh",
                "Fen", "math", 1));
        fac.getArrFaculty().get(1).getListKafedra().get(0).addStudent(new OneStudent("dsdff", "xcbasdf",
                "Fen", "SDF", 2));



        List<Faculty> arr = new ArrayList<>(fac.getArrFaculty());
        OutputAllStudent ou = new OutputAllStudent();
        ou.setListStudent(fac.getArrFaculty());
        ou.getSortStudents();

        OutputFaculty outputFaculty = new OutputFaculty();
        outputFaculty.getSortStudents(fac, 1);



        DrawTablePeople tablPeople = new DrawTablePeople();
        tablPeople.getTable(fac.getArrFaculty().get(0).getListKafedra().get(0).getStList());

    }

    private static void outputAAArr(String[][] arr, int n, int m){
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}

