# 696. Count Binary Substrings

## 题目大意

Give a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

Example 1:

Input: s = "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.

## 解题思路

two pointer, cur & pre to count 0/1 bits
each time s.charAt(i)!=s.charAt(i-1), calculate Math.min(cur, pre) and add to res

## code

```java
class Solution {
    public int countBinarySubstrings(String s) {
        //一个cur count当前一样的bit，pre保留之前一样的bit
        //每次bit从0变成1或者从1变成0就计算一次更新

        int count = 0;
        int cur = 1, pre = 0;
        for(int i = 1; i<s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1)) cur++;
            else{
                count += Math.min(cur, pre);
                pre = cur;
                cur = 1;
            }

        }

        return count + Math.min(cur, pre);
    }
}
```
