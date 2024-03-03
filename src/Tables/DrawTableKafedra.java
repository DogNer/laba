package Tables;

import Models.ArrList;
import University.Faculty;
import University.Kafedra;

import java.util.List;

import static java.lang.Math.max;

public class DrawTableKafedra {
    String[] field = new String[3];

    public DrawTableKafedra() {
        field[0] = "id";
        field[1] = "Назва";
        field[2] = "Факультет";
    }

    public void getTable(List<Kafedra> list){
        String s = "+";
        List<Integer> colomWidth = new ArrList<>();
        colomWidth.add(max(longNameId(list), field[0].length()));
        s += writeFinalPart(colomWidth.get(0));

        colomWidth.add(max(longNameKafedra(list), field[1].length()));
        s += writeFinalPart(colomWidth.get(1));

        colomWidth.add(max(longNameFaculty(list), field[2].length()));
        s += writeFinalPart(colomWidth.get(2));

        s += '\n' + "|";
        for(int i = 0; i < 3; ++i){
            s += " " + field[i];
            for (int j = field[i].length(); j < colomWidth.get(i); ++j)
                s += " ";
            s += " |";
        }

        s += "\n+";
        for(int i = 0; i < 3; ++i){
            s += writeFinalPart(colomWidth.get(i));
        }

        for(int g = 0; g < list.size(); ++g){
            s += '\n' + "|";
            s += " " + list.get(g).getId();
            for (int j = String.valueOf(list.get(g).getId()).length(); j < colomWidth.get(0); ++j)
                s += " ";
            s += " |";

            s += " " + list.get(g).getNameKaf();
            for (int j = list.get(g).getNameKaf().length(); j < colomWidth.get(1); ++j)
                s += " ";
            s += " |";

            s += " " + list.get(g).getNameFaculty();
            for (int j = list.get(g).getNameFaculty().length(); j < colomWidth.get(2); ++j)
                s += " ";
            s += " |";
        }

        s += "\n+";
        for(int i = 0; i < 3; ++i){
            s += writeFinalPart(colomWidth.get(i));
        }

        System.out.println(s);
    }

    private int longNameId(List<Kafedra> faculty) {
        int etalon = 0;
        for (int i = 0; i < faculty.size(); ++i)
            etalon = max(etalon, String.valueOf(faculty.get(i).getId()).length());
        return etalon;
    }

    private int longNameFaculty(List<Kafedra> faculty) {
        int etalon = 0;
        for (int i = 0; i < faculty.size(); ++i)
            etalon = max(etalon, faculty.get(i).getNameFaculty().length());
        return etalon;
    }

    private int longNameKafedra(List<Kafedra> faculty) {
        int etalon = 0;
        for (int i = 0; i < faculty.size(); ++i)
            etalon = max(etalon, faculty.get(i).getNameKaf().length());
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
