package org.plaintech.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

interface MyFunction<X, Y> {
    Y apply(X x);
}

public class Summary {

    void opeartionArrayAndList() {
        // Initialize a list using vararg
        List<Integer> xs = Arrays.asList(1, 2, 3, 4);

        // Create an array from literal
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        int len = arr.length;
        List<Integer> ys = Arrays.asList(arr);

        int size = xs.size();
        xs.add(100);
        xs.remove(3);
        xs.add(0, 100);
        xs.set(0, 101);

        for (Integer i: arr) {
            System.out.println(i);
        }

        for (Integer i: xs) {
            System.out.println(i);
        }

        Iterator<Integer> iter = xs.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        ListIterator<Integer> listIter = xs.listIterator();
        listIter.next();
        listIter.previous();
        listIter.remove();
    }

    void operationSet() {
        Set<Integer> set = new HashSet<>();
        set.add(100);
        set.remove(100);
        Iterator iter = set.iterator();

        for (Integer i: set) {
            System.out.println(i);
        }

        Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(1, 2, 3));
    }

}
