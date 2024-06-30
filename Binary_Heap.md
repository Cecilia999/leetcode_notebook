# Binary Heap Fundamental

1. https://labuladong.online/algo/data-structure-basic/binary-heap-basic/

2. https://labuladong.online/algo/data-structure-basic/binary-heap-implement/

## binary heap代码实现

binary heap的核心feature

1. swim
2. sink

### 1. 简单版 priority queue

1. 不支持泛型，仅支持存储整数类型的元素。
2. 不考虑扩容的问题，队列的容量在创建时固定，假设插入的元素数量不会超过这个容量。
3. 底层仅实现一个小顶堆（即根节点是整个堆中的最小值），不支持自定义Comparator。

实现binary heap的数据结构 - Array

Reason

1. Linked List Node need extra space to store next/previous's node position
2. Using treeNode to implement binary heap, push/pop operation will consume O(N) time complexity - put the node to the rightmost element at the lowest level of the binary tree. 而用数组找到右下（即队尾）的速度是O(1)
3. 想要用数组模拟二叉树，前提是这个二叉树必须是完全二叉树。

