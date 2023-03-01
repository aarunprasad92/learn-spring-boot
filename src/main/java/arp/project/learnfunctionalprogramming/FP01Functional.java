package arp.project.learnfunctionalprogramming;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        System.out.println("Hello");
        printAllNumbersInListFunctional(List.of(12, 9, 3, 66, 12));
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        // convert to stream, method reference for each number
        numbers.stream().forEach(System.out::println);
    }
}
