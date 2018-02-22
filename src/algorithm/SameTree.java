package algorithm;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null ? true : false;
        }
        if (q == null) {
            return p == null ? true : false;
        }

        if (p != null && q != null) {

            if (p.val != q.val) {
                return false;
            }
            boolean left = isSameTree(p.left, q.left);
            boolean right = isSameTree(p.right, q.right);

            if (left && right) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(1);

        SameTree st = new SameTree();
        boolean result = st.isSameTree(p, q);
        System.out.println(result);
    }


}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

}

