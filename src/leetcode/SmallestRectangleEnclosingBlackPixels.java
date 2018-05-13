package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SmallestRectangleEnclosingBlackPixels
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 302. Smallest Rectangle Enclosing Black Pixels
 */
public class SmallestRectangleEnclosingBlackPixels {
    /**
     * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
     * The black pixels are connected, i.e., there is only one black region.
     * Pixels are connected horizontally and vertically. Given the location (x, y) of
     * one of the black pixels, return the area of the smallest (axis-aligned) rectangle
     * that encloses all black pixels.

     For example, given the following image:

     [
     "0010",
     "0110",
     "0100"
     ]

     011
     011
     011

     and x = 0, y = 2,
     Return 6.

     time : O(m log n + n log m)
     space : O(1)

     * @param image
     * @param x
     * @param y
     * @return
     */
    public int minArea(char[][] image, int x, int y) {
        int row = image.length;
        int col = image[0].length;

        int left = binarySearchLeft(image, 0, y, true);
        int right = binarySearchRight(image, y, col - 1, true);

        int top = binarySearchLeft(image, 0, x, false);
        int bottom = binarySearchRight(image, x, row - 1, false);

        return (right - left + 1) * (bottom - top + 1);
    }

    private int binarySearchLeft(char[][] image, int left, int right, boolean isHor) {
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (hasBlack(image, mid, isHor)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (hasBlack(image, left, isHor)) {
            return left;
        }
        return right;
    }

    private int binarySearchRight(char[][] image, int left, int right, boolean isHor) {
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (hasBlack(image, mid, isHor)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (hasBlack(image, right, isHor)) {
            return right;
        }
        return left;
    }

    private boolean hasBlack(char[][] image, int x, boolean isHor) {
        if (isHor) {
            for (int i = 0; i < image.length; i++) {
                if (image[i][x] == '1') return true;
            }
        } else {
            for (int i = 0; i < image[0].length; i++) {
                if (image[x][i] == '1') return true;
            }
        }
        return false;
    }
}
