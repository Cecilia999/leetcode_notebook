# 428. Serialize and Deserialize N-ary Tree

## PD

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following 3-ary tree

[!alt text](../images/narytreeexample.png)

as [1 [3[5 6] 2 4]]. Note that this is just an example, you do not necessarily need to follow this format.

Or you can follow LeetCode's level order traversal serialization format, where each group of children is separated by the null value.

[!alt text](../images/narytreeexample2.png)

For example, the above tree may be serialized as [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14].

You do not necessarily need to follow the above-suggested formats, there are many more different formats that work so please be creative and come up with different approaches yourself.

Example 1:

Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Example 2:

Input: root = [1,null,3,2,4,null,5,6]
Output: [1,null,3,2,4,null,5,6]
Example 3:

Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The height of the n-ary tree is less than or equal to 1000
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.

## Solution

This question is an enhance ver of [297. Seralize and Deserlalize Binary Tree](./0297_Serialize_and_Deserialize_Binary_Tree.java). The different solution is to calculate children size and append to single string and then loop the children size to buildString when Serialize. Inversely, when deserialize, deque the childrenSize and loop to build children.

## code

```java
//serialize and deserualuze n-ary tree vs binary ary tree is basically the same except for for n-ary tree you need to calculate child size, append the size to the single string and loop childNode

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    String emptyNode = "#";
    String spliter = ",";
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    public void buildString(Node root, StringBuilder sb){
        if(root==null) {
            sb.append(emptyNode).append(spliter);
            return;
        }

        sb.append(root.val).append(spliter);
        int childSize = root.children==null? 0 : root.children.size();
        sb.append(childSize).append(spliter);
        for(Node node : root.children){
            buildString(node, sb);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] splitData = data.split(",");
        List<String> splitList = Arrays.asList(splitData);
        Deque<String> nodes = new LinkedList<>(splitList);
        return buildTree(nodes);
    }

    public Node buildTree(Deque<String> nodes){
        String cur = nodes.removeFirst();
        if(cur.equals(emptyNode)) return null;

        int rootVal = Integer.valueOf(cur);
        int childSize = Integer.valueOf(nodes.removeFirst());
        Node root = new Node(rootVal);
        root.children = new ArrayList<>();
        for(int i=0; i<childSize; i++){
            root.children.add(buildTree(nodes));
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
```
