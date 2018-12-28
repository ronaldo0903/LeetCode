package leetcode.titi.solution.prob207;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleSolution_DFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<GraphNode> graph = new ArrayList<>();
        List<Integer> visit = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            graph.add(new GraphNode(i));
            visit.add(-1);
        }
        for(int j=0; j<prerequisites.length; j++) {
            GraphNode begin = graph.get(prerequisites[j][1]);
            GraphNode end = graph.get(prerequisites[j][0]);
            begin.neighbors.add(end);
        }
        for(int k=0; k<graph.size(); k++) {
            //依次深度优先遍历图中的结点，若在遍历其中任意一个结点时出现环，则返回false
            if(visit.get(k) == -1 && !DFS_Graph(graph.get(k),visit)) return false;
        }
        graph = null;
        //当遍历完所有的结点后都没有发现环，则返回true
        return true;


    }
    /*
     * 使用深度优先搜索从node结点沿着有向图的边遍历，如果遇到环，则返回false
     */
    private boolean DFS_Graph(GraphNode node, List<Integer> visit) {
        visit.set(node.label, 0);
        for(int i=0; i<node.neighbors.size(); i++) {
            if(visit.get(node.neighbors.get(i).label) == -1) {
                if(!DFS_Graph(node.neighbors.get(i), visit)) return false;
            }
            else if(visit.get(node.neighbors.get(i).label) == 0) {
                return false;
            }
        }
        visit.set(node.label, 1);
        return true;
    }
}
