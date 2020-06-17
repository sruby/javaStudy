package io.github.sruby.concurrent.geek.atomic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @description: AtomicStampedReference test
 *
 * http://tutorials.jenkov.com/java-util-concurrent/atomicstampedreference.html
 * @author: sruby
 * @create: 2020-06-12 17:44
 */
@Slf4j
public class AtomicStampedReferenceTest {

    @Test
    public void test(){
        String initialRef   = null;
        int    initialStamp = 0;

        AtomicStampedReference<String> atomicStampedReference =
                new AtomicStampedReference<String>(
                        initialRef, initialStamp
                );
        String reference = atomicStampedReference.getReference();
        int stamp = atomicStampedReference.getStamp();

        boolean b = atomicStampedReference.compareAndSet(initialRef, "11", initialStamp, 1);

        log.debug("reference:{},stamp:{},b:{}",reference,stamp,b);
    }
}
