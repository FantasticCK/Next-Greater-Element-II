package com.CK;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 0)
            return new int[0];
        Stack<int[]> stack = new Stack<>();
        Map<Integer, Integer> nextGreater = new HashMap<>();
        for (int i = 0; i < 2 * nums.length; i++) {
            int index = (i + nums.length) % nums.length;
            while (!stack.isEmpty() && nums[index] > stack.peek()[1]) {
                int[] curr = stack.pop();
                nextGreater.put(curr[0], nums[index]);
            }
            stack.push(new int[]{index, nums[index]});
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nextGreater.getOrDefault(i, -1);
        }
        return res;
    }
}