package People;

import javax.swing.*;

public class Student extends People {
    int rankMark;
    int yearOfStudy;

    int grope;

    public Student(String name, String surName, String nameFaculty, int rankMark, int yearOfStudy, int grope) {
        super(name, surName, nameFaculty);
        this.rankMark = rankMark;
        this.yearOfStudy = yearOfStudy;
        this.grope = grope;
    }

    public Student(String name, String surName, int rankMark, int yearOfStudy, int grope) {
        super(name, surName);
        this.rankMark = rankMark;
        this.yearOfStudy = yearOfStudy;
        this.grope = grope;
    }

    public Student(String name, String surName) {
        super(name, surName);
    }

    public Student() {
    }

    public int getRankMark() {
        return rankMark;
    }

    public void setRankMark(int rankMark) {
        this.rankMark = rankMark;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public int getGrope() {
        return grope;
    }

    public void setGrope(int grope) {
        this.grope = grope;
    }
}
