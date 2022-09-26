package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collections {

    final List<String> friends = Arrays.asList("Carlos", "Pedro", "Luis");

    /**
     * Iterate a List.
     */

    public void printIterate1(){
        friends.forEach(name -> System.out.println(name));
    }

    public void printIterate2(){
        friends.forEach(System.out::println);
    }

    /**
     * Transform a List.
     */
    public  void transform1(){
        friends.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.println(name + " "));
    }


    // Using Method Reference
    public void transform2(){
        friends.stream()
                .map(String::toUpperCase)
                .forEach(name -> System.out.println(name));
    }

    /**
     * Finding Elements,
     *
     * The final .toList() was added in the jdk 10
     */
    public void findingElements(){
        List<String> result = friends.stream()
                .filter(name -> name.startsWith("C"))
                        .toList();

        System.out.println(String.format("found %d names", result.size()));
    }

    /**
     * Skipping values
     */
    public void skippingValues(){
        friends.stream()
                .skip(2)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    public void skippingValues2(){
        friends.stream()
                .dropWhile(name -> name.length() > 4)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

}
