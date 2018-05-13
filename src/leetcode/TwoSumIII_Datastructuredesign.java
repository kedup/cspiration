package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : TwoSumIII_Datastructuredesign
 * Creator : Edward
 * Date : Aug, 2017
 * Description : 170. Two Sum III - Data structure design
 */
public class TwoSumIII_Datastructuredesign {

    /**
     * Design and implement a TwoSum class. It should support the following operations: add and find.

     add - Add the number to an internal data structure.
     find - Find if there exists any pair of numbers which sum is equal to the value.

     For example,
     add(1); add(3); add(5);
     find(4) -> true
     find(7) -> false

     */

    /** Initialize your data structure here. */

    private HashMap<Integer, Integer> map;

    // 构造函数，leetcode中是TwoSum
    public TwoSumIII_Datastructuredesign() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (!map.containsKey(number)) {
            map.put(number, 1);
        } else {
            map.put(number, map.get(number) + 1);
        }
    }

    // time : O(n)
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int i = entry.getKey();
            int j = value - i;
            if ((i == j && entry.getValue() > 1) || (i != j && map.containsKey(j))) {
                return true;
            }
        }
        return false;
    }

    /**------------------------------------------分割线--------------------------------------------------**/

    //构造函数，leetcode中是TwoSum, map 在上一个解法中有

    private List<Integer> list;

    public void TwoSum() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public void add2(int number) {
        if (!map.containsKey(number)) {
            map.put(number, 1);
            list.add(number);
        } else {
            map.put(number, map.get(number) + 1);
        }
    }

    // time : O(n)
    public boolean find2(int value) {
        for (Integer num1 : list) {
            int num2 = value - num1;
            if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) {
                return true;
            }
        }
        return false;
    }
}