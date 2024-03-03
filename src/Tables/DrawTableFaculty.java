package Tables;

import Models.ArrList;
import University.Faculty;

import java.util.List;

import static java.lang.Math.max;

public class DrawTableFaculty {
    String[] field = new String[2];

    public DrawTableFaculty() {
        field[0] = "id";
        field[1] = "Назва";
    }

    public void getTable(List<Faculty> list){

        String s = "+";
        List<Integer> colomWidth = new ArrList<>();
        colomWidth.add(max(longNameId(list), field[0].length()));
        s += writeFinalPart(colomWidth.get(0));

        colomWidth.add(max(longName(list), field[1].length()));
        s += writeFinalPart(colomWidth.get(1));

        s += '\n' + "|";
        for(int i = 0; i < 2; ++i){
            s += " " + field[i];
            for (int j = field[i].length(); j < colomWidth.get(i); ++j)
                s += " ";
            s += " |";
        }

        s += "\n+";
        for(int i = 0; i < 2; ++i){
            s += writeFinalPart(colomWidth.get(i));
        }

        for(int g = 0; g < list.size(); ++g){
            s += '\n' + "|";
            s += " " + list.get(g).getId();
            for (int j = String.valueOf(list.get(g).getId()).length(); j < colomWidth.get(0); ++j)
                s += " ";
            s += " |";

            s += " " + list.get(g).getNameFaculty();
            for (int j = list.get(g).getNameFaculty().length(); j < colomWidth.get(1); ++j)
                s += " ";
            s += " |";
        }

        s += "\n+";
        for(int i = 0; i < 2; ++i){
            s += writeFinalPart(colomWidth.get(i));
        }

        System.out.println(s);
    }

    private int longNameId(List<Faculty> faculty) {
        int etalon = 0;
        for (int i = 0; i < faculty.size(); ++i)
            etalon = max(etalon, String.valueOf(faculty.get(i).getId()).length());
        return etalon;
    }

    private int longName(List<Faculty> faculty) {
        int etalon = 0;
        for (int i = 0; i < faculty.size(); ++i)
            etalon = max(etalon, faculty.get(i).getNameFaculty().length());
        return etalon;
    }


    private String writeFinalPart(int length){
        String s = "-";
        for(int i = 0; i < length; ++i)
            s += "-";

        s += "-+";

        return s;
    }
}
