class Point {
    int x, y;
    double dist;

    public Point(int x, int y, double dist) {
        this.x = x;
        this.y = y;
        this.dist =dist;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pQueue = new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));
        for (int[] point: points) {
            int x = point[0];
            int y = point[1];
            double dist = Math.sqrt((x*x) + (y*y));
            if (pQueue.size() == k) {
                if (dist < pQueue.element().dist) {
                    pQueue.remove();
                    pQueue.add(new Point(x, y, dist));
                }
            } else {
                pQueue.add(new Point(x, y, dist));
            }
        }
        
        int n = pQueue.size();
        int[][] ans = new int[n][2];
        
        for (int i=0; i<n; i++) {
            Point point = pQueue.remove();
            ans[i][0] = point.x;
            ans[i][1] = point.y;
        }
        return ans;
    }
}
