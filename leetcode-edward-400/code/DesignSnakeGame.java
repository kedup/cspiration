package leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : DesignSnakeGame
 * Creator : Edward
 * Date : Jan, 2018
 * Description : 353. Design Snake Game
 */
public class DesignSnakeGame {

    HashSet<Integer> set; // 位置
    Deque<Integer> deque;
    int score;
    int foodIndex;
    int width;
    int height;
    int[][] food;

    public DesignSnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        set = new HashSet<>();
        deque = new LinkedList<>();
        score = 0;
        foodIndex = 0;
        set.add(0);
        deque.offerLast(0);
    }

    public int move(String direction) {
        if (score == -1) {
            return -1;
        }

        int rowHead = deque.peekFirst() / width;
        int colHead = deque.peekFirst() % width;

        switch (direction) {
            case "U" : rowHead--;
                break;
            case "D" : rowHead++;
                break;
            case "L" : colHead--;
                break;
            default : colHead++;
        }
        int head = rowHead * width + colHead;
        set.remove(deque.peekLast());
        if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
            return score = -1;
        }
        set.add(head);
        deque.offerFirst(head);
        if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            foodIndex++;
            ++score;
            set.add(deque.peekLast());
            return score;
        }
        deque.pollLast();
        return score;
    }
}
