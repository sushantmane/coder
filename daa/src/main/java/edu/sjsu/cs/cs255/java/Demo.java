package edu.sjsu.cs.cs255.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

    static void print() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.sortDemo();
    }
}
