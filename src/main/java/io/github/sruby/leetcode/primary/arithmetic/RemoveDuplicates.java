package io.github.sruby.leetcode.primary.arithmetic;

import org.junit.Test;

/**
 * @Description: 从排序数组中删除重复项
 * @author: sruby
 * @Date: 18/8/4 09:11
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0 ){
            return  0;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[count]){
                count++;
                nums[count] = nums[i];
            }
        }
        return count +1;
    }

    @Test
    public void test(){
        int[] nums = {1,1,2};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

}
