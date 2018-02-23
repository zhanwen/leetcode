package algorithm;

public class SameTree {

    /**
     * 判断是否为同一颗树
     * 根节点相同，并且左右子树都相同时，才为同一颗树
     * 典型的判断方法就是使用递归进行判断，将左右子树看成新的一颗树，直到遍历完
     * @param p 树
     * @param q 树
     * @return  true 表示同一颗树 false 表示不是同一颗树
     */
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

