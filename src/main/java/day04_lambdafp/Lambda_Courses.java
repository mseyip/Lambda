package day04_lambdafp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda_Courses {

    public static void main(String[] args) {
        Courses courseTurkishDay = new Courses("Summer", "Turkish Day", 97, 128);
        Courses courseTurkishNight = new Courses("Winter", "Turkish Night", 98, 154);
        Courses courseEnglishDay = new Courses("Spring", "English Day", 95, 132);
        Courses courseEnglishNight = new Courses("Winter", "English Night", 93, 144);

        List<Courses> coursesList = new ArrayList<>();
        coursesList.add(courseTurkishDay);
        coursesList.add(courseTurkishNight);
        coursesList.add(courseEnglishDay);
        coursesList.add(courseEnglishNight);

        System.out.println(checkAvgScoresToBeGreaterThanGivenNum(coursesList, 92));//true
        System.out.println(checkIfAnyCourseNameContainsGivenWord(coursesList, "German"));
        System.out.println(getCourseNameWhoseAvgIsTheHighest(coursesList));//Turkish Night
        System.out.println(sortCourseWithAverageScoreInAscendingSkipFirstGiven(coursesList, 2));


    }

    //1)Create a method to check if all average scores are greater than given number

    public static boolean checkAvgScoresToBeGreaterThanGivenNum(List<Courses> list, double avgScore){

        return list.stream().allMatch(t-> t.getAverageScore()> avgScore);

    }
    //2)Create a method to check if at least one of the course names contains given word
    public static boolean checkIfAnyCourseNameContainsGivenWord(List<Courses> list, String word){

        return list.stream().anyMatch(t-> t.getCourseName().contains(word));

    }
    //3)Create a method to print the course whose average score is the highest

    public static String getCourseNameWhoseAvgIsTheHighest(List<Courses> list){

        return list.stream().sorted(Comparator.comparing(Courses::getAverageScore).reversed()).findFirst().get().getCourseName();

    }
    //4) Sort the list elements according to the average score in ascending order and skip first given one.

    public static List<Courses> sortCourseWithAverageScoreInAscendingSkipFirstGiven(List<Courses> list, int num){

        return list.stream().sorted(Comparator.comparing(Courses::getAverageScore)).skip(num).collect(Collectors.toList());

    }

    //5) Homework: Sort the list elements according to the average score in ascending order and print just the given one

}