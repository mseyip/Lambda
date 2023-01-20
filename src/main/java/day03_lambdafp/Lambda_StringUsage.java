package day03_lambdafp;

import day02_lambdafp.UtilsClass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Lambda_StringUsage {

    public static void main(String[] args) {
        List<String> l= new ArrayList<>();
        l.add("Tom");
        l.add("Alley");
        l.add("Mark");
        l.add("Amanda");
        l.add("John");
        l.add("Jackson");
        l.add("Marry");
        l.add("Alberto");
        l.add("Tucker");
        l.add("Tom");
        l.add("Ben");


        printInUpperCase01(l);//TOM ALLEY MARK AMANDA JOHN JACKSON MARRY ALBERTO TUCKER BEN
        System.out.println();
        printInUpperCase02(l);//[TOM, ALLEY, MARK, AMANDA, JOHN, JACKSON, MARRY, ALBERTO, TUCKER, BEN]
        System.out.println();
        printEleSortedByLengths(l);//TOM BEN MARK JOHN ALLEY MARRY AMANDA TUCKER JACKSON ALBERTO
        System.out.println();
        printEleInReverseOrderSortedByLength(l);//JACKSON ALBERTO AMANDA TUCKER ALLEY MARRY MARK JOHN TOM BEN
        System.out.println();
        printDistinctEleSortedByLastChar(l);//AMANDA MARK TOM JOHN JACKSON BEN ALBERTO TUCKER ALLEY MARRY
        System.out.println();
        printSortedByLengthAndSortedByInitial(l);//BEN TOM TOM JOHN MARK ALLEY MARRY AMANDA TUCKER ALBERTO JACKSON
        System.out.println();
        //removeIfTheLengthIsGreaterThanFive(l);//[TOM, ALLEY, MARK, JOHN, MARRY, TOM, BEN]
        System.out.println();
        //printRemoveIfStartingWithAOrEndingWithN01(l);//[TOM, MARK, MARRY, TOM]
        //printRemoveIfStartingWithAOrEndingWithN02(l); //[TOM, MARK, MARRY, TUCKER, TOM]
        // removeIfEleLengthIsBetweenFiveAndNineOrEndingWithO(l); //[TOM, MARK, JOHN, TOM, BEN]
        System.out.println(checkLengthToBeLessThanTwelve(l));
        System.out.println(checkNotToStartWithX(l));
        System.out.println(checkAnyEleEndsWithN(l));


    }

    //1)Create a method to print all list elements in uppercase.

    public static void printInUpperCase01(List<String> list){
        //1.way:
        list.stream().map(String::toUpperCase).forEach(UtilsClass::printInTheSameLineWithASpace);

    }
    public static void printInUpperCase02(List<String> list){
        //2.Way:
        list.replaceAll(String::toUpperCase);
        System.out.println(list);

    }

    //2) Create a method to print the elements after ordering according to their lengths

    public static void printEleSortedByLengths(List<String> list){

        list.stream().sorted(Comparator.comparing(String::length)).forEach(UtilsClass::printInTheSameLineWithASpace);

    }
    //3)Create a method to print the elements after ordering according to their lengths (In reverse order)
    public static void printEleInReverseOrderSortedByLength(List<String> list){

        list.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(UtilsClass::printInTheSameLineWithASpace);

    }

    //4) Create a method to sort the distinct elements by using their last characters

    public static void printDistinctEleSortedByLastChar(List<String> list){

        list.
                stream().
                distinct().
                sorted(Comparator.comparing(UtilsClass::getLastChar)).
                forEach(UtilsClass::printInTheSameLineWithASpace);

    }
    //5)Create a method to sort the elements according to their lengths then according to their first character

    public static void printSortedByLengthAndSortedByInitial(List<String> list){

        list.
                stream().
                sorted(Comparator.comparing(String::length).
                        thenComparing(t-> t.charAt(0))).
                forEach(UtilsClass::printInTheSameLineWithASpace);

    }
    //6) Remove the elements if the length of the element is greater than 5

//    public static void removeIfTheLengthIsGreaterThanFive(List<String> list){
//
//        list.removeIf(t-> t.length()>5);//[TOM, ALLEY, MARK, JOHN, MARRY, TOM, BEN]
//        System.out.println(list);
//
//    }
    // 7)Remove the elements if the element is starting with 'A', 'a' or ending with 'N', 'n'

//    public static void printRemoveIfStartingWithAOrEndingWithN01(List<String> list){
//        //1.way:
//
//        list.removeIf(t-> t.charAt(0)=='A' || t.charAt(0)=='a' || t.charAt(t.length()-1)=='N' || t.charAt(t.length()-1)=='n');
//        System.out.println(list);
//
//    }
//    public static void printRemoveIfStartingWithAOrEndingWithN02(List<String> list) {
//
//        //2.way:
//        list.removeIf(t-> t.startsWith("A") || t.startsWith("a") || t.endsWith("N") || t.endsWith("n"));
//        System.out.println(list);
//
//
//    }

    //8)Remove the elements if the length is between 5 and 9 or ending with 'o'

//    public static void removeIfEleLengthIsBetweenFiveAndNineOrEndingWithO(List<String> list){
//
//        Predicate<String> checkCondition= t-> (t.length()>4 && t.length()<10) || t.endsWith("o");
//
//        list.removeIf(t->checkCondition.test(t)); //[TOM, MARK, JOHN, TOM, BEN]
//        System.out.println(list);
//
//    }

    //9) Create a method to check if the lengths of all elements are less than 12
    public static boolean checkLengthToBeLessThanTwelve(List<String> list){

        return  list.stream().allMatch(t-> t.length()<12);

    }

    //10)Create a method to check if the initial of any elements is not "X"

    public static boolean checkNotToStartWithX(List<String> list){

        return list.stream().noneMatch(t-> t.startsWith("X"));

    }

    // 11) Create a method to check if at least one of the elements ending with "n"

    public static boolean checkAnyEleEndsWithN(List<String> list){

        return list.stream().anyMatch(t-> t.endsWith("N"));

    }

}