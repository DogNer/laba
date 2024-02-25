package Interfaces;

import University.Faculty;

public interface FacultyRefactor {
     void addFaculty(Faculty el);
     void remove(int pos);
     void changeName(int pos, String newName);
}
