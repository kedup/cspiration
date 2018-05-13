package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : CourseSchedule
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 207. Course Schedule
 */
public class CourseSchedule {

    /**
     * There are a total of n courses you have to take, labeled from 0 to n - 1.

     Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
     which is expressed as a pair: [0,1]

     Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

     For example:

     2, [[1,0]]
     There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

     2, [[1,0],[0,1]]
     There are a total of 2 courses to take. To take course 1 you should have finished course 0,
     and to take course 0 you should also have finished course 1. So it is impossible.

     3-  0 - 1
         \   /
           2

     入度 = 0

     0 : 1
     1 : 1
     2 : 1

     queue : 2

     pre : 2

     res = 3


     time : O(V + E)
     space : O(n)

     * @param numCourses
     * @param prerequisites
     * @return
     */

    // BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int res = numCourses;
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            res--;
            for (int[] pair : prerequisites) {
                if (pair[1] == pre) {
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0) {
                        queue.offer(pair[0]);
                    }
                }
            }
        }
        return res == 0;
    }
}
