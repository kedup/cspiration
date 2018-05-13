package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : RotateImage
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 48. Rotate Image
 */
public class RotateImage {
    /**
     * Example 1:

     Given input matrix =
     [
     [1,2,3],
     [4,5,6],
     [7,8,9]
     ],

     rotate the input matrix in-place such that it becomes:
     [
     [7,4,1],
     [8,5,2],
     [9,6,3]
     ]

     [
     [1,4,7],
     [2,5,8],
     [3,6,9]
     ]

     time : O(n * m)
     space : O(1)
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
