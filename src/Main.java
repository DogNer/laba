import People.Teacher;
import Tables.DrawTable;
import University.Faculty;
import University.Kafedra;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Faculty fac = new Faculty();
        fac.addFaculty(new Faculty("FSNST", "Null"));
        fac.addFaculty(new Faculty("Fi", "Glibannn"));
        fac.addFaculty(new Faculty("Fen", "Null"));

        Kafedra kf = new Kafedra();
        kf.addKafedra(new Kafedra("Fi", "Math", new Teacher("Luda", "Shumko")));
        kf.addKafedra(new Kafedra("Fi","Phisics", new Teacher("Mila", "Rik")));
        kf.addKafedra(new Kafedra("Fi","Pr", new Teacher("Lop", "Mitur")));


        DrawTable tab = new DrawTable(fac.arrData);

        tab.getTable(3, fac.getArrFaculty().size(), fac.arrData);

        fac.remove(3);

        tab = new DrawTable(kf.arrData);
        tab.getTable(kf.getId()-1, kf.getArrKafedra().size(), kf.arrData);

        kf.remove(3);
        tab.getTable(kf.getId()-1, kf.getArrKafedra().size(), kf.arrData);
    }
}