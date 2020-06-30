package io.github.sruby.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.sruby.annotation.demo.Person;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test
 */
@Slf4j
public class ObjectMapperTest {
    private ObjectMapper objectMapper = new ObjectMapper();


    @SneakyThrows
    @Test
    void readValue() {
        Person person = objectMapper.readValue("{\"name\":\"test\"}", Person.class);
        log.debug("person:{}",person);
    }
}
