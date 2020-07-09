package io.github.sruby.arithmetic.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @date 2020/7/9 10:13
 */
@Slf4j
public class MergeSort {

    public int[] sortArray(int[] nums){
        nums = sort(nums);
        return nums;
    }
    public int[] sort(int[] nums){
        if (nums.length<2){
            return nums;
        }

        int length = nums.length;
        int middle = length/2;
        int start = 0;

        int[] firstArray = Arrays.copyOfRange(nums,start,middle);
        int[] secondArray = Arrays.copyOfRange(nums,middle,length);

        return merge(sort(firstArray),sort(secondArray));
    }


    /**
     * merge
     * @param firstArray
     * @param secondArray
     * @return
     */
    private int[] merge(int[] firstArray, int[] secondArray) {
        int firstArrayLength = firstArray.length;
        int secondArrayLength = secondArray.length;
        int[] mergeArray = new int[firstArrayLength + secondArrayLength];
        int mergeIndex = 0;
        int i=0,j=0;
        for (; i< firstArrayLength &&j< secondArrayLength;){
            if (firstArray[i] < secondArray[j]){
                mergeArray[mergeIndex] = firstArray[i];
                i++;
            }else {
                mergeArray[mergeIndex] = secondArray[j];
                j++;
            }
            mergeIndex++;
        }
        if (i < firstArrayLength ){
            for (;i<firstArrayLength;i++){
                mergeArray[mergeIndex] = firstArray[i];
                mergeIndex++;
            }
        }

        if (j < secondArrayLength){
            for (;j<secondArrayLength;j++){
                mergeArray[mergeIndex] = secondArray[j];
                mergeIndex++;
            }
        }

        return mergeArray;
    }
}
