import University.Faculty;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Faculty> fac = new ArrList<>();
        fac.add(new Faculty("Fi", "Gliba"));
        fac.add(new Faculty("Fen", "XS"));
        System.out.println(fac);
    }
}