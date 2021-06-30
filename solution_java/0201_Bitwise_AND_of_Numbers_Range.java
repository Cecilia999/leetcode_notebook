// 这一题要求输出 [m,n] 区间内所有数的 AND 与操作之后的结果。

// 举个例子，假设区间是 [26,30]，那么这个区间内的数用二进制表示出来为：

// 11010
// 11011
// 11100
// 11101
// 11110

// 可以观察到，把这些数都 AND 起来，只要有 0 的位，最终结果都是 0，所以需要从右往前找到某一位上不为 0 的。不断的右移左边界和右边界，把右边的 0 都移走，直到它们俩相等，就找到了某一位上开始都不为 0 的了。在右移的过程中记录下右移了多少位，最后把 m 或者 n 的右边添上 0 即可。按照上面这个例子来看，11000 是最终的结果。

// 这一题还有解法二，还是以 [26,30] 这个区间为例。这个区间内的数末尾 3 位不断的 0，1 变化着。那么如果把末尾的 1 都打掉，就是最终要求的结果了。当 n == m 或者 n < m 的时候就退出循环，说明后面不同的位数已经都被抹平了，1 都被打掉为 0 了。所以关键的操作为 n &= (n - 1) ，清除最低位的 1 。这个算法名叫 Brian Kernighan 算法。

//解法1
// class Solution {
//     public int rangeBitwiseAnd(int left, int right) {
//         if(right==0) return 0;
//         int moved = 0;
        
//         while(left!=right){
//             left>>=1;
//             right>>=1;
//             moved++;
//         }
        
//         return left<<moved;
//     }
// }

//解法2
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while(left<right){
            right &= (right-1);
        }
        
        return right;
    }
}