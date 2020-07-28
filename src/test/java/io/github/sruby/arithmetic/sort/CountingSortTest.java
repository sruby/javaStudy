package io.github.sruby.arithmetic.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class CountingSortTest {
    private CountingSort countingSort = new CountingSort();

    @Test
    public void sortArray() {
        int[] array = new int[]{1,8,9,3,0,1,1,1,1,222};
        array = countingSort.sortArray(array);
        log.debug("array:{}",array);
    }

    @Test
    public void sortArray1() {
        int[] array = new int[]{5,2,3,1};
        array = countingSort.sortArray(array);
        log.debug("array:{}",array);
    }
}