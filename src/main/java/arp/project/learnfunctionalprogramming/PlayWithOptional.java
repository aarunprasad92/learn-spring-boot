package arp.project.learnfunctionalprogramming;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PlayWithOptional {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "mango", "berry");
        Predicate<? super String> predicate = fruit -> fruit.startsWith("b");
        Optional<String> optional = fruits.stream().filter(predicate).findFirst();
        System.out.println(optional);
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());
        System.out.println(optional.get());

        Optional<String> fruit = Optional.of("banana");
        Optional<String> empty = Optional.empty();
    }
}