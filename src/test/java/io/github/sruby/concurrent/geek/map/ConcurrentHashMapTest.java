package io.github.sruby.concurrent.geek.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: ConcurrentHashMap test
 * @author: sruby
 * @create: 2020-06-09 17:22
 */
@Slf4j
public class ConcurrentHashMapTest {
    @Test
    public void test(){
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("First", 10);
        map.put("Second", 20);
        map.put("Third", 30);
        map.put("Fourth", 40);

        Iterator<String> iterator = map.keySet().iterator();


        while (iterator.hasNext()) {
            String key = iterator.next();
            log.debug("key:{}",key);
            /**
             * Iterator isn't guaranteed to return updated data from the Collection, as it's working on the clone instead of the actual Collection.
             * may be dont contain Fifth
             */
            map.put("Fifth", 50);
        }
    }
}
