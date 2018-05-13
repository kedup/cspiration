package leetcode;

/**
 * Created by Edward on 23/07/2017.
 */
public class TwoSumII {

    /**
     * 167. Two Sum II - Input array is sorted

     Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

     The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

     You may assume that each input would have exactly one solution and you may not use the same element twice.

     Input: numbers={2, 7, 11, 15}, target=9
     Output: index1=1, index2=2

     time : O(logn)
     space : O(1)
     * @param numbers
     * @param target
     * @return
     */

    public static int[] twoSum(int[] numbers, int target) {

        if (numbers == null || numbers.length < 2) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (target == sum) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{-1, -1};
    }
}
