# 394. Decode String

## PD

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].

## solution

### solution1

1. Using stack: countStack and resStack
2. loop input s:
   - if the current character is number, calculate what would be the count number
   - if the current character is '[', push the string res to resStack
   - if the current character is ']', calculate the repeat times from previous count number
   - else, the current character must be lower case letter, append to res string

### solution2

recursion + stringbuilder

## code

### solution1

```java
class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();

        String res = "";
        int index = 0;

        while(index<s.length()){
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))){
                    count = 10 * count + (s.charAt(index)-'0');
                    index++;
                }
                countStack.push(count);
            }
            else if(s.charAt(index) == '['){
                resStack.push(res);
                res = "";
                index++;
            }
            else if(s.charAt(index) == ']'){ //repeat what is inside res k times
                int k = countStack.pop();
                StringBuilder sb = new StringBuilder(resStack.pop()); //sb must append resStack.pop() first

                for(int i=0; i<k; i++){
                    sb.append(res);
                }
                res = sb.toString();
                index++;
            }
            else{ // character is lowercase letter
                res += s.charAt(index);
                index++;
            }
        }

        return res;
    }
}
```
