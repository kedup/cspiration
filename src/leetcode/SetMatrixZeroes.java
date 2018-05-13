package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SetMatrixZeroes
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 73. Set Matrix Zeroes
 */
public class SetMatrixZeroes {
    /**

     [
      [1, 0, 1, 1],
      [1, 1, 0, 0],
      [0, 1, 1, 1],
      [1, 1, 1, 1]
     ]

     time : O(n * m)
     space : O(1)

     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0) row = true;
                    if (j == 0) col = true;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
