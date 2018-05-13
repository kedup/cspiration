package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : CompareVersionNumbers
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 165. Compare Version Numbers
 */
public class CompareVersionNumbers {
    /**
     * Compare two version numbers version1 and version2.
     If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

     You may assume that the version strings are non-empty and contain only digits and the . character.
     The . character does not represent a decimal point and is used to separate number sequences.
     For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

     Here is an example of version numbers ordering:

     0.1 < 1.1 < 1.2 < 13.37

     time : O(n)
     space : O(n)

     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }
}
