// 题目
// 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
// 例如:
// 给定二叉树: [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回：
// [3,9,20,15,7]

// 解题思路：
// 题目要求的二叉树的 从上至下 打印（即按层打印），又称为二叉树的 广度优先搜索（BFS）。
// BFS 通常借助 queue队列 的先入先出特性来实现。

class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        ArrayList<Integer> list = new ArrayList<Integer>();

        while(!queue.isEmpty()){
            TreeNode tmpRoot = queue.poll();
            list.add(tmpRoot.val);
            if(tmpRoot.left!=null) queue.offer(tmpRoot.left);
            if(tmpRoot.right!=null) queue.offer(tmpRoot.right);
        }
        
        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;

    }
}