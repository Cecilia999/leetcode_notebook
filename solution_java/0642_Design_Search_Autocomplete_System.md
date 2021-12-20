# 642. Design Search Autocomplete System

## problem

Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#').

You are given a string array sentences and an integer array times both of length n where sentences[i] is a previously typed sentence and times[i] is the corresponding number of times the sentence was typed. For each input character except '#', return the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed.

Here are the specific rules:

- The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
- The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same hot degree, use ASCII-code order (smaller one appears first).
- If less than 3 hot sentences exist, return as many as you can.
- When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
  Implement the AutocompleteSystem class:

- `AutocompleteSystem(String[] sentences, int[] times)` Initializes the object with the sentences and times arrays.
- `List<String> input(char c)` This indicates that the user typed the character c.
  - Returns an empty array [] if c == '#' and stores the inputted sentence in the system.
  - Returns the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed. If there are fewer than 3 matches, return them all.

Example 1:

Input
["AutocompleteSystem", "input", "input", "input", "input"]
[[["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]], ["i"], [" "], ["a"], ["#"]]

Output
[null, ["i love you", "island", "i love leetcode"], ["i love you", "i love leetcode"], [], []]

Constraints:

- n == sentences.length
- n == times.length
- 1 <= n <= 100
- 1 <= sentences[i].length <= 100
- 1 <= times[i] <= 50
- c is a lowercase English letter, a hash '#', or space ' '.
- Each tested sentence will be a sequence of characters c that end with the character '#'.
- Each tested sentence will have a length in the range [1, 200].
- The words in each input sentence are separated by single spaces.
- At most 5000 calls will be made to input.

## solution

Trie + PriorityQueue

## code

```java
class AutocompleteSystem {
    class TrieNode{
        Map<Character, TrieNode> children;
        //当前这个prefix 所有的sentence的times count
        Map<String, Integer> sentenceCount;
        boolean isSentence;

        public TrieNode(){
            children = new HashMap<>();
            sentenceCount = new HashMap<>();
            isSentence = false;
        }

    }

    TrieNode root = new TrieNode();
    String prefix = "";

    public AutocompleteSystem(String[] sentences, int[] times) {
        for(int i=0; i<sentences.length; i++){
            add(sentences[i], times[i]);
        }
    }

    public void add(String sentence, int count){
        TrieNode cur = root;

        for(char c : sentence.toCharArray()){
            TrieNode next = cur.children.get(c);
            if(next==null){
                next = new TrieNode();
                cur.children.put(c, next);
            }

            cur = next;
            //沿着sentence里的每一个字母都要放
            cur.sentenceCount.put(sentence, cur.sentenceCount.getOrDefault(sentence, 0)+count);
        }
        cur.isSentence = true;
    }

    public List<String> input(char c) {
        if(c=='#'){
            add(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }

        //先把当前input的c append到String prefix里
        //然后loop整个TrieNode tree
        prefix = prefix + c;
        TrieNode cur = root;
        for(char ch : prefix.toCharArray()){
            TrieNode next = cur.children.get(ch);
            if(next==null)
                return new ArrayList<>();
            cur = next;
        }

        //cur找到了TrieNode之后用priorityqueue sort sentences
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((e1, e2)->{
            if(e1.getValue()==e2.getValue()){
                return e1.getKey().compareTo(e2.getKey());
            }
            return e2.getValue() - e1.getValue();
        });
        pq.addAll(cur.sentenceCount.entrySet());

        List<String> res = new ArrayList<>();
        int k=3;
        while(!pq.isEmpty() && k>0){
            res.add(pq.poll().getKey());
            k--;
        }

        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
```
