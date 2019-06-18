package org.plaintech.coding;

import java.util.*;

class NumberOfIslands {

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

    private void enqueue(Position p, Queue<Position> q, int[][] visited, char[][] grid) {
        if (null == p) {
            return;
        }

        if ((visited[p.x][p.y] == 0) && ('1' == grid[p.x][p.y])) {
            q.add(p);
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

                    // System.out.println("count is " + count);

                    while (queue.peek() != null) {
                        Position p = queue.remove();
                        if ((visited[p.x][p.y] == 0) && ('1' == grid[p.x][p.y])) {
                            visited[p.x][p.y] = count;
                            // System.out.println("Visiting pos (" + p.x + ", " + p.y + ")");
                            enqueue(p.getLeft(), queue, visited, grid);
                            enqueue(p.getUp(), queue, visited, grid);
                            enqueue(p.getRight(), queue, visited, grid);
                            enqueue(p.getDown(), queue, visited, grid);

                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '1'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '1', '0', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}
        };

        NumberOfIslands sol = new NumberOfIslands();
        int num = sol.numIslands(grid);
        System.out.println("num is " + num);
    }

}

