class Solution {
    public void generate(int[] nums, int indx, List<Integer> curr, List<List<Integer>> ans) {
        ans.add(curr);
        for (int i=indx; i<nums.length; i++) {
            List<Integer> list = new ArrayList<>(curr);
            list.add(nums[i]);
            generate(nums, i+1, list, ans);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
}
