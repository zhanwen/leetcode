package algorithm;

import java.util.*;

public class BinaryTreeLevelOrderTraversal_II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        levelMaker(lists, root, 0);
        return lists;
    }

    /**
     * 才用bfs方法，广度优先搜索方法。逐层访问
     * @param lists
     * @param root
     * @param level
     */
    private void levelMaker(List<List<Integer>> lists, TreeNode root, int level) {
        if(root == null) return;

        if(level >= lists.size()) {
            lists.add(0, new LinkedList<Integer>());
        }
        levelMaker(lists, root.left, level+1);
        levelMaker(lists, root.right, level+1);

        lists.get(lists.size()-level-1).add(root.val);
    }

    /**
     * 采用dfs方法，借助队列的先进先出的性质，将得到的数字先放入队列中，然后在放入到集合中，最后在放入linkedlist中
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList);
        }
        return wrapList;
    }


    public static void main (String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(3);
        n2.right = n4;
        n3.left = n5;

        BinaryTreeLevelOrderTraversal_II tree = new BinaryTreeLevelOrderTraversal_II();
        tree.levelOrderBottom(n1);
    }
}
