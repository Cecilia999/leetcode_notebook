# [146. LRU Cache (Least Rencently Used Cache)](https://leetcode.com/problems/lru-cache/)

## 题目大意

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

- LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
- int get(int key) Return the value of the key if the key exists, otherwise return -1.
- void put(int key, int value) Update the value of the key if the key exists. Otherwise, add - e key-value pair to the cache. If the number of keys exceeds the capacity from this - eration, evict the least recently used key.
- The functions get and put must each run in O(1) average time complexity.

## 解题思路

### 一、什么是 LRU 算法

就是一种缓存淘汰策略。

计算机的缓存容量有限，如果缓存满了就要删除一些内容，给新内容腾位置。但问题是，删除哪些内容呢？我们肯定希望删掉哪些没什么用的缓存，而把有用的数据继续留在缓存里，方便之后继续使用。那么，什么样的数据，我们判定为「有用的」的数据呢？

LRU 缓存淘汰算法就是一种常用策略。LRU 的全称是 Least Recently Used，也就是说我们认为最近使用过的数据应该是是「有用的」，很久都没用过的数据应该是无用的，内存满了就优先删那些很久没用过的数据。

举个简单的例子，安卓手机都可以把软件放到后台运行，比如我先后打开了「设置」「手机管家」「日历」，那么现在他们在后台排列的顺序是这样的：

「设置」->「手机管家」->「日历」, 日历在最上面

但是这时候如果我访问了一下「设置」界面，那么「设置」就会被提前到第一个，变成这样：

「手机管家」->「日历」-> 「设置」

### 二、LRU 算法描述

LRU 算法实际上是让你设计数据结构：首先要接收一个 capacity 参数作为缓存的最大容量，然后实现两个 API，一个是 put(key, val) 方法存入键值对，另一个是 get(key) 方法获取 key 对应的 val，如果 key 不存在则返回 -1。

注意哦，get 和 put 方法必须都是 O(1) 的时间复杂度

### 三、LRU 算法设计

首先，我们把双链表的节点类写出来，为了简化，key 和 val 都认为是 int 类型：

```java
class Node {
    public int key, val;
    public Node next, prev;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}
```

然后依靠我们的 Node 类型构建一个双链表，实现几个需要的 API（这些操作的时间复杂度均为 O(1))：

```java
class DoubleList {
    // 在链表头部添加节点 x，时间 O(1)
    public void addFirst(Node x);

    // 删除链表中的 x 节点（x 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(Node x);

    // 删除链表中最后一个节点，并返回该节点，时间 O(1)
    public Node removeLast();

    // 返回链表长度，时间 O(1)
    public int size();
}
```

PS：这就是普通双向链表的实现，为了让读者集中精力理解 LRU 算法的逻辑，就省略链表的具体代码。

到这里就能回答刚才“为什么必须要用双向链表”的问题了，因为我们需要删除操作。删除一个节点不光要得到该节点本身的指针，也需要操作其前驱节点的指针，而双向链表才能支持直接查找前驱，保证操作的时间复杂度 O(1)。

有了双向链表的实现，我们只需要在 LRU 算法中把它和哈希表结合起来即可。我们先把逻辑理清楚：

```java
// key 映射到 Node(key, val)
HashMap<Integer, Node> map;
// Node(k1, v1) <-> Node(k2, v2)...
DoubleList cache;

int get(int key) {
    if (key 不存在) {
        return -1;
    } else {
        将数据 (key, val) 提到开头；
        return val;
    }
}

void put(int key, int val) {
    Node x = new Node(key, val);
    if (key 已存在) {
        把旧的数据删除；
        将新节点 x 插入到开头；
    } else {
        if (cache 已满) {
            删除链表的最后一个数据腾位置；
            删除 map 中映射到该数据的键；
        }
        将新节点 x 插入到开头；
        map 中新建 key 对新节点 x 的映射；
    }
}
```

### 四、我的代码

```java
class LRUCache {
    //首先我们需要定义Node和DoubleList类
    //这里吧doublelist直接省略变成方法写在LRUCache类里面
    class Node{
        int key;
        int value;
        Node pre, next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    // key 映射到 Node(key, val)
    private HashMap<Integer, Node> map;
    private int size;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        //如果map里没有直接返回-1
        if(!map.containsKey(key)) return -1;

        //如果有，要把这个node放到doublelist的顶端
        //且删掉溢出的部分accordingly
        Node node = map.get(key);
        put(key, node.value);
        return node.value;
    }

    public void put(int key, int value) {
        //如果map中已经存在这个key
        //先从doublelist里删掉这个node
        //再从map里删掉
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            map.remove(key);
        }

        //如果size已经满了
        //删掉尾端的node
        //从map里也删掉
        if(size==capacity){
            Node lastNode = removeLast();
            map.remove(lastNode.key);
        }

        Node temp = new Node(key, value);
        addFirst(temp);
        map.put(key, temp);
    }

    private void addFirst(Node node){
        if(head == null){
            head = node;
            tail = node;
        }
        else{
            Node temp = head;
            temp.pre = node;
            node.next = temp;
            head = node;
        }
        size++;
    }

    private void remove(Node node){
        //需要处理head 和 tail
        if(head==node && tail==node){ //doublelist只剩下一个node
            head = null;
            tail = null;
        }
        else if(head!=node && tail==node){ //node is tail
            tail = node.pre;
            node.pre.next = null;
        }
        else if(head==node && tail!=node){ //node is tail
            head = node.next;
            node.next.pre = null;
        }
        else{
            Node preNode = node.pre;
            Node nextNode = node.next;
            node.pre.next = nextNode;
            nextNode.pre = preNode;
        }
        size--;
    }

    private Node removeLast(){
        Node res = tail;
        remove(tail);
        return res;
    }

}
```

**doublelist node + doublelist template**

```java
class LRUCache {
    class Node{
        int key, value;
        Node pre, next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    class DoubleList{
        private int size;
        private Node head, tail;
        public DoubleList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        public void addFirst(Node node){
            node.next = head.next;
            node.pre = head;

            node.next.pre = node;
            node.pre.next = node;
            size++;
        }

        public Node removeLast(){
            Node lastNode = tail.pre;
            remove(lastNode);
            return lastNode;
        }

        public void remove(Node node){
            Node nextNode = node.next;
            Node preNode = node.pre;
            preNode.next = nextNode;
            nextNode.pre = preNode;
            size--;
        }
    }

    Map<Integer, Node> map;
    int capacity;
    DoubleList list;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        list = new DoubleList();
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        put(node.key, node.value);
        return map.get(key).value;
    }

    public void put(int key, int value) {
        //如果map里已经有key，应该update
        if(map.containsKey(key)){
            Node oldNode = map.get(key);
            list.remove(oldNode);
            map.remove(key);
        }

        //if size==capacity, remove the least used node first
        if(list.size==capacity){
            Node lastNode = list.removeLast();
            map.remove(lastNode.key);
        }

        Node node = new Node(key, value);
        list.addFirst(node);
        map.put(key, node);
    }
}
```
