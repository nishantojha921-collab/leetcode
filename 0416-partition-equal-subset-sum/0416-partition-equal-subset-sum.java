class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int i:nums){
            sum += i;
        }
        if(sum%2 != 0) return false;

        sum = sum/2;

        //logic
        boolean[] Dp = new boolean[sum+1];
        Dp[0] = true;
        
        for(int i : nums){
            for(int j = sum; j >= i; j--){
                Dp[j] = Dp[j] | Dp[j-i];
            }
        }
        return Dp[sum];
    }
}