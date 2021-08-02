// 题目大意
// 给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。
// 字母异位词指字母相同，但排列不同的字符串。
// 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
// 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

// 解题思路
// 把string变成char[] 然后用Array.sorts 把char[] 按照字母顺序重新排列
// 将重新排列的char[] 转化成string
// 用hash map 来map string 和 list
// 如果已经存在改string，将sort前的origin string加入list
// 如果不存在，增加一个新的key-value pair

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String str : strs){
            char[] sChar = str.toCharArray();
            Arrays.sort(sChar);
            String key = String.valueOf(sChar);
            
            //check if s is already exist as a key of map
            if(!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        
        return new ArrayList(map.values());
    }
}