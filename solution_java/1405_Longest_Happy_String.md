# 1405. Longest Happy String

## problem

A string is called happy if it does not have any of the strings 'aaa', 'bbb' or 'ccc' as a substring.

Given three integers a, b and c, return any string s, which satisfies following conditions:

s is happy and longest possible.
s contains at most a occurrences of the letter 'a', at most b occurrences of the letter 'b' and at most c occurrences of the letter 'c'.
s will only contain 'a', 'b' and 'c' letters.
If there is no such string s return the empty string "".

Example 1:

Input: a = 1, b = 1, c = 7
Output: "ccaccbcc"
Explanation: "ccbccacc" would also be a correct answer.
Example 2:

Input: a = 2, b = 2, c = 1
Output: "aabbc"
Example 3:

Input: a = 7, b = 1, c = 0
Output: "aabaa"
Explanation: It's the only correct answer in this case.

Constraints:

0 <= a, b, c <= 100
a + b + c > 0

## solution

**greedy**

1. the basic idea is to pick from the highest frequency
2. to balance the frequency as much as possible
3. and according to the definition of happy string we can choose at most two 'a'/'b'/'c' each round

e.g. for a>b>c
try to pick more a than b to make a==b>c

## code

```java
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        //用A,B,C来count当前'a','b','c'的数量
        int A=0, B=0, C=0;
        int size = a + b + c;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++){
            if((a>=b && a>=c && A!=2) || (B==2 && a>0 && a>=c) || (C==2 && a>0 && a>=b)){
                sb.append('a');
                a--;
                A++;
                B=0;
                C=0;
            }
            else if((b>=a && b>=c && B!=2) || (A==2 && b>0 && b>=c) || (C==2 && b>0 && b>=a)){
                sb.append('b');
                b--;
                B++;
                A=0;
                C=0;
            }
            else if((c>=a && c>=b && C!=2) || (A==2 && c>0 && c>=b) || (B==2 && c>0 && c>=a)){
                sb.append('c');
                c--;
                C++;
                A=0;
                B=0;
            }
            else
               break;
        }

        return sb.toString();
    }
}
```
