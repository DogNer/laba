package Tables;

import Models.ArrList;

import java.util.List;

import static java.lang.Math.max;

public class DrawTable {

    public DrawTable() {
    }

    /**
     *
     * @param n кількість об'єктів в лінії
     * @param m кількість об'єктів в столбці
     * @param object
     */
    public void getTable(int n, int m, String[][] object){

        String s = "+";
        List<Integer> colomWidth = new ArrList<>();
        for(int i = 0; i < n; ++i){
            colomWidth.add(max(longName(i, m, object), object[i][0].length()));
            s += writeFinalPart(colomWidth.get(i));
        }

        s += '\n' + "|";
        for(int i = 0; i < n; ++i){
            s += " " + object[i][0];
            for (int j = object[i][0].length(); j < colomWidth.get(i); ++j)
                s += " ";
            s += " |";
        }

        s += "\n+";
        for(int i = 0; i < n; ++i){
            s += writeFinalPart(colomWidth.get(i));
        }

        for(int g = 1; g <= m; ++g){
            s += '\n' + "|";
            for(int i = 0; i < n; ++i){
                s += " " + object[i][g];
                for (int j = object[i][g].length(); j < colomWidth.get(i); ++j)
                    s += " ";
                s += " |";
            }
        }

        s += "\n+";
        for(int i = 0; i < n; ++i){
            s += writeFinalPart(colomWidth.get(i));
        }

        System.out.println(s);
    }

    private int longName(int n, int m, String[][] object) {
        int etalon = 0;
        for (int i = 0; i <= m; ++i)
            etalon = max(etalon, object[n][i].length());
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
