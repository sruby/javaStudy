package io.github.sruby.interfacetest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * test
 *
 * @author sruby on 2020-6-26 16:42
 */
@Slf4j
public class InterfaceWithStaticMethodTest {
    @Test
    public void test(){
        InterfaceWithStaticMethod interfaceWithStaticMethod = new InterfaceWithStaticMethod() {
            @Override
            public void div(int a, int b) {
                log.debug("a div b");
            }
        };

        int mul = InterfaceWithStaticMethod.mul(2, 20);
        log.debug("mul:{}",mul);
        int add = interfaceWithStaticMethod.add(2, 3);
        log.debug("add:{}",add);

    }
}