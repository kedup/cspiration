package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : NestedInteger
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class NestedInteger {

    Integer value;
    List<NestedInteger> list;

    NestedInteger() {
        value = new Integer(0);
        list = new ArrayList<>();
    }
    NestedInteger(int value) {
        this.value = value;
    }
    NestedInteger(int value, List<NestedInteger> list) {
        this.value = value;
        this.list = list;
    }
    public void add(NestedInteger nestedInteger){}

    // @return true if this NestedInteger holds a single integer,
    // rather than a nested list.
    public boolean isInteger() {
        return value != null;
    }
    // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return value;
    }
    // @return the nested list that this NestedInteger holds,
    // if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return list;
    }

    public Integer next() {
        return value; // 例子，真正函数不是这么写的
    }
    public boolean hasNext() {
        return true; // 例子，真正函数不是这么写的
    }
}
