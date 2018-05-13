package leetcode;

import java.util.*;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ReconstructItinerary
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 332. Reconstruct Itinerary
 */
public class ReconstructItinerary {

    /**
     * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
     * reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK.
     * Thus, the itinerary must begin with JFK.

     Note:
     If there are multiple valid itineraries, you should return the itinerary that
     has the smallest lexical order when read as a single string. For example,
     the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
     All airports are represented by three capital letters (IATA code).
     You may assume all tickets form at least one valid itinerary.

     Example 1:
     tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
     Return ["JFK", "MUC", "LHR", "SFO", "SJC"].

     Example 2:
     tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     Return ["JFK","ATL","JFK","SFO","ATL","SFO"].

     Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
     But it is larger in lexical order.


     DFS(HashMap) + PriorityQueue

     JFK   SFO
            |
         ATL


     time : O(nlogn)
     space : O(n)

     */

    HashMap<String, PriorityQueue<String>> map;
    List<String> res;

    public List<String> findItinerary(String[][] tickets) {
        map = new HashMap<>();
        res = new LinkedList<>();
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        helper("JFK");
        return res;
    }

    private void helper(String airport) {
        while (map.containsKey(airport) && !map.get(airport).isEmpty()) {
            helper(map.get(airport).poll());
        }
        res.add(0, airport);
    }

    public List<String> findItinerary2(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();

        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        }

        List<String> res = new LinkedList();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.empty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                stack.push(map.get(stack.peek()).poll());
            }
            res.add(0, stack.pop());
        }

        return res;
    }
}
