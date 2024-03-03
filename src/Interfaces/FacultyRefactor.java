package Interfaces;

import University.Faculty;
import University.Kafedra;

public interface FacultyRefactor {
     void addFaculty(Faculty el);
     void removeFaculty(int pos);
     void changeName(int pos, String newName, Kafedra kf);
}
