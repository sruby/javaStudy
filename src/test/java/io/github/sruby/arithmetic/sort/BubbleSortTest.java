package io.github.sruby.arithmetic.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @date 2020/7/8 9:46
 */
@Slf4j
public class BubbleSortTest {
    private BubbleSort bubbleSort = new BubbleSort();

    @Test
    public void sort() {
        int[] array = new int[]{1,8,9,3,0,1,1,1,1,222};
        bubbleSort.sort(array);
        log.debug("array:{}",array);
    }

    @Test
    public void test() {
        int[] array = new int[]{3,5,4,2,1,6};
        bubbleSort.sort(array);
        log.debug("array:{}",array);
    }
}