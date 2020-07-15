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
        int i = start;
        for (int j = start; i < end; j++){
            if (nums[j] < pivot){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        int temp = nums[i];
        nums[i] = pivot;
        nums[end] = temp;
        return i;
    }
}
