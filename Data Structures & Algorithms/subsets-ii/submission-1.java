class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0,new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums,int start,List<Integer> c){
        result.add(new ArrayList<>(c));
        for(int i=start;i<nums.length;i++)
        {
            if(i>start && nums[i]==nums[i-1])
                continue;

            c.add(nums[i]);
            backtrack(nums,i+1,c);
            c.remove(c.size()-1);
        }
    }
}