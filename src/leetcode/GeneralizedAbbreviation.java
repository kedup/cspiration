package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : GeneralizedAbbreviation
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 320. Generalized Abbreviation
 */
public class GeneralizedAbbreviation {
    /**
     * Example:
     Given word = "word", return the following list (order does not matter):
     ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

     ["4","3d","2r1","2rd","1o2","1o1d","1or1","1ord","w3","w2d","w1r1","w1rd","wo2","wo1d","wor1","word"]

     time : O(2^n)
     space : O(n) (不确定)

     * @param word
     * @return
     */
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, word, 0, "", 0);
        return res;
    }

    public void helper(List<String> res, String word, int pos, String cur, int count) {
        if (pos == word.length()) {
            if (count > 0) cur += count;
            res.add(cur);
        } else {
            helper(res, word, pos + 1, cur, count + 1);
            helper(res, word, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
        }

    }

}
