package University;

import Interfaces.KafedraRefactor;
import Models.ArrList;

import java.util.List;

public class Kafedra extends Faculty implements KafedraRefactor{
    private String nameKaf;
    private int id = 0;
    private List<Kafedra> arrKafedra = new ArrList<>();
    private String[][] arrData = new String[10][1000];

    public Kafedra(String nameFaculty, String nameKaf) {
        super(nameFaculty);
        this.nameKaf = nameKaf;
    }

    public Kafedra(String nameKaf) {
        this.nameKaf = nameKaf;
    }

    public Kafedra() {
    }

    public String getNameKaf() {
        return nameKaf;
    }

    public void setNameKaf(String nameKaf) {
        this.nameKaf = nameKaf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Kafedra> getArrKafedra() {
        return arrKafedra;
    }

    public void setArrKafedra(List<Kafedra> arrKafedra) {
        this.arrKafedra = arrKafedra;
    }

    public String[][] getArrData() {
        return arrData;
    }

    public void setArrData(String[][] arrData) {
        this.arrData = arrData;
    }

    @Override
    public void addKafedra(Kafedra el) {
        id++;
        el.setId(id);
        arrKafedra.add(el);

        arrData[0][0] = "id";
        arrData[1][0] = "Кафедра";
        arrData[2][0] = "Факултет";

        arrData[0][id] = id + "";
        arrData[1][id] = el.nameKaf;
        arrData[2][id] = el.getNameFaculty();
    }

    @Override
    public void remove(int pos) {
        arrKafedra.remove(pos-1);
        id--;
        moveArrToDelete(pos);
    }

    private void moveArrToDelete(int pos){
        for(int i = 1; i < 3; ++i)
            for(int j = pos; j <= arrKafedra.size(); ++j) {
                arrData[i][j] = arrData[i][j + 1];
            }
    }


    @Override
    public void changeName(int pos, String newName) {
        arrKafedra.get(pos - 1).setNameFaculty(newName);
        arrData[1][pos] = newName;
    }

    /**
     * Створюємо нову таблицю з існуючої, для однієї конкретної кафедри
     * @param nameFaculty
     * @return
     */
    public String[][] formTableCondition(String nameFaculty){
        String[][] tmp;
        int cnt = 0;

        for(int j = 0; j <= arrKafedra.size(); ++j) {
            if (nameFaculty.equals(arrData[2][j])) {
                cnt++;
            }
        }

        tmp = new String[3][cnt + 1];
        cnt = 0;
        tmp[0][0] = "id";
        tmp[1][0] = "Кафедра";
        tmp[2][0] = "Факултет";

        for(int j = 0; j <= arrKafedra.size(); ++j) {
            if (nameFaculty.equals(arrData[2][j])) {
                cnt++;
                for (int i = 0; i < 3; ++i)
                    tmp[i][cnt] = arrData[i][j];
            }
        }
        return tmp;
    }
}
