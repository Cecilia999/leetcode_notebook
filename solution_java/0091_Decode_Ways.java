//dp[n]
//不需要hashmap把mapping存起来
//如果i位置的数字可以翻译 dp[i]+=dp[i-1]
//如果i，i-1的数字合起来可以翻译 dp[i]+=dp[i-2];
//如果i位置的数字为0的话，dp[i]=0 数组会自动assign值为0，所以不用做任何操作直接跳过即可;

//string和int有关的题目都可以通过 s.charAt(i)-'0' 来转化成int array

class Solution {
    public int numDecodings(String s) {
        int len=s.length();
        int[] dp = new int[len+1];
        
        //dp[0], dp[1]的处理！
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'? 0:1;
        
        for(int i=2; i<=len; i++){
            int num1=s.charAt(i-1)-'0';
            int num2=(s.charAt(i-2)-'0')*10+num1;
            if(1<=num1 && num1<=9)    dp[i]+=dp[i-1];
            if(10<=num2 && num2<=26)  dp[i]+=dp[i-2]; //dp[0]是用来处理这里的edge case
        }
        
        return dp[len];
    }
}