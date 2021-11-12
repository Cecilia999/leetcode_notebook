# 460. LFU Cache

## 题目大意

Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.

1. int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
2. void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
3. To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

4. When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.

## 解题思路

1. 和 LRU(Least Recently Used) Cache 一样，use Node and DoubleList
2. use two hashmap:
   1. nodeMap: <Key, Node>
   2. freqMap: <freq, frequencyList> - frequency list is a DoubleList

## code

```java
class LFUCache {
    class Node{
        private int key, value, freq;
        private Node pre, next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoubleList{
        private Node head, tail;
        private int size;
        public DoubleList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        public void addFirst(Node node){
            Node oldNode = head.next;
            //break two connections, create four connections
            node.next = oldNode;
            oldNode.pre = node;
            node.pre = head;
            head.next = node;
            size++;
        }

        public Node removeLast(){
            if(size>0){
                Node node = tail.pre;
                remove(node);
                return node;
            }
            return null;
        }

        public void remove(Node node){
            Node preNode = node.pre;
            Node nextNode = node.next;
            preNode.next = nextNode;
            nextNode.pre = preNode;
            size--;
        }
    }

    private int capacity, size, min;
    //key, valueNode
    private HashMap<Integer, Node> nodeMap;
    //key, freqList
    private HashMap<Integer, DoubleList> freqMap; //存各个frequency的node

    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if(node==null) return -1;
        update(node); //update freq and recent cache
        return node.value;
    }

    public void update(Node node){
        DoubleList oldList = freqMap.get(node.freq);
        //要从当前这个oldL freq list remove input node
        oldList.remove(node);
        //need to check if the minimum frequency need to uapdte
        if(node.freq==min && oldList.size==0)
            min++;

        //increase freq of current node
        node.freq++;
        // get the new freq list and add the node to the list;
        // put the <freq, newlist> pair back to the freqMap
        DoubleList newList = freqMap.getOrDefault(node.freq, new DoubleList());
        newList.addFirst(node);
        freqMap.put(node.freq, newList);
    }

    public void put(int key, int value) {
        //1. check capacity
        //2. if node is already exist, no need to check capacity, just update the node.value & node.freq
        //3. else,
        //   1) remove least freq / least recently used node first,
        //   2) put the new node into nodeMap & freqMap

        if(capacity==0) return;

        Node node;
        //if nodeMap contains key, update nodeMap and update freqMap
        if(nodeMap.containsKey(key)){
            node = nodeMap.get(key);
            node.value = value;
            update(node);
        }
        else{
            node = new Node(key, value);

            //remove the least frequency and least recently used node
            //which is at the end of the freq list
            if(size==capacity){
                DoubleList leastFreq = freqMap.get(min);
                nodeMap.remove(leastFreq.removeLast().key); //HashMap.remove(key)
                size--;
            }

            nodeMap.put(key, node);
            size++;
            min = 1;
            DoubleList newList = freqMap.getOrDefault(node.freq, new DoubleList());
            newList.addFirst(node);
            freqMap.put(node.freq, newList);
        }
    }
}
```
