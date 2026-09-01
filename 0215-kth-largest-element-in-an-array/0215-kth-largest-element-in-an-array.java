class Solution {
    public int findKthLargest(int[] nums, int k) {
        // int n = nums.length;

        // Arrays.sort(nums);

        // return nums[n-k];


        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int num : nums){
            if(heap.size()<k){
                heap.add(num);
            }
            else{
                if(num>heap.peek()){

                    heap.poll();
                    heap.add(num);
                }
            }
        }
        return heap.peek();
    }
}