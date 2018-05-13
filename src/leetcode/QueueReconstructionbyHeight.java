package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : QueueReconstructionbyHeight
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 406. Queue Reconstruction by Height
 */
public class QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        for(int[] cur : people){
            res.add(cur[1],cur);
        }

        return res.toArray(new int[people.length][]);
    }
}
