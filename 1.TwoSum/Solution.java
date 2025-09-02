/*
 * Given an array of integers nums and an integer target, return indices
 * of the two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and
 * you may not use the same element twice.
 */

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
