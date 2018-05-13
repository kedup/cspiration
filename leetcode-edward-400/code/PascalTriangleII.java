package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : PascalTriangleII
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 119. Pascal's Triangle II
 */
public class PascalTriangleII {
    /**
     *
     * [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
     ]
     * For example, given k = 3,
     Return [1,3,3,1].

     time : O(n^2)
     space : O(n)

     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) return res;
        for (int i = 0; i < rowIndex + 1; i++) {
            res.add(0, 1);
            for (int j = 1; j < res.size() - 1; j++) {
                res.set(j, res.get(j) + res.get(j + 1));
            }
        }
        return res;
    }
}
