package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : IntegertoRoman
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class IntegertoRoman {
    /**
     * 12. Integer to Roman

     time : O(n)
     space : O(n)
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}
