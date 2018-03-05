package algorithm;

public class MaximumDepthofBinaryTree {

    /**
     * 计算二叉树的深度
     * 用递归计算，分别计算左右子树的深度，返回左右子树中的最大值，最后加上1就是要求的值。
     * @param root  树
     * @return  树的深度
     */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int deepl = maxDepth(root.left);
        int deepr = maxDepth(root.right);
        return deepl > deepr ? deepl+1 : deepr+1;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(3);
        n2.right = n4;
        n3.left = n5;

        MaximumDepthofBinaryTree tree = new MaximumDepthofBinaryTree();
        int result = tree.maxDepth(n1);
        System.out.println(result);
    }
}
