# greedy

贪心算法（又称贪婪算法）是指，在对问题求解时，总是做出在当前看来是最好的选择。也就是说，不从整体最优上加以考虑，他所做出的仅是在某种意义上的局部最优解。贪心算法不是对所有问题都能得到整体最优解，但对范围相当广泛的许多问题他能产生整体最优解或者是整体最优解的近似解。

1. 「贪心算法」 和 「动态规划」、「回溯搜索」 算法一样，完成一件事情，是 **分步决策** 的；
2. 「贪心算法」 在每一步总是做出在当前看来最好的选择，我是这样理解 「最好」 这两个字的意思：
   - 「最好」 的意思往往根据题目而来，可能是 「最小」，也可能是 「最大」；
   - 贪心算法和动态规划相比，它既不看前面（也就是说它不需要从前面的状态转移过来），也不看后面（无后效性，后面的选择不会对前面的选择有影响），因此贪心算法时间复杂度一般是线性的，空间复杂度是常数级别的；

- [455. Assign Cookies](https://leetcode.com/problems/assign-cookies/):
  [java](/solution_java/0455_Assign_Cookies.java)
- [135. Candy](https://leetcode.com/problems/candy/):
  [java](/solution_java/0135_Candy.java)
- [763. Partition Labels](https://leetcode.com/problems/partition-labels/):
  [java](/solution_java/0763_Partition_Labels.java)
- [134. Gas Station](https://leetcode.com/problems/gas-station/):
  [java](/solution_java/0134_Gas_Station.java)
- [122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/):
  [java](/solution_java/0122_Best_Time_to_Buy_and_Sell_Stock_II.java)
- [646. Maximum Length of Pair Chain](https://leetcode.com/problems/maximum-length-of-pair-chain/):
  [java](/solution_java/0646_Maximum_Length_of_Pair_Chain.md)

## 1. greedy + monotonic stack (贪心 + 单调栈)

- [402. Remove K Digits](https://leetcode.com/problems/remove-k-digits/):
  [java](/solution_java/0402_Remove_K_Digits.java)
- [316. Remove Duplicate Letters](https://leetcode.com/problems/remove-duplicate-letters/):
  [java](/solution_java/0316_Remove_Duplicate_Letters.java)

## 2. greedy + arrays.sort

- [1710. Maximum Units on a Truck](https://leetcode.com/problems/maximum-units-on-a-truck/) :
  [java](/solution_java/1710_Maximum_Units_on_a_Truck.md)

## 3. greedy + priority queue + sort

- [1353. Maximum Number of Events That Can Be Attended](https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/):
  [java](/solution_java/1353_Maximum_Number_of_Events_That_Can_Be_Attended.md)
