package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ReadNCharactersGivenRead4
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 157. Read N Characters Given Read4
 */
public class ReadNCharactersGivenRead4 {
    /**
     *
     case :
     abcd efgh igk 11
     case 1 : n = 8 first time read 4 next count == 4 index == n
     case 2 : n = 7 first time read 4 next count == 3 index == n

     case :
     abc 3
     case 1 : n = 4 count = 3 count < 4

     time : O(n);
     space : O(1);


     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int index = 0;
        while (true) {
            int count = read4(temp);
            count = Math.min(count, n - index);
            for (int i = 0; i < count; i++) {
                buf[index++] = temp[i];
            }
            if (index == n || count < 4) return index;
        }
    }

    /**
     * abcdefghijk
     * char[] temp = new char[4]; temp : ijk 3
     *
     * @param temp
     * @return
     */

    //辅助函数，正常不是这么写
    public int read4(char[] temp) {
        char[] res = new char[10];
        char[] ret = new char[4];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            if (index < 4){
                ret[index++] = temp[i];
            }
        }
        return index;
    }
}
