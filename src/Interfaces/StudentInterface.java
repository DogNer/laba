package Interfaces;

import People.Student;
import University.Kafedra;

public interface StudentInterface {
    void addKafedra(Student el);
    void remove(int pos);
    void changeName(int pos, String newName);
    void changeSurName(int pos, String newSurname);
}
