package com.cmcm.maven;

import java.lang.annotation.*;

/**
 * 定义api方法说明文档
 *
 * @author Spontaneously
 * @time 2018-09-09 下午7:26
 */
@Target(ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface Api {

    String author() default "";

    String createTime() default "";

    String name() default "";

    String desc() default "";

    Rule[] params();
}
