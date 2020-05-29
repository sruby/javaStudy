package io.github.sruby.leetcode.primary.arithmetic;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * @author sruby on ${date} ${time}
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        List<Integer> list = new LinkedList();
        return null;

    }

    @Test
    public void test(){
        int[] digits = {4,3,2,1};
        int[] plusOne = PlusOne.plusOne(digits);

        for (int i = 0; i < plusOne.length; i++){
            System.out.println(plusOne[i]);
        }
    }
}
