package com.spring.activi.demo.algorithm;

/**
 * @author: wufeng
 * @date: 2018/6/22 17:28
 * @desrcption: 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。  你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 */
public class SumEquals {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 1, 8, 11, 15};
        int target = 9;
        twoSum(nums, target);
    }

    public static void twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    System.out.println(nums[i] + "+" + nums[j]);
                }
            }
        }
    }
}
