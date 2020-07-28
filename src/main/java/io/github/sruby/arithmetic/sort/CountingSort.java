package io.github.sruby.arithmetic.sort;

/**
 * @description: countingSort
 * @author: sruby
 * @create: 2020-07-19 11:01
 */
public class CountingSort {

    public int[] sortArray(int[] nums){
        int max = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++){
            if (nums[i] >max){
                max = nums[i];
            }
        }

        int[] countArray = new int[max+1];
        //init countArray
        for (int i = 0; i < max+1; i++){
             countArray[i] = 0;
        }
        for (int i = 0; i < length; i++){
           countArray[nums[i]]++;
        }

        int count = 0;
        for (int i = 0; i < max+1; i++){
            count += countArray[i];
            countArray[i] = count;
        }

        int[] r = new int[length];
        for (int i = 0; i < length; i++){
            r[countArray[nums[i]]-1] = nums[i];
            countArray[nums[i]] --;
        }

        nums = r;
        return nums;
    }
}
