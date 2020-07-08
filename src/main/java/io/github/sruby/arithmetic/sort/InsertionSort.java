package io.github.sruby.arithmetic.sort;

/**
 * @date 2020/7/8 10:03
 */
public class InsertionSort {
    public int[] sortArray(int[] nums) {
        if (1 > nums.length || nums.length > 50000){
            return null;
        }

        for (int i=1;i<nums.length;++i){
            if(-50000 > nums[i] || nums[i] > 50000){
                return null;
            }

            int value = nums[i];
            int j=i-1;
            for (;j>=0;--j){
                if (value <nums[j]){
                    nums[j+1] = nums[j];
                }else {
                    break;
                }
            }
            //j+1 because j--
            nums[j+1] = value;
        }
        return nums;
    }
}
