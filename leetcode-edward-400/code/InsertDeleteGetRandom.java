package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : InsertDeleteGetRandom
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class InsertDeleteGetRandom {
    /**
     * 380. Insert Delete GetRandom O(1)
     * Design a data structure that supports all following operations in average O(1) time.

     insert(val): Inserts an item val to the set if not already present.
     remove(val): Removes an item val from the set if present.
     getRandom: Returns a random element from current set of elements. Each element must have
     the same probability of being returned.

     time : O(1);
     */

    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random rmd;

    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rmd = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int index = map.remove(val);
        int lastVal = list.remove(list.size() - 1);
        if (index != list.size()) {
            list.set(index, lastVal);
            map.put(lastVal, index);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rmd.nextInt(list.size()));
    }
}
