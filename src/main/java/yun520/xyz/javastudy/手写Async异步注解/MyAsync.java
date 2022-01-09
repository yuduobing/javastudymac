package yun520.xyz.javastudy.手写Async异步注解;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAsync {
    String value() default "";
}