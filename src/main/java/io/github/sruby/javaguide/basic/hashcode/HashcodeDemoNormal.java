package io.github.sruby.javaguide.basic.hashcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * hashcode
 *
 * @author sruby on 2020-6-25 11:47
 */
@Getter
@Setter
@AllArgsConstructor
public class HashcodeDemoNormal {
    private String fieldOne;
    private String fieldTwo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashcodeDemoNormal that = (HashcodeDemoNormal) o;
        return Objects.equals(fieldOne, that.fieldOne) &&
                Objects.equals(fieldTwo, that.fieldTwo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldOne, fieldTwo);
    }
}
