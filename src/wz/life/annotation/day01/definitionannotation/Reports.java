package wz.life.annotation.day01.definitionannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Reports {
    Report[] value();
}
