# 528. Random Pick with Weight

## problem

You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.

You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).

For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).

Example 1:

Input
["Solution","pickIndex"]
[[[1]],[]]
Output
[null,0]

Explanation
Solution solution = new Solution([1]);
solution.pickIndex(); // return 0. The only option is to return 0 since there is only one element in w.

Example 2:

Input
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output
[null,1,1,1,1,0]

Explanation
Solution solution = new Solution([1, 3]);
solution.pickIndex(); // return 1. It is returning the second element (index = 1) that has a probability of 3/4.
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 1
solution.pickIndex(); // return 0. It is returning the first element (index = 0) that has a probability of 1/4.

Since this is a randomization problem, multiple answers are allowed.
All of the following outputs can be considered correct:
[null,1,1,1,1,0]
[null,1,1,1,1,1]
[null,1,1,1,0,0]
[null,1,1,1,0,1]
[null,1,0,1,0,0]
......
and so on.

Constraints:

1 <= w.length <= 104
1 <= w[i] <= 105
pickIndex will be called at most 104 times.

## solution

1. 累加 int[] w
   index: 0, 1, 2, 3, 4
   w = [1, 8, 9, 3, 6]
   prob = [1/27, 8/27, 9/27, 3/27, 6/27]
   newW = [1, 9, 19, 21, 27]

2. binary search 找出 random 是在哪个区间：

- 如果是 0 ～ 1，return index0
- 如果是 1 ～ 9，return index1
- 如果是 9 ～ 19，return index2
- 如果是 19 ～ 21，return index3
- 如果是 21 ～ 27，return index4

3. java 怎么获得范围内的随机数

```java
import java.util.Random;
Random rand = new Random();
//Obtain a number between [0 - 49].
int n = rand.nextInt(50);
```

## code

```java
class Solution {
    Random rand;
    int[] weight;

    public Solution(int[] w) {
        for(int i=1; i<w.length; i++){
            w[i] += w[i-1];
        }
        this.weight = w;
        rand = new Random();
    }

    public int pickIndex() {
        //import java.util.Random;
        //Random rand = new Random();
        // Obtain a number between [0 - 49].
        //int n = rand.nextInt(50);

        int n = rand.nextInt(weight[weight.length-1])+1;
        int low=0, high=weight.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(weight[mid]==n)
                return mid;
            else if(weight[mid]<n)
                low = mid+1;
            else
                high = mid-1;
        }

        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
```
