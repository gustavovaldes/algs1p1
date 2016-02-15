package com.guga.algs1p1.week2;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guga
 */
public class KnuthShuffleTest {

    @Test
    public void testShuffle() {
        String[] values;
        Map<String, Integer> results = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            values = new String[]{"A", "B", "C", "D", "F", "G", "H"};
            KnuthShuffle.shuffle(values);
            for (String value : values) {
                if (results.containsKey(value)) {
                    results.put(value, results.get(value) + 1);
                } else {
                    results.put(value, 1);
                }
            }
        }
       Assert.assertEquals(1000,(int)results.get("A"));

    }
}
