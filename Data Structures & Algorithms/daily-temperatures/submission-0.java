
class Pair {
    int val, index;

    public Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i=0; i<temperatures.length; i++) {
            while ((!stack.isEmpty()) && (temperatures[i] > stack.peek().val)) {
                Pair pair = stack.pop();
                ans[pair.index] = i - pair.index;
            }
            stack.push(new Pair(temperatures[i], i));
        }
        return ans;
    }
}
