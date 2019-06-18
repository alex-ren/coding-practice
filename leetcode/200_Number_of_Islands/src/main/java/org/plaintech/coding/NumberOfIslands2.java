package org.plaintech.coding;
import java.util.*;

public class NumberOfIslands2 {

    int nrow;
    int ncol;

    class Position {
        public int x;
        public int y;

        public Position(int a, int b) {
            x = a;
            y = b;
        }

        public Position getLeft() {
            return y > 0? new Position(x, y - 1): null;
        }

        public Position getRight() {
            return y < ncol - 1? new Position(x, y + 1): null;
        }

        public Position getUp() {
            return x < nrow - 1? new Position(x + 1, y): null;
        }

        public Position getDown() {
            return x > 0? new Position(x - 1, y): null;
        }





    }
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        nrow = grid.length;
        ncol = grid[0].length;
        int[][] visited = new int[nrow][ncol];
        // System.out.println("visited[0][1] is " + visited[0][1]);

        Queue<Position> queue = new LinkedList<Position>();


        int count = 0;
        for (int x = 0; x < nrow; x++) {
            for (int y = 0; y < ncol; y++) {
                // System.out.println("visited[x][y] is " + visited[x][y]);
                // System.out.println("grid[x][y] is " + grid[x][y]);
                if (0 == visited[x][y] && '1' == grid[x][y]) {
                    queue.add(new Position(x, y));
                    count++;

                    System.out.println("count is " + count);

                    while (queue.peek() != null) {
                        Position pos = queue.remove();
                        if (visited[pos.x][pos.y] == 0 && '1' == grid[pos.x][pos.y]) {
                            visited[pos.x][pos.y] = count;
                            if (pos.y > 0) {
                                queue.add(pos.getLeft());
                            }

                            if (pos.x < nrow - 1) {
                                queue.add(pos.getUp());
                            }

                            if (pos.y < ncol - 1) {
                                queue.add(pos.getRight());
                            }

                            if (pos.x > 0) {
                                queue.add(pos.getDown());
                            }

                        }
                    }
                }
            }
        }

        return count;
    }
}
