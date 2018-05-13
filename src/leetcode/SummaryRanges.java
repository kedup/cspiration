package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SummaryRanges
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class SummaryRanges {
    /**
     * 228. Summary Ranges
     * Given a sorted integer array without duplicates, return the summary of its ranges.

     Example 1:
     Input: [0,1,2,4,5,7]
     Output: ["0->2","4->5","7"]
     Example 2:
     Input: [0,2,3,4,6,8,9]
     Output: ["0","2->4","6","8->9"]

     time : O(n)
     space : O(n)
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (num != nums[i]) {
                res.add(num + "->" + nums[i]);
            } else {
                res.add(num + "");
            }
        }
        return res;
    }
}
