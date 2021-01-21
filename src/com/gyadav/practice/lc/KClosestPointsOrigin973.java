package com.gyadav.practice.lc;

import java.util.PriorityQueue;

public class KClosestPointsOrigin973 {
    public static void main (String[] a) {
        KClosestPointsOrigin973 kClosestPointsOrigin973 = new KClosestPointsOrigin973();
        kClosestPointsOrigin973.kClosest(new int[][] {{3,3},{5,-1},{-2,4}}, 2);
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((a,b) -> b.distanceFromOrigin() - a.distanceFromOrigin());
        int[][] output = new int[K][2];
        for (int i = 0; i < K; i++)
            maxHeap.add(new Point(points[i][0], points[i][1]));
        for (int i = K; i < points.length; i++) {
            Point current = new Point(points[i][0], points[i][1]);
            if (maxHeap.peek().distanceFromOrigin() > current.distanceFromOrigin()) {
                maxHeap.poll();
                maxHeap.offer(current);
            }
        }
        int index = 0;
        for (Point p : maxHeap) {
            output[index++] = p.getPoint();
        }
        return output;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int distanceFromOrigin() {
            return (x * x) + (y * y);
        }
        public int[] getPoint() {
            return new int[] {x, y};
        }
    }
}
