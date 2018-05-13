package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ReadNCharactersGivenRead4II_Callmultipletimes
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 158. Read N Characters Given Read4 II - Call multiple times
 */
public class ReadNCharactersGivenRead4II_Callmultipletimes {
    /**
     *
     case :
     abcd efgh igk 11
     case 1 : n = 8 first time read 4 next count == 4 index == n
     case 2 : n = 7 first time read 4 next count == 3 index == n

     abcd efgh igk 11
     n = 2 count = 4  buf[ab] pointer = 2 temp[abcd]
     n = 3 index = 3  buf[cd] pointer = 0
            temp[efgh] count = 4 buf[cde] pointer = 1


     time : O(n);
     space : O(1);


     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

    private int count = 0;
    private int pointer = 0;
    private char[] temp = new char[4];

    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            if (pointer == 0) {
                count = read4(temp);
            }
            if (count == 0) break;
            while (index < n && pointer < count) {
                buf[index++] = temp[pointer++];
            }
            if (pointer == count) pointer = 0;
        }
        return index;
    }

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
