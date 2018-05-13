package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FirstBadVersion
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class FirstBadVersion {
    /**
     * 278. First Bad Version
     * You are a product manager and currently leading a team to develop a new product. Unfortunately,
     * the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

     Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
     which causes all the following ones to be bad.

     You are given an API bool isBadVersion(version) which will return whether version is bad.
     Implement a function to find the first bad version. You should minimize the number of calls to the API.

                 bad
     1, 2, 3, 4, 5, 6, 7

     time : O(logn)
     space : O(1)
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (isBadVersion(mid)) {
                end = mid;
            } else start = mid;
        }
        if (isBadVersion(start)) {
            return start;
        }
        return end;
    }

    public boolean isBadVersion(int mid) {
        return true;
    }
}
