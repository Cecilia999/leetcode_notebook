// 描述
// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
// 并保证奇数和奇数，偶数和偶数之间的相对位置不变。

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param array int整型一维数组 
     * @return int整型一维数组
     */
    public int[] reOrderArray (int[] array) {
        // write code here
        int[] res = new int[array.length];
        int index = 0;
        for(int i=0; i<array.length; i++){
            if(array[i]%2!=0){
                res[index] = array[i];
                index++;
            }
        }
        
        for(int i=0; i<array.length; i++){
            if(array[i]%2==0){
                res[index] = array[i];
                index++;
            }
        }
        
        return res;
    }
}