// 描述
// 操作给定的二叉树，将其变换为源二叉树的镜像。
// 比如：    源二叉树 
//             8
//            /  \
//           6   10
//          / \  / \
//         5  7 9 11
//         镜像二叉树
//             8
//            /  \
//           10   6
//          / \  / \
//         11 9 7  5


// 解题思路
// 交换两个node，会连带这交换这个node下面的整个subtree
// 所以对每个subroot判断左右是否都存在，存在就交换就行

public TreeNode Mirror (TreeNode pRoot) {
    if(pRoot==null)
        return pRoot;
    if(pRoot.left==null && pRoot.right==null){
        return pRoot;
    }
    TreeNode temp = pRoot.left;     //!
    pRoot.left = pRoot.right;
    pRoot.right = temp;
    
    Mirror(pRoot.left);
    Mirror(pRoot.right);
    return pRoot;
}