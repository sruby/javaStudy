package io.github.sruby.javaguide.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test
 *
 * @author sruby on 2020-6-26 10:15
 */
@Slf4j
public class HashcodeDemoTest {

    @Test
    void testEquals() {
        HashcodeDemo hashcodeDemo = new HashcodeDemo("1","2");
        HashcodeDemo hashcodeDemo2 = new HashcodeDemo("1","2");
        boolean equal = hashcodeDemo.equal(hashcodeDemo2);
        log.debug("equal:{}",equal);

        Set<HashcodeDemo> set = new HashSet<>();
        set.add(hashcodeDemo);
        set.add(hashcodeDemo2);

        log.debug("set:{}",set);
    }


}