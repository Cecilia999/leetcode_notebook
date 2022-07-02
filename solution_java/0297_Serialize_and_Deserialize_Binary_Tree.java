// 题目大意 #
// 设计一个算法，来序列化和反序列化二叉树。并不限制如何进行序列化和反序列化，
// 但是你需要保证二叉树可以序列化为字符串，并且这个字符串可以被反序列化成原有的二叉树。

// 解题思路 #
// 将给定的二叉树想象成一颗满二叉树(不存在的结点用 null 填充)。
// 通过前序遍历，可以得到一个第一个结点为根的序列，然后递归进行序列化/反序列化即可。

//serialize: 用stringbuilder,根据preorder traversal append node+spliter到sb

//deserialize：用deque，根据preorder traversal，用spliter分开string组成deque，然后创建treenode 连接成二叉树

//思路就是要可以encode the binary tree in to a string, 然后decode it back to a binary tree
//需要两个特殊的letter来区分不同的node以及空node

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String spliter = ",";
    String emptyNode = "#";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    public void buildString(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append(emptyNode);
            sb.append(spliter);
        }
        else{
            sb.append(String.valueOf(root.val));
            sb.append(spliter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        List<String> valueList = Arrays.asList(values);
        
        //we want to get rid of the values that we already create a node for it when we building the tree, so we need a new datastructure other than a string array to recursively deserukauze our tree
        //we need to build the tree in pre-order, which means we need to remove the value from the top of the array
        //so we are using deque here
        //to conver an array to deque, we first need to convert it to arraylist and then use the addAll() method to append the arraylist to deque
        
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(valueList);
        
        return buildTree(nodes);
    }
    
    public TreeNode buildTree(Deque<String> nodes){
        String node = nodes.pollFirst();
        if(node.equals(emptyNode)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(node));
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);
        return root;     
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));