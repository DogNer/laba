package Tables;

import Models.ArrList;
import University.Faculty;

import java.util.List;

import static java.lang.Math.max;

public class FacultyTab{

    private List<Faculty> arrFaculty = new ArrList<>();

    public FacultyTab(List<Faculty> arrFaculty) {
        this.arrFaculty = arrFaculty;
    }

    public void getTable(List<String> field){
        for(int j = 0; j < field.size(); ++j) {
            int colomWidth = max(longName(), field.get(j).length());
            String s = writeFinalPart(colomWidth);
            s += "| " + field.get(j);
            for (int i = 0; i < colomWidth - field.get(j).length(); ++i)
                s += " ";
            s += " |\n" + writeFinalPart(colomWidth);

            for (int i = 0; i < arrFaculty.size(); ++i) {
                s += "| " + arrFaculty.get(i).getNameFaculty();
                for (int g = 0; g < colomWidth - arrFaculty.get(i).getNameFaculty().length(); ++g)
                    s += " ";
                s += " |\n";
            }

            s += writeFinalPart(colomWidth);
            System.out.println(s);
        }
    }

    private int longName(){
        int etalon = 0;
        for(int i = 0; i < arrFaculty.size(); ++i)
            etalon = max(etalon, arrFaculty.get(i).getNameFaculty().length());

        return etalon;
    }

    private String writeFinalPart(int length){
        String s = "+-";
        for(int i = 0; i < length; ++i)
            s += "-";

        s += "-+\n";

        return s;
    }
}
