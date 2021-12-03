# 828. Count Unique Characters of All Substrings of a Given String

## problem description

Let's define a function countUniqueChars(s) that returns the number of unique characters on s.

For example if s = "LEETCODE" then "L", "T", "C", "O", "D" are the unique characters since they appear only once in s, therefore countUniqueChars(s) = 5.
Given a string s, return the sum of countUniqueChars(t) where t is a substring of s.

Notice that some substrings can be repeated so in this case you have to count the repeated ones too.

Example 1:

Input: s = "ABC"
Output: 10
Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
Evey substring is composed with only unique letters.
Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10

Example 2:

Input: s = "ABA"
Output: 8
Explanation: The same as example 1, except countUniqueChars("ABA") = 1.

Example 3:

Input: s = "LEETCODE"
Output: 92

Constraints:

1 <= s.length <= 105
s consists of uppercase English letters only.

## solution

........A........A.........A......
假设 string s 中有三个 A, each A would only count when they are not in the same substring with other As

e.g.:  
Think about string "XAXAXXAX" and focus on making the **second "A"** a unique character.
We can take "XA(XAXX)AX" and between "()" is our substring.
We can see here, to make the **second "A"** counted as a uniq character, we need to:

insert "(" somewhere between the first and second A
insert ")" somewhere between the second and third A
For step 1 we have "A(XA" and "AX(A", 2 possibility.
For step 2 we have "A)XXA", "AX)XA" and "AXX)A", 3 possibilities.

So there are in total 2 \* 3 = 6 ways to make the second A a unique character in a substring.
In other words, **there are only 6 substring, in which this A contribute 1 point as unique string.**

不是对多有的 substring count 对于的 unique char 有多少个，而是对于每个 char，看这个 char 在多少个 substring 中是 unique 的

Instead of counting all unique characters and struggling with all possible substrings,
we can count for every char in S, how many ways to be found as a unique char.
We count and sum, and it will be out answer.

1. 用 index[26][2] 来存 character c last two occurrence index 的位置
2. Initialise all values in index to -1.
3. Loop on string S, for every character c, update its last two occurrence index to index[c]
4. Count when loop. For example, if "A" appears twice at index 3, 6, 9 seperately, we need to count:
   For the first "A": (6-3) _ (3-(-1))"
   For the second "A": (9-6) _ (6-3)"
   For the third "A": (N-9) \* (9-6)"

Complexity
One pass, time complexity O(N).
Space complexity O(1).

## code

```java
class Solution{
    public int uniqueLetterString(String s) {
        int[][] index = new int[26][2];
        for(int i=0; i<26; i++){
            Arrays.fill(index[i], -1);
        }
        int res = 0, n=s.length();
        int mod = (int)Math.pow(10, 9) + 7;
        for(int i=0; i<n; i++){
            int c = s.charAt(i)-'A';
            res = (res + (i-index[c][1]) * (index[c][1]-index[c][0]) % mod ) % mod;
            //update index[c]
            index[c] = new int[]{index[c][1], i};
        }
        //for the last
        for(int c=0; c<26; c++){
            res = (res + (n-index[c][1]) * (index[c][1]-index[c][0]) % mod ) % mod;
        }

        return res;
    }
}

//timeout O(n^3)
// class Solution {
//     Map<String, Integer> memo = new HashMap<>();
//     public int uniqueLetterString(String s) {
//         int res = 0;
//         for(int i=0; i<s.length(); i++){
//             for(int j=i; j<s.length(); j++){
//                 String subString = s.substring(i, j+1);
//                 res += findUnique(subString);
//             }
//         }
//         return res;
//     }

//     public int findUnique(String s){
//         if(memo.containsKey(s)) return memo.get(s);

//         int[] letters = new int[26];
//         for(char c : s.toCharArray()){
//             letters[c-'A']++;
//         }

//         int res = 0;
//         for(int i=0; i<26; i++){
//             if(letters[i]==1)
//                 res++;
//         }

//         memo.put(s, res);
//         return res;
//     }
// }
```
