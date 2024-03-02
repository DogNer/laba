package People;

import Models.ArrList;

import javax.swing.*;
import java.util.List;

public class Student extends People {
    int rankMark;
    int yearOfStudy;
    int grope;
    String name;
    String surNmae;

    List<Integer> mark = new ArrList<>();

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurNmae() {
        return surNmae;
    }

    public void setSurNmae(String surNmae) {
        this.surNmae = surNmae;
    }

    public List<Integer> getMark() {
        return mark;
    }

    public void setMark(List<Integer> mark) {
        this.mark = mark;
    }
}
