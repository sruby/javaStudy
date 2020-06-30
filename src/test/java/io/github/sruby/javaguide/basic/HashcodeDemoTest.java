package io.github.sruby.javaguide.basic;

import io.github.sruby.javaguide.basic.hashcode.HashcodeDemoNormal;
import io.github.sruby.javaguide.basic.hashcode.HashcodeDemoWithoutOverrideHashcode;
import io.github.sruby.javaguide.basic.hashcode.HashcodeDemoWithoutOverrideHashcodeAndEquals;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * test
 *
 * @author sruby on 2020-6-26 10:15
 */
@Slf4j
public class HashcodeDemoTest {
    HashcodeDemoWithoutOverrideHashcode hashcodeDemoWithoutOverrideHashcode = new HashcodeDemoWithoutOverrideHashcode("1","2");
    HashcodeDemoWithoutOverrideHashcode hashcodeDemoWithoutOverrideHashcode2 = new HashcodeDemoWithoutOverrideHashcode("1","2");
    HashcodeDemoWithoutOverrideHashcode hashcodeDemoWithoutOverrideHashcode3 = new HashcodeDemoWithoutOverrideHashcode("3","2");

    @Test
    void testEquals() {

        boolean equal = hashcodeDemoWithoutOverrideHashcode.equal(hashcodeDemoWithoutOverrideHashcode2);
        log.debug("equal:{}",equal);

        Set<HashcodeDemoWithoutOverrideHashcode> set = new HashSet<>();
        set.add(hashcodeDemoWithoutOverrideHashcode);
        set.add(hashcodeDemoWithoutOverrideHashcode2);

        Assert.assertTrue(set.size() == 1);

        log.debug("set:{}",set);
    }

    /**
     *
     */
    @Test
    void hashcodeDemoWithoutOverrideHashcodeAndEquals() {
        HashcodeDemoWithoutOverrideHashcodeAndEquals hashcodeDemoWithoutOverrideHashcode = new HashcodeDemoWithoutOverrideHashcodeAndEquals("1","2");
        HashcodeDemoWithoutOverrideHashcodeAndEquals hashcodeDemoWithoutOverrideHashcode2 = new HashcodeDemoWithoutOverrideHashcodeAndEquals("1","2");
        HashcodeDemoWithoutOverrideHashcodeAndEquals hashcodeDemoWithoutOverrideHashcode3 = new HashcodeDemoWithoutOverrideHashcodeAndEquals("3","2");
        Map<HashcodeDemoWithoutOverrideHashcodeAndEquals,String> map = new HashMap<>();
        map.put(hashcodeDemoWithoutOverrideHashcode,"a1");
        map.put(hashcodeDemoWithoutOverrideHashcode2,"a2");

        log.debug("map:{}",map);

        Assert.assertTrue(map.size() == 1);

        String s = map.get(hashcodeDemoWithoutOverrideHashcode);
        String s2 = map.get(hashcodeDemoWithoutOverrideHashcode2);
        log.debug("s:{},s2:{},s1:{}",s,s2);
        log.debug("hashcodeDemoWithoutOverrideHashcode：{}，hashcodeDemoWithoutOverrideHashcode2：{}，hashcodeDemoWithoutOverrideHashcode3：{}"
                ,hashcodeDemoWithoutOverrideHashcode.hashCode(),hashcodeDemoWithoutOverrideHashcode2.hashCode(),hashcodeDemoWithoutOverrideHashcode3.hashCode());
        Assert.assertTrue(s.equals(s2));
    }

    @Test
    void hashcodeDemoNormal() {
        HashcodeDemoNormal hashcodeDemoWithoutOverrideHashcode = new HashcodeDemoNormal("1","2");
        HashcodeDemoNormal hashcodeDemoWithoutOverrideHashcode2 = new HashcodeDemoNormal("1","2");
        HashcodeDemoNormal hashcodeDemoWithoutOverrideHashcode3 = new HashcodeDemoNormal("3","2");
        Map<HashcodeDemoNormal,String> map = new HashMap<>();
        map.put(hashcodeDemoWithoutOverrideHashcode,"a1");
        map.put(hashcodeDemoWithoutOverrideHashcode2,"a2");

        log.debug("map:{}",map);

        Assert.assertTrue(map.size() == 1);

        String s = map.get(hashcodeDemoWithoutOverrideHashcode);
        String s2 = map.get(hashcodeDemoWithoutOverrideHashcode2);
        log.debug("s:{},s2:{},s1:{}",s,s2);
        log.debug("hashcodeDemoWithoutOverrideHashcode：{}，hashcodeDemoWithoutOverrideHashcode2：{}，hashcodeDemoWithoutOverrideHashcode3：{}"
                ,hashcodeDemoWithoutOverrideHashcode.hashCode(),hashcodeDemoWithoutOverrideHashcode2.hashCode(),hashcodeDemoWithoutOverrideHashcode3.hashCode());
        Assert.assertTrue(s.equals(s2));
    }

    @Test
    void HashcodeDemoWithoutOverrideHashcode() {
        Map<HashcodeDemoWithoutOverrideHashcode,String> map = new HashMap<>();
        map.put(hashcodeDemoWithoutOverrideHashcode,"a1");
//        map.put(hashcodeDemoWithoutOverrideHashcode,"a1");
        map.put(hashcodeDemoWithoutOverrideHashcode3,"a2");

        log.debug("map:{}",map);

        Assert.assertTrue(map.size() == 2);

        String s = map.get(hashcodeDemoWithoutOverrideHashcode);
        String s2 = map.get(hashcodeDemoWithoutOverrideHashcode2);
        String s3 = map.get(hashcodeDemoWithoutOverrideHashcode3);
        log.debug("s:{},s2:{},s1:{}",s,s2,s3);
        log.debug("hashcodeDemoWithoutOverrideHashcode：{}，hashcodeDemoWithoutOverrideHashcode2：{}",hashcodeDemoWithoutOverrideHashcode.hashCode(),hashcodeDemoWithoutOverrideHashcode2.hashCode());
        Assert.assertTrue(s.equals(s2));
    }



    @Test
    void hashcodeDemoWithEqualOneField() {
        HashcodeDemoNormal hashcodeDemoWithEqualOneField = new HashcodeDemoNormal("1","2");
        Map<HashcodeDemoNormal,String> map = new HashMap<>();
        map.put(hashcodeDemoWithEqualOneField,"a1");
        map.put(hashcodeDemoWithEqualOneField,"a2");

        log.debug("map:{}",map);
    }


}