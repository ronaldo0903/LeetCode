package leetcode.titi.solution.prob207;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleSolution_BFS {
    /*
     *算法思路：
     * 使用宽度优先搜索时，只将入度为0的结点(没有依赖结点或是所有的依赖结点已经访问过)添加至队列。
     * 当完成一个结点的搜索（从队列中取出）时，它指向的所有结点的入度都减一，若此时某个结点的入度为0，则添加至队列；
     * 若完成搜索后，所有结点的入度都为0，则图无环，否则图有环
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<GraphNode> graph = new ArrayList<>();
        int degrees[] = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            graph.add(new GraphNode(i));
            degrees[i] = 0;
        }
        for(int j=0; j<prerequisites.length; j++) {
            GraphNode begin = graph.get(prerequisites[j][1]);
            GraphNode end = graph.get(prerequisites[j][0]);
            begin.neighbors.add(end);
            degrees[end.label] ++;
        }
        Queue<GraphNode> queue = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++) {
            if(degrees[i] == 0) queue.add(graph.get(i));
        }
        while(!queue.isEmpty()) {
            GraphNode node = queue.peek();
            queue.remove();
            for(int i=0; i<node.neighbors.size(); i++) {
                if(--degrees[node.neighbors.get(i).label] == 0) {
                    queue.add(graph.get(node.neighbors.get(i).label));
                }
            }
        }
        for(int i=0; i<degrees.length; i++) {
            if(degrees[i] != 0) return false;
        }
        return true;
    }
}
