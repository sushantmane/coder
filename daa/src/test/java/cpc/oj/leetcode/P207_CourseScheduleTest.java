package cpc.oj.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P207_CourseScheduleTest {

    @Test
    void canFinish() {
        P207_CourseSchedule test = new P207_CourseSchedule();

        int nCourses = 3;
        int[][] preqs = {{1,0}, {0,2}, {1, 2}};
        test.canFinish(nCourses, preqs);
    }
}