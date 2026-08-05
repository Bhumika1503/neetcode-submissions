class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums)
     {
        backtrack(0, nums, new ArrayList<>());
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> subset) {
        if (index == nums.length)
        {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);

        backtrack(index + 1, nums, subset);
        subset.remove(subset.size() - 1);
        
        backtrack(index + 1, nums, subset);
    }
}
