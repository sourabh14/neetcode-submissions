class Solution {
    public static void generate(int[] nums, int indx, List<Integer> curr, List<List<Integer>> ans) {
        ans.add(curr);
        for (int i=indx; i<nums.length; ) {
            List<Integer> list = new ArrayList<>(curr);
            int num = nums[i];
            list.add(num);
            generate(nums, i+1, list, ans);
            while ((i<nums.length) && (nums[i] == num)) i++;
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        generate(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
}
