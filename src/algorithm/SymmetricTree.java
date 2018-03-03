package algorithm;

public class SymmetricTree {

    /**
     * 判断是否是镜像树
     * 跟前面的判断是否是同一颗树原理差不多，首先要判断根节点是否为空，若为空直接返回结果（true）,若不空，则分开判断左右子树
     * @param root  要判断的树
     * @return  true（镜像树）,false（不是镜像树）
     */
    public boolean isSymmetric(TreeNode root) {

        if(root == null) {
            return true;
        }
        //如果用迭代这里并不怎么好做，所以这里分别判断左右字树
        return isSymmetricRec(root.left, root.right);
    }

    private boolean isSymmetricRec(TreeNode left, TreeNode right) {
        //左右子树都为空，表示单个节点，是镜像树
        if(left == null && right == null) {
            return true;
        }
        //左右子树有一个为空，则不符合镜像树的要求，直接返回false
        if(left == null || right == null) {
            return false;
        }
        //一个根节点，有左右字树，并且左右子树没有其余的子节点，左右子树的值必须相同，才符合要求
        if(left.val != right.val) {
            return false;
        }
        // 递归调用，既然是镜像树，就必须要同时满足左右两边的情况
        return isSymmetricRec(left.left, right.right) && isSymmetricRec(left.right, right.left);

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

        SymmetricTree tree = new SymmetricTree();
        boolean result = tree.isSymmetric(null);
        System.out.println(result);
    }



}
