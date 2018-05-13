package leetcode;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ContainsDuplicateIII
 * Creator : Edward
 * Date : Dec, 2017
 * Description : 220. Contains Duplicate III
 */

public class ContainsDuplicateIII {
    /**
     * Given an array of integers, find out whether there are two distinct indices i and j in the array such
     * that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference
     * between i and j is at most k.

     time : O(nlogk)
     space : O(k)

     * @param nums
     * @param k
     * @param t
     * @return
     */

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if( k < 1 || t < 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            Long floor = set.floor((long)nums[i] + t);
            Long ceil = set.ceiling((long)nums[i] - t);

            if((floor != null && floor >= nums[i])
                    || (ceil != null && ceil <= nums[i]) )
                return true;

            set.add((long)nums[i]);
            if(i >= k){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }

    /**

     time : O(n)
     space : O(k)

     * @param nums
     * @param k
     * @param t
     * @return
     */

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}
