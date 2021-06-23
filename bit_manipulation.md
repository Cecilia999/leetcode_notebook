# bit manipulation

### bitwise & bit shift operators

1. bitwise operators

   - The bitwise **&** operator performs a bitwise AND operation.  
     a 和 b 都是 1/0，结果是 true，否则是 false

   - The bitwise **^** operator performs a bitwise exclusive OR operation.  
     只有 a 和 b 都是 0，结果才是 false，否则都是 true

   - The bitwise **|** operator performs a bitwise inclusive OR operation.  
     只有 a 和 b 都是 1，结果才是 true，否则都是 false

   ![Alt text](/images/inclusiveOR_exclusiveOR.jpg)

2. bit shift operators

   - The unary bitwise complement operator **~** inverts a bit pattern; it can be applied to any of the integral types, making every "0" a "1" and every "1" a "0".

     > For example, a byte contains 8 bits; applying this operator to a value whose bit pattern is "00000000" would change its pattern to "11111111".

   - The signed left shift operator **<<** shifts a bit pattern to the left
   - The signed right shift operator **>>** shifts a bit pattern to the right.  
     The bit pattern is given by the left-hand operand, and the number of positions to shift by the right-hand operand.
   - The unsigned right shift operator **>>>** shifts a zero into the leftmost position, while the leftmost position after **>>** depends on sign extension.
