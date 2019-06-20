package org.plaintech.coding;

public class CitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int nrow = grid.length;
        int ncol = grid[0].length;

        int[] rowMax = new int[nrow];
        int[] colMax = new int[ncol];

        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                int height = grid[i][j];
                rowMax[i] = Math.max(height, rowMax[i]);
                colMax[j] = Math.max(height, colMax[j]);
            }
        }

        int accu = 0;
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                accu += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }

        return accu;
    }

}
