package edu.sjsu.cs.cs255.intern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeautifulRowTest {

    @Test
    void solution() {
        int[] arr = {3, 17, 4, 12, 5, 6, 2, 1};
        assertEquals(2, BeautifulRow.solution(arr.length, arr));

        arr = new int[]{1, 2, 100, 99};
        assertEquals(0, BeautifulRow.solution(arr.length, arr));

        arr = new int[]{3, 2, 4, 1};
        assertEquals(1, BeautifulRow.solution(arr.length, arr));

        arr = new int[]{3, 2, 4, 7, 6, 5};
        assertEquals(1, BeautifulRow.solution(arr.length, arr));

        arr = new int[]{3, 4, 5, 7, 11, 15};
        assertEquals(0, BeautifulRow.solution(arr.length, arr));

        arr = new int[]{1, 2, 3, 1, 2};
        assertEquals(1, BeautifulRow.solution(arr.length, arr));
    }
}