# 1388. Pizza With 3n Slices

## problem

There is a pizza with 3n slices of varying size, you and your friends will take slices of pizza as follows:

You will pick any pizza slice.
Your friend Alice will pick the next slice in the anti-clockwise direction of your pick.
Your friend Bob will pick the next slice in the clockwise direction of your pick.
Repeat until there are no more slices of pizzas.
Given an integer array slices that represent the sizes of the pizza slices in a clockwise direction, return the maximum possible sum of slice sizes that you can pick.

Example 1:

Input: slices = [1,2,3,4,5,6]
Output: 10
Explanation: Pick pizza slice of size 4, Alice and Bob will pick slices with size 3 and 5 respectively. Then Pick slices with size 6, finally Alice and Bob will pick slice of size 2 and 1 respectively. Total = 4 + 6.
Example 2:

Input: slices = [8,9,8,6,1,1]
Output: 16
Explanation: Pick pizza slice of size 8 in each turn. If you pick slice with size 9 your partners will pick slices of size 8.

Constraints:

3 \* n == slices.length
1 <= slices.length <= 500
1 <= slices[i] <= 1000

## solution

题目意思是：
给定一个 array of pizza slice size，你选一块，alice 沿着你选的逆时针选一块，bob 沿着你选的逆时针选一块
你如何选择可以得到最大的 size of pizza slice

这道题其实就是 house robber 2：

1. 因为 pizza 是 circular 的，第 0 个和第 m-1 个不能同时选择
2. 一共有 m 个 pizza slice 的话那么你最多只能 pick m/3 slice
