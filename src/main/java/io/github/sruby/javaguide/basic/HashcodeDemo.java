package io.github.sruby.javaguide.basic;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * hashcode
 *
 * @author sruby on 2020-6-25 11:47
 */
@Data
@AllArgsConstructor
public class HashcodeDemo {
    private String fieldOne;
    private String fieldTwo;

    public boolean equal(HashcodeDemo hashcodeDemo){
        if (this.fieldOne.equals(hashcodeDemo.getFieldOne()) && this.fieldTwo.equals(hashcodeDemo.getFieldTwo())){
            return true;
        }

        return false;
    }
}
