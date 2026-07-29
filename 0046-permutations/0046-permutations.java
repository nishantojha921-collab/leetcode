class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        findPermutation(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    public void findPermutation(int[] nums,List<List<Integer>> res, List<Integer> currList, boolean[] usedvals){
        if(currList.size() == nums.length){
            res.add(new ArrayList<>(currList));
            return;
        }
        for(int i=0;i<nums.length; i++){
            if(usedvals[i] == true) continue;
            currList.add(nums[i]);
            usedvals[i] =true;
            findPermutation(nums,res, currList,usedvals);
            currList.remove(currList.size() - 1);
            usedvals[i] = false;
        }
    }
}