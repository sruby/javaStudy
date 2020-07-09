package io.github.sruby.arithmetic.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @date 2020/7/9 16:03
 */
@Slf4j
public class MergeSortTest {
    private MergeSort mergeSort = new MergeSort();

    @Test
    public void sortArray() {
        int[] array = new int[]{1,8,9,3,0,1,1,1,1,222};
        array = mergeSort.sortArray(array);
        log.debug("array:{}",array);
    }
}