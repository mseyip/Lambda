package day03_lambdafp;

import day02_lambdafp.UtilsClass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Lambda01_String {

    public static void main(String[] args) {

        List<String> l= new ArrayList<>();

        l.add("Tom");
        l.add("Alley");
        l.add("Tom");
        l.add("Mark");
        l.add("Amanda");
        l.add("John");
        l.add("Jackson");
        l.add("Marry");
        l.add("Alberto");
        l.add("Tucker");
        l.add("Ben");

        printInUpperCases01(l);
        System.out.println();
        //printInUpperCase02(l);
        printElementSortedByLength(l);
        System.out.println();
        printElementsInReverseOrderSortedByLength(l);
        System.out.println();
        printDistinctEleSortedByLastChar(l);//Amanda Mark Tom John Jackson Ben Alberto Tucker Alley Marry
        System.out.println();
        printEleSortedByLengthThenSortedByInitials(l);//Ben Tom Tom John Mark Alley Marry Amanda Tucker Alberto Jackson
        System.out.println();
        //removeIfTheLengthGreaterThanFive(l);
        // RemoveIfStartsWithAOrEndsWithO01(l);//[Tom, Tom, Mark, John, Jackson, Marry, Tucker, Ben]
        //RemoveIfStartsWithAOrEndsWithO02(l);//[Tom, Tom, Mark, John, Jackson, Marry, Tucker, Ben]
        // removeIfLengthIsBetweenFiveAndTenOrEndingWithO(l);
        System.out.println(checkLengthToBeLessThanTwelve(l));//true
        System.out.println(checkAnyNotToStartWithX(l));
        System.out.println(checkAnyEleEndingWithR(l));



    }
    //1) Create a method to print all list elements in uppercase
    //1.way:
    public static void printInUpperCases01(List<String> list){

        list.stream().map(String::toUpperCase).forEach(UtilsClass::printInTheSameLineWithASpace);//TOM ALLEY TOM MARK AMANDA JOHN JACKSON MARRY ALBERTO TUCKER BEN

    }

//    public static void printInUpperCase02(List<String> list){
//
//        list.replaceAll(String::toUpperCase); //[TOM, ALLEY, TOM, MARK, AMANDA, JOHN, JACKSON, MARRY, ALBERTO, TUCKER, BEN]
//        System.out.println(list);
//
//    }

    //2) Create a method to print the elements after ordering according to their lengths
    public static void printElementSortedByLength(List<String> list){

        list.stream().sorted(Comparator.comparing(String::length)).forEach(UtilsClass::printInTheSameLineWithASpace);

    }

    //3)Create a method to print the elements after ordering according to their lengths (In reverse order)
    public static void printElementsInReverseOrderSortedByLength(List<String> list){

        list.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(UtilsClass::printInTheSameLineWithASpace);

    }

    //4) Create a method to sort the distinct elements by using their last character

    public static void printDistinctEleSortedByLastChar(List<String> list){

        list.stream().distinct().sorted(Comparator.comparing(UtilsClass::getLastChar)).forEach(UtilsClass::printInTheSameLineWithASpace);

    }

    //5) Create a method to sort the elements according to their lengths then according to their first character.

    public static void printEleSortedByLengthThenSortedByInitials(List<String> list){

        list.
                stream().
                sorted(Comparator.comparing(String::length).thenComparing(t-> t.charAt(0))).
                forEach(UtilsClass::printInTheSameLineWithASpace);

    }
    //6) Remove the elements if the length of the element is greater than 5

//    public static void removeIfTheLengthGreaterThanFive(List<String> list){
//
//        list.removeIf(t-> t.length()>5);//[Tom, Alley, Tom, Mark, John, Marry, Ben]
//        System.out.println(list);
//
//    }
    // 7) Remove the elements if the element is starting with 'A', 'a' or ending with 'O' or 'o'.
//    public static void RemoveIfStartsWithAOrEndsWithO01(List<String> list){
//
//        Predicate<String> checkCondition= t-> t.charAt(0)== 'A' || t.charAt(0)=='a' || t.charAt(t.length()-1)=='O' || t.charAt(t.length()-1)=='o';
//        list.removeIf(t-> checkCondition.test(t));
//
//        System.out.println(list);
//
//    }
//    public static void RemoveIfStartsWithAOrEndsWithO02(List<String> list){
//
//         list.removeIf(t-> t.startsWith("A") || t.startsWith("a") || t.endsWith("O") || t.endsWith("o"));
//        System.out.println(list);
//
//    }

    //8) Remove the elements if the element length is between 5 and 10 or ending with 'o'

//    public static void removeIfLengthIsBetweenFiveAndTenOrEndingWithO(List<String> list){
//
//        Predicate<String> checkCondition= t-> (t.length()>4 && t.length()<11) || t.endsWith("o");
//
//        list.removeIf(t-> checkCondition.test(t));
//
//        System.out.println(list);
//
//    }

    //9) Create a method to check if the lengths of all elements are less than 12
    public static boolean checkLengthToBeLessThanTwelve(List<String> list){

        return list.stream().allMatch(t-> t.length()<12);

    }

    //10)Create a method to check if the initial of any element is not 'X'

    public static boolean checkAnyNotToStartWithX(List<String> list){

        return list.stream().noneMatch(t-> t.startsWith("X"));
    }

    //11) Create a method to check if at least one of the elements ending with "r"
    public static boolean checkAnyEleEndingWithR(List<String> list){

        return list.stream().anyMatch(t-> t.endsWith("l"));

    }

}
