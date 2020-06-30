package io.github.sruby.javaguide.basic.hashcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * HashcodeDemoWithoutOverrideHashcode
 *
 * @author sruby on 2020-6-25 11:47
 */
@Getter
@Setter
@AllArgsConstructor
public class HashcodeDemoWithoutOverrideHashcode {
    private String fieldOne;
    private String fieldTwo;

    public boolean equal(Object hashcodeDemo){
        if (this == hashcodeDemo){
            return true;
        }

        if (hashcodeDemo instanceof HashcodeDemoWithoutOverrideHashcode){
            HashcodeDemoWithoutOverrideHashcode demo = (HashcodeDemoWithoutOverrideHashcode) hashcodeDemo;
            if (this.fieldOne.equals(demo.getFieldOne()) && this.fieldTwo.equals(demo.getFieldTwo())){
                return true;
            }
        }

        return false;
    }
}
