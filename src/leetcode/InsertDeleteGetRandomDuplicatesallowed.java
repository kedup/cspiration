package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : InsertDeleteGetRandomDuplicatesallowed
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class InsertDeleteGetRandomDuplicatesallowed {
    /**
     * 381. Insert Delete GetRandom O(1) - Duplicates allowed
     * time : O(1)
     */

    HashMap<Integer, HashSet<Integer>> map;
    ArrayList<Integer> list;
    Random rmd;

    public InsertDeleteGetRandomDuplicatesallowed() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rmd = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) {
            map.put(val, new HashSet<>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return !contain;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        if (map.get(val).size() == 0) {
            map.remove(val);
        }
        int lastVal = list.remove(list.size() - 1);
        if (index != list.size()) {
            list.set(index, lastVal);
            map.get(lastVal).remove(list.size());
            map.get(lastVal).add(index);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rmd.nextInt(list.size()));
    }
}
