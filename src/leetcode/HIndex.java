package leetcode;

import java.util.Arrays;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : HIndex
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 274. H-Index
 */
public class HIndex {
    /**
     * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total
     * and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at
     * least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

     * 0 1 2 3 4
     * 6 5 3 1 0
     */
    // time : O(nlogn) space : O(1)
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        while (res < citations.length && citations[citations.length - 1 - res] > res) {
            res++;
        }
        return res;
    }

    // time : O(n) space : O(n)
    public int hIndex2(int[] citations) {
        int[] helper = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            helper[citations[i] <= citations.length ? citations[i] : citations.length] += 1;
        }
        int sum = 0;
        for (int i = citations.length; i > 0; i--) {
            sum += helper[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
