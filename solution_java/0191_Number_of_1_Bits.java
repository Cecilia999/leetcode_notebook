//思路：
//首先java没有unsigned integer，只有signer integer
//An Integer in Java has 32 bits, e.g. 00101000011110010100001000011010.

//To count the 1s in the Integer representation we put the input int
//n in bit AND with 1 (that is represented as
//00000000000000000000000000000001, and if this operation result is 1,
//that means that the last bit of the input integer is 1. Thus we add it to the 1s count.

//We need to use bit shifting unsigned operation >>> (while >> depends on sign extension)
// In Java we need to put attention on the fact that the maximum integer is 2147483647. Integer type in Java is signed and there is no unsigned int. So the input 2147483648 is represented in Java as -2147483648 (in java int type has a cyclic representation, that means Integer.MAX_VALUE+1==Integer.MIN_VALUE).
// This force us to use

// n!=0

// in the while condition and we cannot use

// n>0

// because the input 2147483648 would correspond to -2147483648 in java and the code would not enter the while if the condition is n>0 for n=2147483648.



public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        
        //We keep doing this until the input Integer is 0.
        while(n!=0){
            count = count + (n&1);
            n=n>>>1;
        }
        
        return count;
    }
}