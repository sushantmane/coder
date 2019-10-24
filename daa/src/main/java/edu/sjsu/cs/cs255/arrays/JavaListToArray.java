package edu.sjsu.cs.cs255.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaListToArray {

    public static void main(String[] args) {
        // to list
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // parameter to toArray() method - the array into which the elements of the list
        // are to be stored, if it is big enough; otherwise, a new array of the same runtime
        // type is allocated for this purpose.
        Integer[] intArray = list.toArray(new Integer[list.size()]);
        Arrays.stream(intArray).forEach(k -> System.out.print(k + " "));
        int[] arr = Arrays.stream(intArray).mapToInt(Integer::intValue).toArray();
        Arrays.stream(arr).forEach(System.out::println);
        int[] nums = {11, 22, 33, 44, 55, 66};
        List<Integer> listOfInts = Arrays.stream(nums).boxed().collect(Collectors.toList());
        System.out.println(listOfInts);
        List<Integer> list1 = IntStream.of(nums).boxed().collect(Collectors.toList());
        System.out.println(list1);
    }
}
