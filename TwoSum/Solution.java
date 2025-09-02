class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] two_numbers = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    two_numbers[0] = i;
                    two_numbers[1] = j;
                    break;
                }
            }
        }        
        return two_numbers;
    }
}
