package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : helperAddresses
 * Creator : Edward
 * Date : Dec, 2017
 * Descrstion : 93. Restore IP Addresses
 */
public class RestoreIPAddresses {
    /**
     * Given a string containing only digits, restore it by returning all possible valid s address combinations.

     For example:
     Given "25525511135",

     return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

     time : O(3^4) => O(1) => O(3^n)
     space : O(n)
     
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, "", 0);
        return res;
    }
    public void helper(List<String> res, String s, int index, String ret, int count) {
        if (count > 4) return;
        if (count == 4 && index == s.length()) {
            res.add(ret);
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (index + i > s.length()) break;
            String temp = s.substring(index, index + i);
            if ((temp.startsWith("0") && temp.length() > 1) || (i == 3 && Integer.parseInt(temp) >= 256)) continue;
            helper(res, s, index + i, ret + temp + (count == 3 ? "" : "."), count + 1);
        }
    }
}
