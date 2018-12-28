package leetcode.titi.solution.prob199;
/*
 * Definition for a binary tree node.
*/

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BTreeRightSideViewSolution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Queue<Pair<TreeNode, Integer>> nodeQueue = new ArrayDeque<>();
        if(root != null) {
            nodeQueue.add(new Pair<>(root, 0));
        }
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.peek().getKey();
            int depth = nodeQueue.peek().getValue();
            nodeQueue.remove();
            if(resultList.size() == depth) {
                resultList.add(node.val);
            }
            else {
                resultList.set(depth, node.val);
            }
            if(node.left != null) nodeQueue.add(new Pair<>(node.left, depth + 1));
            if(node.right != null) nodeQueue.add(new Pair<>(node.right, depth + 1));
        }
        return  resultList;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
