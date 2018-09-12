package com.cmcm.maven;

import java.lang.annotation.*;

/**
 * @author Spontaneously
 * @time 2018-09-09 下午7:27
 */
@Target(ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface Demo {

    /**
     * 请求示例
     * @return
     */
    String param() default "";

    /**
     * 返回成功结果示例
     * @return
     */
    String error() default "";
}
