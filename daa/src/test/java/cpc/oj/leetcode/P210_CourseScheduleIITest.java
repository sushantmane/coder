package cpc.oj.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class P210_CourseScheduleIITest {

    @Test
    void canFinish_Test1() {
        int[][] courses = {{1, 0}};
        int n = 2;
        P210_CourseScheduleII test = new P210_CourseScheduleII();
        int[] res = test.canFinish(2, courses);
        Arrays.stream(res).forEach(System.out::println);
    }

    @Test
    void canFinish_Test2() {
        int[][] courses = {{1, 0}, {2, 0}, {3, 1}, {3,2}};
        int n = 4;
        P210_CourseScheduleII test = new P210_CourseScheduleII();
        int[] res = test.canFinish(4, courses);
        Arrays.stream(res).forEach(System.out::println);
    }
}