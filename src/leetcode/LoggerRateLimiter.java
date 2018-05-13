package leetcode;

import java.util.HashMap;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : LoggerRateLimiter
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 359. Logger Rate Limiter
 */
public class LoggerRateLimiter {
    /**
     * Example:

     Logger logger = new Logger();

     // logging string "foo" at timestamp 1
     logger.shouldPrintMessage(1, "foo"); returns true;

     // logging string "bar" at timestamp 2
     logger.shouldPrintMessage(2,"bar"); returns true;

     // logging string "foo" at timestamp 3
     logger.shouldPrintMessage(3,"foo"); returns false;

     // logging string "bar" at timestamp 8
     logger.shouldPrintMessage(8,"bar"); returns false;

     // logging string "foo" at timestamp 10
     logger.shouldPrintMessage(10,"foo"); returns false;

     // logging string "foo" at timestamp 11
     logger.shouldPrintMessage(11,"foo"); returns true;

     time : O(1)
     space : O(n)

     */
    /** Initialize your data structure here. */
    HashMap<String, Integer> map;

    public LoggerRateLimiter() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
            return true;
        }
        return false;
    }
}
