package org.example;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReuseLambda {

    final List<String> friends =
            Arrays.asList("Brian", "Nate", "Raju", "Sara" ,"Scott");

    final List<String> editors =
            Arrays.asList("Brian","Jackie","John","Mike");

    final List<String> comrades =
            Arrays.asList("Kate","Ken","Mick","Paula","Zach");


    public void impl1(){
        final Predicate<String> startWithN = name -> name.startsWith("N");
        final Predicate<String> startWithB = name -> name.startsWith("B");

        final long countFriendsStartN =
                friends.stream().filter(startWithN).count();

        final long countFriendsStartB =
                friends.stream().filter(startWithB).count();

        System.out.println("friends start with N: " + countFriendsStartN);
        System.out.println("friends start with B: " + countFriendsStartB);

    }

    public static Predicate<String> checkIfStartWith(final String letter){
        return name -> name.startsWith(letter);
    }
    public void impl2(){
        final long countFriendsStartN =
                friends.stream()
                        .filter(checkIfStartWith("N"))
                        .count();

        final long countFriendsStartB =
                friends.stream()
                        .filter(checkIfStartWith("B"))
                        .count();

        System.out.println("Start with N: " + countFriendsStartN);
        System.out.println("Start with B: " + countFriendsStartB);

    }

    /**
     * Function that takes in a String and returns a Predicate
     */
    final Function<String, Predicate<String>> startWithLetter =
            (String letter) -> {
                Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
                return checkStarts;
            };

    final Function<String, Predicate<String>> startsWithLetter2 =
            (String letter) -> (String name) -> name.startsWith(letter);

    final Function<String, Predicate<String>> startsWithLetter3 =
            letter -> name -> name.startsWith(letter);

    public void impl3(){
        final long countFriendsStartN =
                friends.stream()
                        .filter(startsWithLetter3.apply("N"))
                        .count();

        final long countFriendsStartB =
                friends.stream()
                        .filter(startsWithLetter3.apply("B"))
                        .count();

        System.out.println("Friends with N: " + countFriendsStartN);
        System.out.println("Friends with B: " + countFriendsStartB);
    }


}
