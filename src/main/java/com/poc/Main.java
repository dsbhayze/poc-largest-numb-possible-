package com.poc;

import org.junit.jupiter.api.Test;

import java.util.*;
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
        List<Integer> stack = sortDesc(normalizeMap);
        return printHigherCombination(stack, originalMap);
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

    private List<Integer> sortDesc(Map<Integer, Integer> cloneMap) {
        List<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>(cloneMap.values());
        Collections.sort(list);
        Collections.reverse(list);
        for (Integer value : list) {
            Map.Entry<Integer, Integer> entry = cloneMap.entrySet().stream()
                    .filter(e -> e.getValue().equals(value))
                    .collect(Collectors.toList()).get(0);
            Integer key = Integer.parseInt(entry.getKey().toString());
            stack.add(key);
            cloneMap.remove(key);
        }
        return stack;
    }

    private String printHigherCombination(List<Integer> order, Map<Integer, Integer> originalParam) {
        StringBuilder stb = new StringBuilder();
        for (Integer integer : order) {
            stb.append(originalParam.get(integer));
        }
        return stb.toString();
    }

    @Test
    public void testCase() {
        assertEquals("95021", giveHigherCombination(Stream.of(50, 2, 1, 9).collect(Collectors.toList())));
        assertEquals("56550", giveHigherCombination(Stream.of(5,50,56).collect(Collectors.toList())));
        assertEquals("42423420", giveHigherCombination(Stream.of(420,42,423).collect(Collectors.toList())));
    }
}
