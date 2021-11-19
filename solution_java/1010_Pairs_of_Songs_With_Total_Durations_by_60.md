# 1010. Pairs of Songs With Total Durations Divisible by 60

## problem description

You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

Example 1:

Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60

Example 2:

Input: time = [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.

Constraints:

1 <= time.length <= 6 \* 104
1 <= time[i] <= 500

## solution

1. Let target in Two Sum be 60 and each item in time % 60, then the two problems are very similar to each other.

2. edge case:

Let theOther be in the pair with t, then
(t + theOther) % 60 == 0

so we have
t % 60 + theOther % 60 = 0 or 60

theOther % 60 = 60 - t % 60
theOther = (60 - t % 60 ) % 60

## code

```java
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int res = 0;

        for(int t : time){
            t = t % 60;
            int x = (60 - t % 60) % 60;
            res += count[x];
            count[t]++;
        }

        return res;
    }
}
```
