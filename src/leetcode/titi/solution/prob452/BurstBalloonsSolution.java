package leetcode.titi.solution.prob452;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BurstBalloonsSolution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        List<Balloon> ballons = new ArrayList();
        for(int i=0; i<points.length; i++) {
            ballons.add(new Balloon(points[i][0], points[i][1]));
        }
        Collections.sort(ballons, new BallonComparator());
        int shoot_num = 1;
        int shoot_begin = ballons.get(0).startPos;
        int shoot_end = ballons.get(0).endPos;
        for(int j=1; j<ballons.size(); j++) {
            if(ballons.get(j).startPos >= shoot_begin && ballons.get(j).startPos <= shoot_end) {
                shoot_begin = ballons.get(j).startPos;
                if(ballons.get(j).endPos <= shoot_end) {
                    shoot_end = ballons.get(j).endPos;
                }
            }
            else {
                shoot_num++;
                shoot_begin = ballons.get(j).startPos;
                shoot_end = ballons.get(j).endPos;
            }
        }
        return shoot_num;

    }
    class Balloon {
        int startPos;
        int endPos;
        public Balloon(int x1, int x2) {
            this.startPos = x1;
            this.endPos = x2;
        }
    }
    class BallonComparator implements Comparator<Balloon> {

        @Override
        public int compare(Balloon o1, Balloon o2) {
            return o1.startPos > o2.startPos ? 1 : -1;
        }
    }
}
