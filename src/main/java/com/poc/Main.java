package com.poc;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //TODO
        return null;
    }

    private void sortDesc() {
        //TODO
    }

    private String printHigherCombination() {
        //TODO
        return null;
    }
}
