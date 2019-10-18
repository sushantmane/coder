package edu.sjsu.cs.cs255.ctci.chapter1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUniqueCharsTest {

    StringUniqueChars obj;

    @BeforeEach
    public void setup() {
        obj = new StringUniqueChars();
    }

    @Test
    public void isUnique_True() {
        assertTrue(obj.isUnique(" "));
        assertFalse(obj.isUnique("sushant"));
        assertFalse(obj.isUnique("san jose"));
        assertFalse(obj.isUnique("missipissi"));
        assertTrue(obj.isUnique("what"));
        assertTrue(obj.isUnique(""));
    }

    @Test
    public void isUniqueBruteForce_True() {
        assertTrue(obj.isUnique(" "));
        assertFalse(obj.isUnique("sushant"));
        assertFalse(obj.isUnique("san jose"));
        assertFalse(obj.isUnique("missipissi"));
        assertTrue(obj.isUnique("what"));
        assertTrue(obj.isUnique(""));
    }
}