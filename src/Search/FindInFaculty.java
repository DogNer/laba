package Search;

import University.PeopleOnCourse;

import java.util.List;

public class FindInFaculty {

    List<PeopleOnCourse> arrList;

    public FindInFaculty(List<PeopleOnCourse> arrList) {
        this.arrList = arrList;
    }

    public FindInFaculty() {
    }

    public void searchKey(String name, String surName, int year){
        boolean checkIsFind = true;

        /*for(int i = 0; i < arrList.size(); ++i)
            if (name.equals(arrList.get(i).getSt().getName())
            && surName.equals(arrList.get(i).getSt().getSurName())
            && year == arrList.get(i).getSt().getYear()){
                checkIsFind = true;
                System.out.println(name + " " + surName + "find on faculty" + arrList.get(i).getNameFaculty());
            }
            else if (name.equals(arrList.get(i).getTeacher().getName())
                    && surName.equals(arrList.get(i).getTeacher().getSurName())) {
                checkIsFind = true;
                System.out.println(name + " " + surName + "find on faculty" + arrList.get(i).getNameFaculty());
            }

        if(checkIsFind)
            System.out.println("Нікого не було знайдено.");*/
    }
}
