package io.github.sruby.arithmetic.sort;

/**
 * @date 2020/7/14 15:02
 */
public class QuickSort {

    public int[] sortArray(int[] nums){

        nums = sort(nums,0 ,nums.length-1);

        return nums;
    }

    public int[] sort(int[] nums,int start,int end){

        int pivot = partition(nums,start,end);
        sort(nums,start,pivot);
        sort(nums,pivot+1,end);

        return nums;
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        

        return 0;
    }
}
