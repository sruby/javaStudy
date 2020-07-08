package io.github.sruby.arithmetic.sort;

/**
 * 912. Sort an Array
 * error info :Time Limit Exceeded
 * @date 2020/7/8 9:40
 */
public class BadSort {
    /**
     * sort
     * @param nums
     */
    public int[] sort(int[] nums){
        if (1 > nums.length || nums.length > 50000){
            return null;
        }

        boolean isChange = false;
        for (int i=0;i<nums.length;i++){
            if(-50000 > nums[i] || nums[i] > 50000){
                return null;
            }
            int temp;
            for (int j=i+1;j<nums.length;j++){
                if (nums[j] < nums[i]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    isChange = true;
                }
            }
            if (!isChange){
                break;
            }
        }

        return nums;
    }
}
