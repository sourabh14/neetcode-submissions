class Pair {
    int val, index;

    public Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n];

        Arrays.fill(nse, heights.length);
        Arrays.fill(pse, -1);

        Stack<Pair> stack = new Stack<>();
        for (int i=0; i<heights.length; i++) {
            while ((!stack.isEmpty()) && (heights[i] < stack.peek().val)) {
                Pair top = stack.pop();
                nse[top.index] = i;
            }
            stack.push(new Pair(heights[i], i));
        }

        stack.clear();

        for (int i=heights.length-1; i>=0; i--) {
            while ((!stack.isEmpty()) && (heights[i] < stack.peek().val)) {
                Pair top = stack.pop();
                pse[top.index] = i;
            }
            stack.push(new Pair(heights[i], i));
        }
        
        for (int i=0; i<n; i++) {
            int area = (nse[i] - pse[i] - 1) * heights[i];
            ans = Math.max(ans, area);
        }
        
        return ans;
    }
}
