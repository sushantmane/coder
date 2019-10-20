package cpc.oj.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P973_KClosestPointsToOrigin {

    class Point implements Comparable<Point> {
        int d;
        int[] pt;

        Point(int[] pt, int d) {
            this.pt = pt;
            this.d = d;
        }

        @Override
        public int compareTo(Point compToPoint) {
            return this.d - compToPoint.d;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        List<Point> list = new ArrayList<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int distSqr = x * x + y * y;
            list.add(new Point(point, distSqr));
        }
        Collections.sort(list);
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = list.get(i).pt;
        }
        return res;
    }
}
