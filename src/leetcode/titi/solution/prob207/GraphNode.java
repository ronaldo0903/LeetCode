package leetcode.titi.solution.prob207;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int label;
    public List<GraphNode> neighbors;

    public GraphNode(int x) {
        this.label = x;
        neighbors = new ArrayList<>();
    }
}
