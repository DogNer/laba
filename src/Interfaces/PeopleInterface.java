package Interfaces;

import PeopleModel.OneStudent;
import PeopleModel.OneTeacher;
import University.PeopleOnCourse;

public interface PeopleInterface {
    void addStudent(OneStudent st);
    void addTeacher(OneTeacher tch);
    void removeSt(int pos);
    void removeTeacher(int pos);
    void changeNameStudent(int pos, OneStudent st);

    void changeNameTeacher(int pos, OneTeacher tch);
}
