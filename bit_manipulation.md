# bit manipulation

### bitwise & bit shift operators

1. bitwise operators

   - The bitwise **&** operator performs a bitwise **AND** operation.  
     a 和 b 都是 1，返回 1，否则返回 0

   - The bitwise **^** operator performs a bitwise **exclusive OR** operation (also called XOR).  
     只有 a 和 b 不同，返回 1，否则返回 0

   - The bitwise **|** operator performs a bitwise **inclusive OR** operation.  
     a 和 b 有一个是 1，返回 1，全都是 0 才返回 0

   ![Alt text](/images/inclusiveOR_exclusiveOR.jpg)

2. bit shift operators

   - The unary bitwise complement operator **~** inverts a bit pattern; it can be applied to any of the integral types, making every "0" a "1" and every "1" a "0".

     > For example, a byte contains 8 bits; applying this operator to a value whose bit pattern is "00000000" would change its pattern to "11111111".

   - signed left shift **(<<)**
     - 把 bit 向左移并且在后面补 0
     - Non-circular shifting. 但 java 的 int type 是 circular 的 -->> Integer.MAX_VALUE+1==Integer.MIN_VALUE
   - Arithmetic right shift (>>)
     - 也叫 signed right shift，开头是 1.
     - The bit pattern is given by the left-hand operand, and the number of positions to shift by the right-hand operand.
   - Logical right shift **(>>>)**
     - 也叫 unsigned right shift，开头是 0
     - shifts a zero into the leftmost position, while the leftmost position after **>>** depends on sign extension.

**参考：**

- https://stackoverflow.com/questions/141525/what-are-bitwise-shift-bit-shift-operators-and-how-do-they-work
- https://leetcode.com/problems/single-number-ii/discuss/43295/Detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers
- https://books.halfrost.com/leetcode/ChapterTwo/Bit_Manipulation/

### 常用总结

1. n & (n-1): removes the last non-zero bit from our number 将最低位(LSB)的 1 清零

   example:
   1.n = 100000, then n - 1 = 011111 and n & (n-1) = 000000
   2.n = 101110, then n - 1 = 101101 and n & (n-1) = 101100

2. n & = -n 得到最低位(LSB)的 1

   - [260. Single Number III](https://leetcode.com/problems/single-number-iii/):
     [java](/solution_java/0260_Single_Number_III.java)

3. n & 1: check the last bit is 1 or not
   n & 1 == 1 判断是否是奇数(偶数)用来判断奇偶，奇数的 last bit 必须是 1，反之偶数的 last bit 必须是 0

   example:
   1.n = 101110, then 1 = 000001 and n & 1 = 000000
   2.n = 101111, then 1 = 000001 and n & 1 = 000001

4. XOR ^ 异或的特性

   - x ^ 0 = x  
     x ^ x = 0
   - XOR is commutative 符合交换律，顺序不重要  
     a ^ b = b ^ a  
     a ^ b = c => a ^ c = b => b ^ c = a (交换律)

   - x ^ 11111……1111 = ~x  
     x ^ (~x) = 11111……1111

   - XOR 符合结合律  
     a ^ b ^ c = a ^ (b ^ c) = (a ^ b）^ c (结合律)

   ```
    a ^ b ^ a = a ^ a ^ b ------- (交换律)
    = (a ^ a) ^ b         ------- (结合律)
    = 0 ^ b               ------- (x ^ x = 0)
    = b                   ------- (x ^ 0 = x )
   ```

   - [136. Single Number](https://leetcode.com/problems/single-number/):
     [java](/solution_java/0136_Single_Number.java)
   - [268. Missing Number](https://leetcode.com/problems/missing-number/):
     [java](/solution_java/0268_Missing_Number.java)
   - [389. Find the Difference](https://leetcode.com/problems/find-the-difference/):
     [java](/solution_java/0389_Find_the_Difference.java)

### lc

- [191. Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/):
  [java](/solution_java/0191_Number_of_1_Bits.java)
- [231. Power of Two](https://leetcode.com/problems/power-of-two/):
  [java](/solution_java/0231_Power_of_Two.java)
