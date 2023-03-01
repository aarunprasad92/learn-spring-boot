package arp.project.learnfunctionalprogramming;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        System.out.println("Hello");
       // printAllNumbersInListStructured(List.of(12, 9, 3, 66, 12));
        printEvenNumbersInListStructured(List.of(12, 9, 3, 66, 12));
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        for(int number: numbers) {
            System.out.println(number);
        }
    }

    private static void printEvenNumbersInListStructured(List<Integer> numbers) {
        for(int number: numbers) {
            if (number % 2 == 0)
                System.out.println(number);
        }
    }
}
