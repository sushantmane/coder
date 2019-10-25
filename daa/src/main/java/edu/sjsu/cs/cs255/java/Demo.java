package edu.sjsu.cs.cs255.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Demo {

    class Score {
        double points;

        Score(double pt) {
            points = pt;
        }
    }

    private void sortDemo() {
        List<Score> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            list.add(new Score(random.nextDouble()));
        }
        Collections.sort(list, new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return Double.compare(o1.points, o2.points);
            }
        });
        Collections.sort(list, (o1, o2) -> Double.compare(o1.points, o2.points));
        for (Score score : list) {
            System.out.println(score.points);
        }
    }

    void intArrayToList() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    void strArrayToList() {
        String[] arr = {"a", "b", "c", "d", "e"};
        List<String> list = Arrays.stream(arr).collect(Collectors.toList());
        for (String str : list) {
            System.out.print(str + " ");
        }
    }

    void strListToArray() {
        List<String> list = Arrays.asList( "a", "b", "c", "d", "e");
        String[] arr = list.toArray(new String[list.size()]);
        Arrays.stream(arr).forEach(System.out::print);
    }

    void intListToArray() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.stream(arr).forEach(System.out::print);
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.intArrayToList();
        System.out.println();
        demo.strArrayToList();
        System.out.println();
        demo.strListToArray();
        System.out.println();
        demo.intListToArray();
    }
}
