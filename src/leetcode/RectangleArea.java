package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : RectangleArea
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 223. Rectangle Area
 */
public class RectangleArea {

    /**
     *
     * time : O(1)
     * space : O(1)
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @param E
     * @param F
     * @param G
     * @param H
     * @return
     */

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = (C - A) * (D - B);
        int areaB = (G - E) * (H - F);

        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);

        int overlap = 0;
        if (right > left && top > bottom) {
            overlap = (right - left) * (top - bottom);
        }
        return areaA + areaB - overlap;
    }
}
