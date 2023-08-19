package com.capacitaciones.continuas.util;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class MethodsConverter {
    public static String listToString(List<Integer> lista) {
        StringJoiner joiner = new StringJoiner(",");
        for (Integer elemento : lista) {
            joiner.add(elemento.toString());
        }
        return joiner.toString();
    }

    public static List<Integer> convertStringToList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
