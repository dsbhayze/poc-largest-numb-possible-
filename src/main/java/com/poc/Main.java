package com.poc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    public StringBuilder giveHigherCombination(Integer[] values) {
        List<Integer> list = putDecimalPointOnIntegers(values);
        return null;
    }

    private List<Integer> putDecimalPointOnIntegers(Integer[] intValues){
        List<String> stringValues = new ArrayList<>();
        Arrays.stream(intValues).forEach(e -> {
            if (e.toString().length() > 0) {
                StringBuilder sb = new StringBuilder();
                stringValues.add(sb.append(e).insert(1, ".").toString());
            }
            stringValues.add(e.toString());
        });
        return null;
    };

    private void sortByHigherValue(){
        //TODO
    }

    private void removeDecimalPoints(){
        //TODO
    };



    @Test
    public void testCase() {
        assertEquals("95021", giveHigherCombination(new Integer[]{50, 2, 1, 9}));
    }




}
