package leetcode.titi.solution.prob236;

import jdk.net.SocketFlow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NearestCommonAncestorSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> path = new ArrayDeque<>();
        Deque<TreeNode> p_path = new ArrayDeque<>();
        Deque<TreeNode> q_path = new ArrayDeque<>();
        StatusWrapper sw = new StatusWrapper(false);
        preorder(root, p, path, p_path, sw);
        path.clear();
        sw.setFinished(false);
        preorder(root, q, path, q_path, sw);
        int path_len = p_path.size() < q_path.size() ? p_path.size() : q_path.size();
        TreeNode lowestAncestor = root;
        for(int i=0; i<path_len; i++) {
            if(p_path.getFirst() == q_path.getFirst()) {
                lowestAncestor = p_path.getFirst();
                p_path.removeFirst();
                q_path.removeFirst();
            }
        }
        return lowestAncestor;
    }

    private void preorder(TreeNode node, TreeNode target, Deque<TreeNode> path, Deque<TreeNode> result, StatusWrapper sw) {
        if(node == null || sw.isFinished()) return;
        path.add(node);
        if(node == target) {
            sw.setFinished(true);
            result.addAll(path);
            return;
        }
        preorder(node.left, target, path, result, sw);
        preorder(node.right, target, path, result, sw);
        path.removeLast();
    }

    public class StatusWrapper {
        public boolean isFinished() {
            return finished;
        }

        public void setFinished(boolean finished) {
            this.finished = finished;
        }

        public boolean finished;

        public StatusWrapper() {
            this(false);
        }

        public StatusWrapper(boolean finished) {
            this.finished = finished;
        }

    }
}
