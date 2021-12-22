# 992. Subarrays with K Different Integers

## problem

Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].

Constraints:

1 <= nums.length <= 2 \* 10^4
1 <= nums[i], k <= nums.length

## solution

这题不难想到是用 sliding window，但是如果在每个 sliding window 都去 check 一次当前 window size 里的 unique integer 的数量 time comlexity 就会变成 O(n^2), tle

这一题很巧妙的思路是 sliding window + reduction
把 solve _subarrays with k different integer_ reduce to _subarrays with **at most** k different integer_
Ans = atmost(k) - atmost(k-1) = exact k

Time Complexity: O(n)
Space Complexity: O(n) -> hashmap/int[]

## code

```java
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysAtMostKDistinct(nums, k)-subarraysAtMostKDistinct(nums, k-1);
    }

    public int subarraysAtMostKDistinct(int[] nums, int k){
        //用arr也可以
        Map<Integer, Integer> countMap = new HashMap<>();
        int start = 0, count = 0;
        for(int i=0; i<nums.length; i++){
            if(countMap.getOrDefault(nums[i], 0)==0){
                k--;
            }
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0)+1);

            while(k<0){
                countMap.put(nums[start], countMap.get(nums[start])-1);
                if(countMap.get(nums[start])==0)
                    k++;
                start++;
            }

            //关于计算number of contiguous subarray of an array
            //If you're given an array of length n, it will produce 1+2+...+n = (n *(n+1))/2 total contiguous subarrays
            //所以对于长度从start到i的这一段区间，贡献给total continuous subarrays的个数为这个区间的长度i-start+1
            count += (i-start + 1);
        }

        return count;
    }
}
```

## For anyone confused about ret += j - i + 1, here's how you can look at it:

**Example: A = [1,2,1,2,3], K = 2**

We know that ret should return the total number of contiguous subarrays with at most K different integers.

We also know that at every iteration, j - i + 1 gives the length of the contiguous subarray.

Given our example, let's see how this is handled in each valid iteration of this code (i.e. the "sliding window" part of this technique).

Here's what we get:

- `[1]` is one valid result of a contiguous subarray that has at most K different integers and has the length of 1.
- `[1,2]` is one valid result of a contiguous subarray that has at most K different integers and has the length of 2.
- `[1,2,1]` is one valid result of a contiguous subarray that has at most K different integers and has the length of 3.
- `[1,2,1,2]` is one valid result of a contiguous subarray that has at most K different integers and has the length of 4.

Then when we see the last element 3, we will see that the only valid contiguous subarray with at most K (which is 2) different integers that can be created is:

- `[2,3]` is one valid result of a contiguous subarray that has at most K different integers and has the length of 2.

So our function will return the sum of the length of all of those subarrays:

- 1 + 2 + 3 + 4 which is 10 different contiguous subarrays with at most K different integers for the subarray [1,2,1,2].
- 2 which is 2 different contiguous subarrays with at most K different integers for the subarray [2,3].

Here the answer is 10 + 2 which is 12 different contiguous subarrays with at most K = 2 different integers.

---

Q: **Now that we know visually what the code is doing, how do we relate that back to the actual subarrays? What exactly are those different contiguous subarrays?**

Great, we have 12 different contiguous subarrays with at most K = 2 different integers, but what does that actually look like logically?

`[1,2,1,2]` will produce a total of 10 different contiguous subarrays:

- [1,2,1,2] (1 different contiguous subarrays with length 4)
- [1,2,1], [2,1,2] (2 different contiguous subarrays with length 3)
- [1, 2], [1,2], [2,1](3 different contiguous subarrays with length 2)
- [1], [2], [1], [2] (4 different contiguous subarrays with length 1)

[2,3] will produce a total of 3 different contiguous subarrays:

- [2,3] (1 different contiguous subarrays with length 2)
- [2], [3] (2 different contiguous subarrays with length 1)

_NOTE: Remember this for a bit later. Grouping it in terms of length will help us understand a point later_

Now you may notice that [2,3] produced a length of 2 earlier, but can actually create 3 different subarrays.
[2,3] will only produce 2 new different contiguous subarrays because [2] was already accounted for in [1,2,1,2].

---

Q: **Okay, I understood all that, but I still don't get why the number of contiguous subarrays is equal to the sum of lengths. Why does that work?**

We want to find all valid contiguous subarrays that[1,2,1,2,3] would produce with at most K different integers.

You will notice though -- that when we say at most K different integers -- we only use K to help us find the valid windows (ex. [1,2,1,2] and [2,3])
Once we have those valid windows though, we don't really care what K is (that's because at most means 0 to K unique Integers, which literally means any contiguous subarray now). So, stop thinking about how K will affect the subarrays to understand the summation of lengths.

Okay, so now that we have our (let's call them "complete") valid subarrays [1,2,1,2] and [2,3] -- we can begin to understand why we take the summation of lengths to count all subarrays. Remember how we listed all the subarrays earlier and how I asked you to remember why we group subarrays by length?

Here's why:
[1,2,1,2] will produce 1 subarrays of length 4, 2 subarrays of length 3, 3 subarrays of length 2, and 4 subarray of length 1 (see above)
[2,3] will produce 1 subarrays of length 2, 2 subarray of length 1 (see above)

Do you notice anything?

[1,2,1,2] = 1 + 2 + 3 + 4 (sum of our 1 subarrays of length 4, 2 subarray of length 3, etc.) = 10
[2,3] = 1 + 2 (\*Special case: this creates 1 subarray of length 2, and 2 subarray of length 2, but since our [2] one was accounted for already, we only get 2 new subarrays so subtract 1) - 1 = 2

When we summed the different lengths (see above where we listed the iterations), we also get the same growth (i.e. 1 + 2 + 3 + 4)!

So another way to understand this in the context of this problem is, that the code above will produce valid (sliding) window (like [1,2], [1,2,1], [1,2,1,2]).
As we expand the length of that window, we can sum the length of those windows to get our different combinations because if our "complete" window was [1,2,1,2],
we could do 1 + 2 + 3 + 4 (or length of [1] + length of [1,2] + length of [1,2,1] + length of [1,2,1,2]).

We also noticed that for [2,3], by only adding 2, we were able to ignore that duplicate subarray. The sliding window did not return [2] because the window expanded to [1,2,1,2,3] -- invalidating the window and then compressed the window to [2,3] by moving i forward. This allowed us to skip those duplicate subarrays. You can expand this to other examples including where K is larger. The fact that our sliding window compresses by moving forward i will allow the lower summations to be ignored (i.e. our duplicate subarrays).

---

**Q: Woah, that was a lot to take in. Does learning this help me with other subarray counting?**

You'll be happy to know that it does! This actually comes up frequently in other Leetcode questions that require us to count different combinations of subarrays.

Grouping the subarrays in terms of length can really help us understand that summing up the lengths can give us the total subarrays.

If you're still not convinced, write out a few examples of arrays of different lengths. The number of subarrays you can create can be related to the length.

Arrays of length 5 will produce 1 + 2 + 3 + 4 + 5 different contiguous subarrays.
Arrays of length 6 will produce 1 + 2 + 3 + 4 + 5 + 6 different contiguous subarrays.
...and the list goes on

**Alternative Formula:**

If you're given an array of length n, it will produce (n \*(n+1))/2 total contiguous subarrays (same as doing the sum above).

This is used often in other questions where we know our array size of n and so we don't need to add [1...n] incrementally like this problem.
