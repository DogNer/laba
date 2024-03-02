package Interfaces;

import People.Student;
import University.Faculty;
import University.Kafedra;

public interface KafedraRefactor {
    void addKafedra(Kafedra el);
    void remove(int pos);
    void changeName(int pos, String newName);
    void teacherName(int pos, String newSurname);
}
