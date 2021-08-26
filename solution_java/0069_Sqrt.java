// 题目大意
// 不能用built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.写出平方根

// 解题思路
// 二分法

class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        int low = 1, high = x;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if( mid <= x/mid && (mid+1) > x/(mid+1) ) //关键判断条件
                return mid;
            else if( mid > x/mid)
                high = mid-1;
            else 
                low = mid+1;
        }
        
        return low;
    }
}