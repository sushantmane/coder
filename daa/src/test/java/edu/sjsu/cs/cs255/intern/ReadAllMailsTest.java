package edu.sjsu.cs.cs255.intern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadAllMailsTest {

    @Test
    void solution() {
        assertEquals(4, ReadAllMails.solution(5, new int[]{1, 1, 0, 0, 1}));
        assertEquals(0, ReadAllMails.solution(2, new int[]{0, 0}));
    }
}