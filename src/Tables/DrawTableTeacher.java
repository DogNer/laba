package Tables;

import Models.ArrList;
import PeopleModel.OneStudent;
import PeopleModel.OneTeacher;

import java.util.List;

import static java.lang.Math.max;

public class DrawTableTeacher {
    String[] field = new String[5];

    public DrawTableTeacher() {
        field[0] = "id";
        field[1] = "Ім'я";
        field[2] = "Прізвище";
        field[3] = "Кафедра";
        field[4] = "Факультет";
    }

    public void getTable(List<OneTeacher> list){
        String s = "+";
        List<Integer> colomWidth = new ArrList<>();

        colomWidth.add(max(longNameId(list), field[0].length()));
        s += writeFinalPart(colomWidth.get(0));

        colomWidth.add(max(longName(list), field[1].length()));
        s += writeFinalPart(colomWidth.get(1));

        colomWidth.add(max(longSurName(list), field[2].length()));
        s += writeFinalPart(colomWidth.get(2));

        colomWidth.add(max(longNameKafedra(list), field[3].length()));
        s += writeFinalPart(colomWidth.get(3));

        colomWidth.add(max(longNameFaculty(list), field[4].length()));
        s += writeFinalPart(colomWidth.get(4));


        s += '\n' + "|";
        for(int i = 0; i < field.length; ++i){
            s += " " + field[i];
            for (int j = field[i].length(); j < colomWidth.get(i); ++j)
                s += " ";
            s += " |";
        }

        s += "\n+";
        for(int i = 0; i < field.length; ++i){
            s += writeFinalPart(colomWidth.get(i));
        }

        for(int g = 0; g < list.size(); ++g){
            //id
            s += '\n' + "|";
            s += " " + list.get(g).getId();
            for (int j = String.valueOf(list.get(g).getId()).length(); j < colomWidth.get(0); ++j)
                s += " ";
            s += " |";

            //name
            s += " " + list.get(g).getName();
            for (int j = String.valueOf(list.get(g).getName()).length(); j < colomWidth.get(1); ++j)
                s += " ";
            s += " |";

            //surname
            s += " " + list.get(g).getSurName();
            for (int j = String.valueOf(list.get(g).getSurName()).length(); j < colomWidth.get(2); ++j)
                s += " ";
            s += " |";

            //kafedra
            s += " " + list.get(g).getNameKafedra();
            for (int j = list.get(g).getNameKafedra().length(); j < colomWidth.get(3); ++j)
                s += " ";
            s += " |";

            //faculty
            s += " " + list.get(g).getNameFaculty();
            for (int j = list.get(g).getNameFaculty().length(); j < colomWidth.get(4); ++j)
                s += " ";
            s += " |";
        }

        s += "\n+";
        for(int i = 0; i < field.length; ++i){
            s += writeFinalPart(colomWidth.get(i));
        }

        System.out.println(s);
    }

    private int longNameId(List<OneTeacher> faculty) {
        int etalon = 0;
        for (int i = 0; i < faculty.size(); ++i)
            etalon = max(etalon, String.valueOf(faculty.get(i).getId()).length());
        return etalon;
    }

    private int longNameFaculty(List<OneTeacher> faculty) {
        int etalon = 0;
        for (int i = 0; i < faculty.size(); ++i)
            etalon = max(etalon, faculty.get(i).getNameFaculty().length());
        return etalon;
    }

    private int longNameKafedra(List<OneTeacher> faculty) {
        int etalon = 0;
        for (int i = 0; i < faculty.size(); ++i)
            etalon = max(etalon, faculty.get(i).getNameKafedra().length());
        return etalon;
    }

    private int longName(List<OneTeacher> faculty) {
        int etalon = 0;
        for (int i = 0; i < faculty.size(); ++i)
            etalon = max(etalon, faculty.get(i).getName().length());
        return etalon;
    }

    private int longSurName(List<OneTeacher> faculty) {
        int etalon = 0;
        for (int i = 0; i < faculty.size(); ++i)
            etalon = max(etalon, faculty.get(i).getSurName().length());
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
