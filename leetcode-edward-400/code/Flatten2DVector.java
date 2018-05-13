package leetcode;

import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : Flatten2DVector
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 251. Flatten 2D Vector
 */
public class Flatten2DVector {
    /**
     * Given 2d vector =

     [
     [1,2],
     [3],
     [4,5,6]
     ]
     By calling next repeatedly until hasNext returns false,
     the order of elements returned by next should be: [1,2,3,4,5,6].

     time : O(n)
     space : O(1)

     */

    int indexList, indexElement;
    List<List<Integer>> list;


    public Flatten2DVector(List<List<Integer>> vec2d) {
        indexElement = 0;
        indexList = 0;
        list = vec2d;
    }


    //@Override
    public Integer next() {
        return list.get(indexList).get(indexElement++);
    }

    //@Override
    public boolean hasNext() {
        while (indexList < list.size()) {
            if (indexElement < list.get(indexList).size()) {
                return true;
            } else {
                indexList++;
                indexElement = 0;
            }
        }
        return false;
    }
}
