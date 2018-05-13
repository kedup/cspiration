package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MajorityElement
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 169. Majority Element
 */
public class MajorityElement {

    /**
     * Given an array of size n, find the majority element. The majority element is the element
     * that appears more than ⌊ n/2 ⌋ times.

     You may assume that the array is non-empty and the majority element always exist in the array
     * @param nums
     * @return
     */

    // time : O(nlogn) space : O(1)
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // time : O(n) space : O(n)
    public int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num) > nums.length / 2) {
                res = num;
                break;
            }
        }
        return res;
    }

    // Moore voting algorithm
    // 每次都找出一对不同的元素，从数组中删掉，直到数组为空或只有一种元素。
    // 不难证明，如果存在元素e出现频率超过半数，那么数组中最后剩下的就只有e。
    // [1,2,3,3,3]
    // time : O(n) space : O(1)
    public int majorityElement3(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            if (num != res) {
                count--;
            } else count++;
        }
        return res;
    }

}
