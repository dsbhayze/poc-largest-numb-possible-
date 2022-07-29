package com.poc;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    public String giveHigherCombination(List<Integer> values) {
        Collections.sort(values);
        Collections.reverse(values);
        int maxUnit = values.get(0).toString().length();

        Map<Integer, Integer> originalMap = new HashMap<>();
        Map<Integer, Integer> mutableMap = new HashMap<>();
        for (int i = 0; i < values.size(); i++) {
            originalMap.put(i, values.get(i));
            mutableMap.put(i, values.get(i));
        }

        Map<Integer, Integer> normalizeMap = normalizeData(maxUnit, mutableMap);
        return null;
    }

    private Map<Integer, Integer> normalizeData(int maxUnit, Map<Integer, Integer> values) {
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).toString().length() < maxUnit) {
                StringBuilder value = new StringBuilder(values.get(i).toString());
                String firstUnit = value.substring(0, 1);
                while (value.length() < maxUnit) {
                    value.append(firstUnit);
                }
                values.put(i, Integer.valueOf(String.valueOf(value)));
            }
        }
        return values;
    }

    private void sortDesc() {
        //TODO
    }

    private String printHigherCombination() {
        //TODO
        return null;
    }

    @Test
    public void testCase() {
        assertEquals("95021", giveHigherCombination(Stream.of(50, 2, 1, 9).collect(Collectors.toList())));
        //assertEquals("56550", giveHigherCombination(Stream.of(5,50,56).collect(Collectors.toList())));
        //assertEquals("42423420", giveHigherCombination(Stream.of(420,42,423).collect(Collectors.toList())));
    }
}
