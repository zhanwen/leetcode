package algorithm;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        if(root == null) {
            return true;
        }
        return isSymmetricRec(root.left, root.right);
    }

    private boolean isSymmetricRec(TreeNode left, TreeNode right) {

        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }

        if(left.val != right.val) {
            return false;
        }

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
