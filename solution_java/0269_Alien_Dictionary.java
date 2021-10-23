import java.util.*;

/**
 * @Author: MingChen
 * @Date: 2021/10/22
 *
 * 现有一种使用字母的全新语言，这门语言的字母顺序与英语顺序不同。
 * 假设，您并不知道其中字母之间的先后顺序。但是，会收到词典中获得一个 不为空的 单词列表。
 * 因为是从词典中获得的，所以该单词列表内的单词已经 按这门新语言的字母顺序进行了排序。
 *
 * 您需要根据这个输入的列表，还原出此语言中已知的字母顺序。
 *
 * 示例 1：
 *
 * 输入:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 *
 * 输出: "wertf"
 * 示例 2：
 *
 * 输入:
 * [
 *   "z",
 *   "x"
 * ]
 *
 * 输出: "zx"
 * 示例 3：
 *
 * 输入:
 * [
 *   "z",
 *   "x",
 *   "z"
 * ]
 *
 * 输出: ""
 *
 * 解释: 此顺序是非法的，因此返回 ""。
 * 注意：
 *
 * 你可以默认输入的全部都是小写字母
 * 假如，a 的字母排列顺序优先于 b，那么在给定的词典当中 a 定先出现在 b 前面
 * 若给定的顺序是不合法的，则返回空字符串即可
 * 若存在多种可能的合法字母顺序，请返回其中任意一种顺序即可
 */
public class lc269_alien_dict {
    public static String alienOrder(String[] words){
        //1. 构建图
        //a->b key->value
        HashMap<Character, Set<Character>> map = new HashMap<>();
        int n = words.length;

        //相邻的两个单词进行比较，注意前一个单词的优先级>下一个单词
        for(int i=0; i<n-1; i++) {
            //细节:找出相邻两个字符串中第一个不同的字符
            for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
                char ch1 = words[i].charAt(j);
                char ch2 = words[i + 1].charAt(j);
                if (ch1 == ch2)
                    continue;

                //注意
                // map.getOrDefault(ch1, new HashSet<Character>()).add(ch2); //这么写是错的
                Set<Character> set = map.getOrDefault(ch1, new HashSet<Character>());
                set.add(ch2);
                map.put(ch1, set);
                break; //找到一个顺序就停下
            }
        }

        //2. 计算indegree
        int[] indegree = new int[26]; //一共只有26个字母
        Arrays.fill(indegree, -1);  //-1的字母没有出现过

        //把出现的character indegree=0
        for(String word : words){
            for(char c : word.toCharArray()){
                indegree[c-'a'] = 0;
            }
        }

        //important: 记录出现的不同字符的数量
        int count = 0;
        for(int i=0; i<26; i++){
            if(indegree[i]==0)
                count++;
        }

        //根据map更新字符的indegree
        for( char ch : map.keySet()){
            for( char c : map.get(ch)){
                indegree[c-'a']++;
            }
        }

        //把indegree==0的字符加入queue里
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            if(indegree[i]==0)
                queue.offer((char)('a'+i));
        }

        while(!queue.isEmpty()){
            char pre = queue.poll();
            sb.append(pre);
            count--;

            if(map.containsKey(pre)){
                for(char c : map.get(pre)){
                    indegree[c-'a']--;
                    if(indegree[c-'a']==0)
                        queue.offer(c);
                }
            }

        }

        return count==0? sb.toString():"empty";
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(alienOrder(arr));
    }
}
