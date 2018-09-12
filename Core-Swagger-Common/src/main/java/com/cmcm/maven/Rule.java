package com.cmcm.maven;

import java.lang.annotation.*;

/**
 * @author Spontaneously
 * @time 2018-09-09 下午7:27
 */
@Target(ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface Rule {

    /**
     * 规则名称
     * @return
     */
    String name() default "";

    /**
     * 数据类型
     * @return
     */
    String type() default "string";

    String desc() default "";
}
