# 1268. Search Suggestions System

## problem description

Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return list of lists of the suggested products after each character of searchWord is typed.

Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]

Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]

Example 3:

Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]

Example 4:

Input: products = ["havana"], searchWord = "tatiana"
Output: [[],[],[],[],[],[],[]]

Constraints:

1 <= products.length <= 1000
There are no repeated elements in products.
1 <= Σ products[i].length <= 2 \* 10^4
All characters of products[i] are lower-case English letters.
1 <= searchWord.length <= 1000
All characters of searchWord are lower-case English letters.

## solution

trie

## code

```java
class Solution {
    class TrieNode{
        private TrieNode[] children = new TrieNode[26];
        private LinkedList<String> list = new LinkedList<>();
        public TrieNode(){}
    }

    class Trie{
        private TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            TrieNode cur = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(cur.children[c-'a']==null){
                    cur.children[c-'a'] = new TrieNode();
                }
                cur = cur.children[c-'a'];

                cur.list.offer(word);
                //check if list.size()>3 & sort in lexicographical order
                Collections.sort(cur.list);
                if(cur.list.size()>3){
                    cur.list.pollLast();
                }
            }
        }

        public List<List<String>> search(String searchWord){
            List<List<String>> res = new ArrayList<>();
            TrieNode cur = root;
            for(char c : searchWord.toCharArray()){
                //错的逻辑！！！！！！！
                // if(cur.children[c-'a']!=null){
                //     res.add(cur.children[c-'a'].list);
                //     cur = cur.children[c-'a'];
                // }
                // else{
                //     res.add(new ArrayList<>());
                // }

                //correct ver！！！！！！！！！！！
                if(cur!=null){
                    cur = cur.children[c-'a'];
                }
                res.add(cur==null? new ArrayList<>() : cur.list);
            }

            return res;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie myTrie = new Trie();
        for(String product : products){
            myTrie.insert(product);
        }

        return myTrie.search(searchWord);
    }
}
```
