package arp.project.learnfunctionalprogramming;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        System.out.println("Hello");
        //printAllNumbersInListFunctional(List.of(12, 9, 3, 66, 12));
        printSquaresOfEvenNumbersInListFunctional(List.of(12, 9, 3, 66, 12));
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        // convert to stream, method reference for each number
        numbers.stream().forEach(System.out::println);
    }

    private static boolean isEven(int number) {
        return number %2 == 0;
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number%2 == 0)
                .forEach(System.out::println);
    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number%2 == 0)
                .map(number -> number * number)
                .forEach(System.out::println);
    }
}
