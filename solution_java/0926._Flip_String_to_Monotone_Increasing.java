题目大意

解题思路

//法1
class Solution {
    public int minFlipsMonoIncr(String s) {
        //算法就是第一个1出现之后，计算0出现的次数
        //当前出现的第一个1后的0的个数<当前出现的1的个数:
        //直接把0变成1就是min nums of flip, return flipCount
        //当前出现的1的个数<当前出现的第一个1后的0的个数，覆盖要flip的zero的数量=countOnes:
        // flipCount = countOnes;
        
        int countOnes = 0, flipCount = 0;
        
        for(char c : s.toCharArray()){
            if(c=='0'){
                if(countOnes==0) continue;
                flipCount++;
            }
            else{
                countOnes++;
            }
            
            if(flipCount > countOnes){
                flipCount = countOnes;
            }
        }
        
        return flipCount;
    }
}

//dp
public int minFlipsMonoIncr(String s) {
    int n = s.length(), res = n;
    int[] oneBefore = new int[n], zeroAfter = new int[n];
        
    oneBefore[0] = s.charAt(0) == '1' ? 1 : 0;
    zeroAfter[n - 1] = s.charAt(n - 1) == '1' ? 0 : 1;
        
    for(int i = 1; i < n; i++)
        oneBefore[i] = oneBefore[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
        
    for(int i = n - 2; i >= 0; i--)
        zeroAfter[i] = zeroAfter[i + 1] + (s.charAt(i) == '1' ? 0 : 1);
        
    for(int i = 0; i < n; i++)
        res = Math.min(res, oneBefore[i] + zeroAfter[i]);

    return res - 1;
}