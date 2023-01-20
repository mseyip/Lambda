package day03_lambdafp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lambda_IntStreamUsage {

    public static void main(String[] args) {

        System.out.println(getSumFromSevenToHundred01());//5029
        System.out.println(getSumFromSevenToHundred02());//5029
        System.out.println(getSumFromXToY(7, 100));//5029
        System.out.println(getMultiplicationFromXToY(2, 11));//39916800

    }

    //1) Create a method to find the sum of the integers from 7 to 100.

    //1.Way
    public static int getSumFromSevenToHundred01() {

        //IntStream.range(7, 101)==> has the same functionality with for-loop in structured programming

        return IntStream.range(7, 101).reduce(0, Math::addExact);
    }

    //2.Way
    public static int getSumFromSevenToHundred02() {

        //IntStream.rangeClosed(7, 100)==>has the same functionality with for-loop in structured programming
        return IntStream.rangeClosed(7, 100).reduce(0, Math::addExact);
    }

    //3.Way

    public static int getSumFromXToY(int x, int y) {

        //IntStream.rangeClosed(7, 100)==>has the same functionality with for-loop in structured programming
        return IntStream.rangeClosed(x, y).reduce(0, Math::addExact);
    }

    //2)Create a method to find the multiplication of the integers from 2 (inc) to 11 (inc).

    public static int getMultiplicationFromXToY(int x, int y) {

        return IntStream.rangeClosed(2, 11).reduce(1, Math::multiplyExact);


        }
    }
