package io.github.sruby.arithmetic.sort;

/**
 * @description: Radix sort
 * https://www.baeldung.com/java-radix-sort
 * @author: sruby
 * @create: 2020-07-25 10:10
 */
public class RadixSort {
    public int[] sort(int[] nums){
        for (int i = 10; i > 0; i--){
            int max = 0;
            int length = nums.length;
            for (int j = 0; j < length; j++){
                char charAt = String.valueOf(nums[j]).charAt(i);
                Integer singleNum = Integer.valueOf(charAt);
                if (singleNum>max){
                    max = singleNum;
                }
            }

            int[] countArray = new int[max];
            for (int h = 0; h < length; h++){
                char charAt = String.valueOf(nums[h]).charAt(i);
                Integer singleNum = Integer.valueOf(charAt);
                countArray[singleNum]++;
            }

        }

        return nums;
    }
}
