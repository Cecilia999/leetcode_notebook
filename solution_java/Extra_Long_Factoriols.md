# Extra_Long_Factoriols

## problems

The factorial of the integer n, written n! is defined as
n!=n×(n-1)×(n-2)x…×3×2×1

Calculate and print the factorial of a given integer

for example,if n=30 we calculate:
30×29×28×...×2×1 and get 265252859812191058636308480000000

Function Description
Complete the extra Longfactorials function in the editor below. It should print the result and return extralongfactorials has the following parameter(s)
n: an Integer

Node:
Factorials of n >20 can't be stored even in a 64-bit long variable. Big Integer must be used for such calculations. Languages like Java, Python, Ruby etc can handle big integers, but we need to write additional code in C/C++ to handle huge values

Constraints
1<n<100

## solution

`import java.math.BigInteger;`

## code

```java
public static void extraLongFactorials(int n) {
    // Write your code here
        BigInteger bi = new BigInteger("1");
        for(int i=1; i<=n; i++){
            bi = bi.multiply(BigInteger.valueOf(i));
        }

        System.out.print(bi);
    }
```
