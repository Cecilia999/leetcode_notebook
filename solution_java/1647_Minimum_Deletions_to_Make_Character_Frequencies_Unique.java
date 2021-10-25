// 题目大意
// 输入一个stirng s，return number of deletions needed to make no two characters have the same frequency
// exsample1
// Input: s = "aab"
// Output: 0
// Explanation: s is already good.

// exsample2
// Input: s = "aaabbbcc"
// Output: 2
// Explanation: You can delete two 'b's resulting in the good string "aaabcc".
// Another way it to delete one 'b' and one 'c' resulting in the good string 

class Solution {
    public int minDeletions(String s) {
        //只contain lowercase english letters的想到用int[] = new int[26]
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            ++freq[c-'a'];
        }
        Arrays.sort(freq);
        
        Set<Integer> used = new HashSet<>();
        int res = 0;
        
        for(int i=0; i<26; i++){
            while(freq[i]>0 && used.contains(freq[i])){
                freq[i]--;
                res++;
            }
            used.add(freq[i]);
        }
        
        return res;
    }
}