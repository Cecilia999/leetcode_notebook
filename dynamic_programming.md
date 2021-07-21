# Dynamic Programming

## 1. Number Tower

- [64. Minimum Path Sum 最小路径和](https://leetcode.com/problems/minimum-path-sum/):
  [java](/solution_java/0064_Minimum_Path_Sum.java)
- [120. Triangle 三角形最小路径和](https://leetcode.com/problems/triangle/):
  [java](/solution_java/0120_Triangle.java)

## 2. Fibonacci Numbers

1. fibonacci num

- [JZ10 矩形覆盖](https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&&tqId=11163&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking):
  [java](/牛客网/矩形覆盖.md)

2. climbing stairs

- [70. Climbing_Stairs](https://leetcode.com/problems/climbing-stairs/):
  [Solution](/solution_java/0070_Climbing_Stairs.java)
- [746. Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/):
  [Solution](/solution_java/0746_Min_Cost_Climbing_Stairs.java)
- [跳台阶扩展问题](https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&&tqId=11162&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking):  
  [java](/牛客网/跳台阶扩展问题.java)

3. house robber

- [198. House Robber](https://leetcode.com/problems/house-robber/):
  [java](/solution_java/0198_House_Robber.java)
- [213. House Robber II](https://leetcode.com/problems/house-robber-ii/):
  [java](/solution_java/0213_House_Robber_II.java)

## 3. Memory Search 记忆化搜索

- [139. Word Break](https://leetcode.com/problems/word-break/):
  [java](/solution_java/0139_Word_Break.java)
- [329. Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/):
  [java](/solution_java/0329_Longest_Increasing_Path_in_a_Matrix.java)

## 4. 0/1 Knapsack (0/1 背包)

- 4.1 Equal Subset Sum Partition，相等子集划分问题

  - [416. Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/): [Solution](/solution_java/0416_Partition_Equal_Subset_Sum.java)

- 4.2 Subset Sum，子集和问题

  - [494. Target Sum](https://leetcode.com/problems/target-sum/):
    [Solution](/solution_java/0494_Target_Sum.java)

- 4.3 Minimum Subset Sum Difference，子集和的最小差问题

  - [1049. Last Stone Weight II](https://leetcode.com/problems/last-stone-weight-ii/):
    [Solution](/solution_java/1049_Last_Stone_Weight_II.java)

- 4.4 其他

  - [474. Ones and Zeroes](https://leetcode.com/problems/ones-and-zeroes/):
    [java](/solution_java/474_Ones_and_Zeroes.java)

## 5. Unbounded Knapsack，无限背包 （repetition of items are allowed）

- 5.1 Coin Change 换硬币问题

  - [322. Coin Change](https://leetcode.com/problems/coin-change/):
    [java](/solution_java/0322_Coin_Change.java)
  - [518. Coin Change 2](https://leetcode.com/problems/coin-change-2/):
    [java](/solution_java/0518_Coin_Change_2.java)

## 6.counting dp 计数 dp

计算有多少种方式/多少种可能

### 6.1 string 的 计数 dp

- [91. Decode Ways](https://leetcode.com/problems/decode-ways/)：
  [java](/solution_java/0091_Decode_Ways.java)

### 6.2 二维 array 的计数 dp

- [62. Unique Paths](https://leetcode.com/problems/unique-paths/):
  [java](/solution_java/0062_Unique_Paths.java)
- [63. Unique Paths II](https://leetcode.com/problems/unique-paths-ii/):
  [java](/solution_java/0063_Unique_Paths_II.java)

## 7. Optimal Solution，最优解问题 (最大值/最小值/最大利润/最小 cost/etc)

### 7.1 数组

- [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/):
  [java](/solution_java/0053_Maximum_Subarray.java)
  **这道题等同于**
- [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/):
  [java](/solution_java/0121_Best_Time_to_Buy_and_Sell_Stock)
- [152. Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/):
  [java](/solution_java/0152_Maximum_Product_Subarray.java)
- [Integer Break](https://leetcode.com/problems/integer-break/):
  [java](/solution_java/0343_Integer_Break.java)

## 8. Subsequence/Substring，子序列/子字符串

### 8.1. Longest Subsequence/Substring(Subarray)，最长子序列/子字符串

**注意：**

- **Subsequence 是可以不连续的子串**
- **Substring(Subarray)必须是连续的子串**

  > 假设有 S1 = “abcdeffg” S2 = "abcfg"
  > 子串：“abc”
  > 子序列：“abcfg”

1. Longest Common Substring/Subarray，最长公共子串

   - [718. Maximum Length of Repeated Subarray](https://leetcode.com/problems/maximum-length-of-repeated-subarray/):
     [java](/solution_java/0718_Maximum_Length_of_Repeated_Subarray.java)

2. Longest Common Subsequence，最长公共子序列

   - [1143. Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/):
     [java](/solution_java/1143_Longest_Common_Subsequence.java)

3. Longest Increasing Subsequence，最长上升子序列

   - [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/):
     [java](/solution_java/0300_Longest_Increasing_Subsequence.java)
   - [673. Number of Longest Increasing Subsequence](https://leetcode.com/problems/number-of-longest-increasing-subsequence/):
     [java](/solution_java/0673_Number_of_Longest_Increasing_Subsequence.java)
   - [674. Longest Continuous Increasing Subsequence](https://leetcode.com/problems/longest-continuous-increasing-subsequence/):
     [java](/solution_java/0674_Longest_Continuous_Increasing_Subsequence.java)
   - [368. Largest Divisible Subset](https://leetcode.com/problems/largest-divisible-subset/):
     [java](/solution_java/0368_Largest_Divisible_Subset.java)

### 参考：

https://blog.csdn.net/richenyunqi/article/details/105699183
