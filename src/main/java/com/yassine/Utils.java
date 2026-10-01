package com.yassine;

import java.util.List;

public class Utils {

    public static <T extends Comparable<T>> T max(List<T> liste) {

        T max = liste.get(0);

        for (T element : liste) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }

        return max;
    }
}
