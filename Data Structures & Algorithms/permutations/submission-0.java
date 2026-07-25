class Solution {
    public void generate(int[] nums, int indx, List<List<Integer>> ans) {
        if (indx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n: nums) list.add(n);
            ans.add(list);
            return;
        }
        
        for (int i=indx; i<nums.length; i++) {
            int temp = nums[indx]; nums[indx] = nums[i]; nums[i] = temp;
            generate(nums, indx+1, ans);
            temp = nums[indx]; nums[indx] = nums[i]; nums[i] = temp;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int[] arr = new int[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        generate(nums, 0, ans);
        return ans;
    }
}
