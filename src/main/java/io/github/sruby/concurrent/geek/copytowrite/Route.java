package io.github.sruby.concurrent.geek.copytowrite;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * @description: Route with Immutability
 * @author: sruby
 * @create: 2020-06-17 16:56
 */
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@SuperBuilder
public class Route {
    final private String ip;
    final private Integer port;
    final private String statue;
}
