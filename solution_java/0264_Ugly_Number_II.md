# 264. Ugly Number II

https://leetcode.com/problems/ugly-number-ii/description/

## Solution

```java
class Solution {
    public int nthUglyNumber(int n) {
        //Sieve of Eratosthenes
        //think multiples of 2, 3 and 5 as a linked list
        //our goal is to merge these 3 linked list and find the Nth node of the final linked list
        //So we first need to build the 3 linked list

        //think p2, p3 and p5 as the next pointer for these 3 linked list
        //product1, product2 and product5 as the value of the current node (head value at first)
        // 可以理解为三个指向有序链表头结点的指针
        int p2 = 1, p3 = 1, p5 = 1;
        // 可以理解为三个有序链表的头节点的值
        int product2 = 1, product3 = 1, product5 = 1;

        //Think it as the final linked list
        // 可以理解为最终合并的有序链表（结果链表）
        int[] ugly = new int[n+1];
        // 可以理解为结果链表上的指针
        int p = 1;

        //loop until we reach the end of the final linked list
        // 开始合并三个有序链表，找到第 n 个丑数时结束
        while(p <= n) {
            // 取三个链表的最小结点
            int min = minimumOfThree(product2, product3, product5);
            //将最小节点接到结果链表上
            ugly[p] = min;
            p++;

            // 前进对应有序链表上的指针
            if(min == product2) {
                product2 = 2 * ugly[p2];
                p2++;
            }
            if(min == product3) {
                product3 = 3 * ugly[p3];
                p3++;
            }
            if(min == product5) {
                product5 = 5 * ugly[p5];
                p5++;
            }
        }

        // 返回第 n 个丑数
        return ugly[n];
    }

    int minimumOfThree(int num1, int num2, int num3) {
        return Math.min(Math.min(num1, num2), num3);
    }
}
```
