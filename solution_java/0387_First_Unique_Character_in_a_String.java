//思路：一共只有26个字母所以用 char c-‘a'的方式转化为int
//用一个int array去存每个字母出现的次数

class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        
        for( char c : s.toCharArray()){
            map[c-'a']++;
        }
        for(int i=0; i<s.length(); i++){
            if(map[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
    }
}
