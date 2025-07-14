package streams;

import javax.lang.model.util.Elements;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

    public static void main(String[] args) {
//        //1. find union of two lists
//        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
//        List<Integer> list2 = Arrays.asList(4,5,6,7,8,9);
//
//        //solution-1
//        List<Integer> unionList = Stream.of(list1,list2)
//                .flatMap(Collection::stream)// Flatten the two lists into one stream
//                .distinct()//Unique
//                .sorted(Comparator.reverseOrder()) //reverse order
//                .toList(); // Collect as list
//        System.out.println("Union (Descending): Solution 1 - "  + unionList);
//
//        //Solution 2
//        List<Integer> unionDescList1 =
//                Stream.concat(list1.stream(), list2.stream()) //Combine 2 lists
//                        .distinct() // Remove duplicates
//                        .sorted(Comparator.reverseOrder()) // Sort in descending order
//                        .toList(); // Collect as list
//        System.out.println("Union (Descending): Solution 2 - "  + unionDescList1);
//
//        //For best performance and maintainability, go with:
//        Set<Integer> unionSet = new HashSet<>();
//        unionSet.addAll(list1);
//        unionSet.addAll(list2);
//        List<Integer> integerList = new ArrayList<>(unionSet);
//        integerList.sort(Comparator.reverseOrder());
//        System.out.println("Union (Descending): Solution 3 - "  + integerList);

//     2.   Find Pairs with Target Sum
//
//        List<Integer> list1 = Arrays.asList(1, 2, 3, 6, 17, 1, 10, 8);
//        List<Integer> list2 = Arrays.asList(1, 17, 12, 12, 2, 4, 6);
//
//        //solution-1
//        List<String> pairs = list1.stream()
//                .flatMap(a->list2.stream()
//                        .filter(b->a+b==18)
//                        .map(b -> a + ", "+b)).toList();
//        pairs.forEach(System.out::println);
//
//        System.out.println();
//
//        //solution-2
//        list1.stream().map(a->list2.stream()
//                .filter(b -> a+b==18)
//                .map(b->a+", "+b))
//                .flatMap(s->s)
//                .forEach(System.out::println);

//        //3. Find Common Elements Between Two Lists
//        List<Integer> list1 = Arrays.asList(10, 20, 30, 40, 50);
//        List<Integer> list2 = Arrays.asList(30, 40, 50, 60, 70);
//
//       list1.stream().map(a->list2.stream()
//                .filter(b-> Objects.equals(a,b))).flatMap(s->s)
//                .forEach(System.out::println);
//
//       list1.stream().filter(list2::contains).toList().forEach(System.out::println);


//        4. Find All Elements That Appear More Than Once in a List
//        List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6);
//
//        list.stream()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
//                .stream()
//                .filter(a -> a.getValue() > 1)
//                .map(Map.Entry::getKey).toList().forEach(System.out::println);
//

        /*Explanation:
        groupingBy(Function.identity(), counting()) →Counts occurrences of each element.
        filter(entry -> entry.getValue() > 1) →Keeps only elements with duplicates.
        map(Map.Entry::getKey) →Extracts the element itself.
        collect(Collectors.toSet()) →Collects unique duplicate elements into a set.*/

//        5.Find the first non-repeating character in a String using Java Streams.
//        Example:
//        String input = "swiss";
//          ‘s’ repeats
//          ‘w’ is unique
//        So, the answer should be: ‘w’

        String input = "swiss";

        Optional<Character> firstNonRepeating = input.chars()  // Stream of int
                .mapToObj(c -> (char) c)  // Convert int to char
                .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new, Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

        firstNonRepeating.ifPresent(System.out::println);  // Output: w
       /* Explanation:
        .chars() → converts the String to an IntStream of characters.
        .mapToObj(c -> (char) c) → converts int values to Character objects.
         groupingBy(...,LinkedHashMap::new, ...) → maintains insertion order, which is crucial to find the first unique character.
         Collectors.counting() →counts occurrences of each character.
         .filter(entry -> entry.getValue() == 1) → keeps only non - repeating characters.
         .map(...).findFirst() → finds the first one in insertion order.
         */

    }
}
