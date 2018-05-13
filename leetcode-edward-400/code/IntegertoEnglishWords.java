package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : IntegertoEnglishWords
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 273. Integer to English Words
 */
public class IntegertoEnglishWords {
    /**
     * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

     For example,
     123 -> "One Hundred Twenty Three"
     12345 -> "Twelve Thousand Three Hundred Forty Five"
     1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

     time : O(n) / O(1)
     space : O(1)


     */
    String[] less20={"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens={"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands={"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String res = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                res = helper(num % 1000) + thousands[i] + " " + res;
            }
            num /= 1000;
            i++;
        }
        return res.trim();
    }
    public String helper(int num) {
        if (num == 0) return "";
        if (num < 20) {
            return less20[num % 20] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return less20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
