# 423. Reconstruct Original Digits from English423. Reconstruct Original Digits from English

## problem

Given a string s containing an out-of-order English representation of digits 0-9, return the digits in ascending order.

Example 1:

Input: s = "owoztneoer"
Output: "012"
Example 2:

Input: s = "fviefuro"
Output: "45"

Constraints:

1 <= s.length <= 105
s[i] is one of the characters ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"].
s is guaranteed to be valid.

## code

```java
class Solution {
    public String originalDigits(String s) {
        //找出每个字母中的unique的letter
        // String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int[] count = new int[10];

        for(char c : s.toCharArray()){
            if(c=='z') count[0]++;
            if(c=='w') count[2]++;
            if(c=='u') count[4]++;
            if(c=='x') count[6]++;
            if(c=='g') count[8]++;
            if(c=='s') count[7]++; //7-6
            if(c=='f') count[5]++; //5-4
            if(c=='t') count[3]++; //3-2-8
            if(c=='i') count[9]++; //9-8-6-5
            if(c=='o') count[1]++; //1-0-2-4
        }

        count[7] -= count[6];
        count[5] -= count[4];
        count[3] -= (count[2] + count[8]);
        count[9] -= (count[8] + count[6] + count[5]);
        count[1] -= (count[0] + count[2] + count[4]);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++){
            while(count[i]!=0){
                sb.append((char)(i+'0'));
                count[i]--;
            }
        }

        return sb.toString();
    }
}
```
