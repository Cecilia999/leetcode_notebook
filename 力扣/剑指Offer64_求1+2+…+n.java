题目大意
求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

class Solution {
    public int sumNums(int n) {
        //递归的写法是
        //判断n==1时停止递归
        // if(n==1) return 1;
        // return n + sumNums(n-1);  

        //但是题目要求不能用if判断，所以改为用&&判断
        // &&判断，只有前面判断的是正确的才会执行后面的判断
        // 后面的判断条件不重要，主要是为了实现递归计算
        int sum = n;
        boolean check = n>0 && (sum += sumNums(n-1)) > 0;
        return sum;
    }

}