package org.plaintech.coding;
import java.util.*;

class FriendCircles {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];

        Queue<Integer> queue = new LinkedList<Integer>();

        int count = 0;

        for (int i = 0; i < M.length; i++) {
            if (0 == visited[i]) {
                count++;
                queue.add(i);

                while (!queue.isEmpty()) {
                    int e = queue.remove();
                    if (0 == visited[e]) {
                        visited[e] = count;
                    }
                    for (int j = 0; j < M.length; j++) {
                        if (0 == visited[j] && 1 == M[e][j]) {
                            queue.add(j);
                        }
                    }
                }
            }

        }

        return count;

    }
}