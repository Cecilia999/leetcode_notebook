// 题目大意
// 给一个s和一个wordDict, 求出所有wordDict中能组成s的组合
// Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
// Output: ["cats and dog","cat sand dog"]

//解题思路：dfs + dp判断can break or not(memory search)

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        
        boolean[] dp = new boolean[s.length()];
        Arrays.fill(dp, true);
        
        StringBuilder sb = new StringBuilder();
        dfs(res, s, sb, 0, wordDict, dp);
        return res;
    }
    
    public void dfs(List<String> res, String s, StringBuilder sb, int start, List<String> dict, boolean[] dp){
        if(start==s.length()){
            res.add(sb.toString().trim());    
            return;
        }    
        
        //if dp[start]=false, wordDict can not form s
        if(!dp[start]) return;
        
        for(int i=start+1; i<=s.length(); i++){
            String word = s.substring(start, i);
            if(!dict.contains(word)) continue;
            
            //else
            int sbBeforeAdd = sb.length();  //用来backtrack
            sb.append(" " + word);
            
            int resSizeBeforeDFS = res.size();
            dfs(res, s, sb, i, dict, dp);
            
            if(resSizeBeforeDFS==res.size()){  //说明这条路不通
                dp[i] = false;
            }
            sb.delete(sbBeforeAdd, sb.length());   //StringBuilder.delete(start, end)
        }
    }
}