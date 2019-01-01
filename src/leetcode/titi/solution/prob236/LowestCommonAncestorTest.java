package leetcode.titi.solution.prob236;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorTest {
    public static void main(String[] args) {
        int treeNodeArr[] = {3,5,1,6,2,0,8,-1,-1,7,4};
        List<TreeNode> tree = buildTree(treeNodeArr);
        NearestCommonAncestorSolution sln = new NearestCommonAncestorSolution();
        TreeNode ancestor = sln.lowestCommonAncestor(tree.get(0), tree.get(1), tree.get(10));
        System.out.println(ancestor.val);
    }
    private static List<TreeNode> buildTree(int[] nodeArr) {
        List<TreeNode> treeList = new ArrayList();
        for(int i=0; i<nodeArr.length; i++) {
            if(nodeArr[i] != -1) treeList.add(new TreeNode(nodeArr[i]));
            else treeList.add(null);
        }
        for(int i=1; i<nodeArr.length; i++) {
            boolean isRightChild = (i % 2 == 0);
            int parentIndex = (i-1)/2;
            TreeNode parent = treeList.get(parentIndex);
            TreeNode current = treeList.get(i);
            if(parent != null) {
                if (isRightChild) parent.right = treeList.get(i);
                else parent.left = treeList.get(i);
            }
        }
        return treeList;
    }
}
