# 1481. Least Number of Unique Integers after K Removals

## problem

Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.

Example 1:

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.
Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.

Constraints:

1 <= arr.length <= 10^5
1 <= arr[i] <= 10^9
0 <= k <= arr.length

## solution

hashmap + array to records the occurance

## code

```java
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 0);
            }
            map.put(arr[i], map.get(arr[i]) + 1);
        }

        //记录出现1次，2次...value次 的integer有几个
        int[] occurance = new int[arr.length+1];
        for(int value : map.values()){
            occurance[value]++;
        }
        int freq = 1, remain=map.size();

        while(k>0){
            if(k - freq * occurance[freq] < 0){
               break;
            }
            k -= freq * occurance[freq];
            remain -= occurance[freq];
            freq++;
        }

        return remain - k/freq;
    }
}
```
