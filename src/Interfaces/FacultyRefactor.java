package Interfaces;

import University.Faculty;
import University.Kafedra;

public interface FacultyRefactor {
     void addFaculty(Faculty el);
     void removeFaculty(int pos);
     void changeName(int pos, String newName);

     void addKafedra(Kafedra kf);
     void removeKafedra(int indexFac, int pos);
     void changeNameKafedra(int pos, String newName);
}
