package org.plaintech.coding;

import java.util.*;

public class WaterJugProblem {
    void enqueue(int c, Queue<Integer> queue, Set<Integer> set) {
        // if (!set.contains(c)) {
        queue.add(c);
        // }
    }
    public boolean canMeasureWater(int x, int y, int z) {
        Set<Integer> set = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();

        int max = Math.max(x, y);
        int min = Math.min(x,y);

        queue.add(x);
        queue.add(y);


        while (!queue.isEmpty()) {
            int c = queue.remove();
            if (!set.contains(c)) {
                set.add(c);
                if (c > max) {
                    continue;
                }
                // put in the bigger jug
                enqueue(c + min, queue, set);
                if (c + min > max) {
                    enqueue(min - (max - c), queue, set);
                }

                // trying to put in the small jug
                if (c >= min) {
                    enqueue(c - min, queue, set);
                } else {
                    enqueue(max - (min - c), queue, set);
                }
            }
        }

        return set.contains(z);

    }

}
