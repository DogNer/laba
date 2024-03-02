package Tables;

import Models.ArrList;

import java.util.List;

import static java.lang.Math.max;

public class DrawTable {
    String[][] object = new String[1000][1000];

    public DrawTable(String[][] object) {
        this.object = object;
    }

    public DrawTable() {
    }

    public void getTable(int n, int m, String[][] object){

        String s = "+";
        List<Integer> colomWidth = new ArrList<>();
        for(int i = 0; i < n; ++i){
            colomWidth.add(max(longName(i, m), object[0][i].length()));
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

    private int longName(int n, int m) {
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
