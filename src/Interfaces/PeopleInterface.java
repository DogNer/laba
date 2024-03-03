package Interfaces;

import PeopleModel.OneStudent;
import University.PeopleOnCourse;

public interface PeopleInterface {
    void addStudent(PeopleOnCourse st);
    void addTeacher(PeopleOnCourse tch);
    void remove(int pos);
    void changeName(int pos, OneStudent st);
}
