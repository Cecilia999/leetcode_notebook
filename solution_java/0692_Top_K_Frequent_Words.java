// 题目大意

// 给一非空的单词列表，返回前 k 个出现次数最多的单词。
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。

// 示例 1：
// 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
// 输出: ["i", "love"]
// 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
// 注意，按字母顺序 "i" 在 "love" 之前。
//  
// 示例 2：
// 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
// 输出: ["the", "is", "sunny", "day"]
// 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
// 出现次数依次为 4, 3, 2 和 1 次。
//  

// 注意：
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
// 输入的单词均由小写字母组成。
//  
// 解题思路
// 先用hashmap记录每个单词出现的次数
// 把单词加入priority queue，override compare function
// 先对比次数，再对比字典序

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<String>();
        
        //put words int to hashmap
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<words.length; i++){
            if(!map.containsKey(words[i]))
                map.put(words[i], 1);
            else
                map.put(words[i], map.get(words[i])+1);
        }
        
        //override compare function and creat priority queue to sort words
        //此处为 lambda 写法 
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> {
            if (map.get(s1)==(map.get(s2))) { //如果s1和s2出现的次数一样
                return s1.compareTo(s2);      //按照字典序排序
            } else {
                return map.get(s2) - map.get(s1);  //倒序，次数大的在前面
            }
        });

        // 比较器规则不使用 lambda 写法
        // PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
        //     @Override
        //     public int compare(String s1, String s2){
        //         if(map.get(s1)==map.get(s2)) //如果s1和s2出现的次数一样
        //             return s1.compareTo(s2);  //按照字典序排序
        //         else
        //             return map.get(s2)-map.get(s1);  //倒序，次数大的在前面
        //     }
        // });
        
        for(String s : map.keySet()){
            pq.offer(s);
        }
        
        while(k>0){
            res.add(pq.poll());
            k--;
        }
        
        return res;
    }
}