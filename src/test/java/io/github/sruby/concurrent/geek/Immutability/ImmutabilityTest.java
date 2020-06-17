package io.github.sruby.concurrent.geek.Immutability;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @description: Immutability test
 * @author: sruby
 * @create: 2020-06-17 15:55
 */
@Slf4j
public class ImmutabilityTest {
    @Test
    public void test(){
        Account account = new Account("zhangsan");
        log.debug("account:{}",account);
        account.getName().append("change");
        log.debug("account:{}",account);
    }

    @ToString
    final class  Account{
        //StringBuffer is mutability object ,so account is mutability that can be cahnged by change name
        private final StringBuffer name;
        public Account(String name){
            this.name = new StringBuffer(name);
        }

        public StringBuffer getName() {
            return name;
        }
    }
}
