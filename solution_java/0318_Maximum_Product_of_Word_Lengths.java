// 在字符串数组中找到 2 个没有公共字符的字符串，并且这两个字符串的长度乘积要是最大的，求这个最大的乘积。

// 这里需要利用位运算 & 运算的性质，如果 X & Y = 0，说明 X 和 Y 完全不相同。那么我们将字符串都编码成二进制数，进行 & 运算即可分出没有公共字符的字符串，最后动态维护长度乘积最大值即可。将字符串编码成二进制数的规则比较简单，每个字符相对于 ‘a’ 的距离，根据这个距离将 1 左移多少位。
// 
//     a 1->1  
//     b 2->10  
//     c 4->100  
//     ab 3->11  
//     ac 5->101  
//     abc 7->111  
//     az 33554433->10000000000000000000000001  

class Solution {
    public int maxProduct(String[] words) {
        if(words.length==0) return 0;
        
        int[] bitWords = new int[words.length];
        
        for(int i=0; i<words.length; i++){
            bitWords[i]  = convertStringToBits(words[i]);
        }
        
        int max = 0;
        for(int i=0; i<bitWords.length; i++){
            for(int j=i+1; j<bitWords.length; j++){
                if ( (bitWords[i] & bitWords[j]) == 0 ){
                    max = Math.max(max, words[i].length()*words[j].length());
                }
            }
        }
        
        return max;
    }
    
    public int convertStringToBits(String s){
        int res = 0;
        for(char c : s.toCharArray()){
            // |=相当于bit manipulation里的+
            res |= 1 << (c-'a');
        }
        
        return res;
    }
}