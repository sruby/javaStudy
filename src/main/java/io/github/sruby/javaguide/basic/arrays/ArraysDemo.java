package io.github.sruby.javaguide.basic.arrays;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ArraysDemo {

    @Test
    public void test(){
        int[] array = new int[10];
        log.debug("array:{}",array);
        log.debug("array length:{}",array.length);
        Integer[] array2 = new Integer[10];
        log.debug("array:{}",array2);
        log.debug("array length:{}",array2.length);
        Integer integer = array2[0];
        log.debug(String.valueOf(integer));
    }
}
