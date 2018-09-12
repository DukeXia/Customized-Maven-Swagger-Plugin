package com.cmcm.maven;

import java.lang.annotation.*;

/**
 * 权限信息描述
 * @author Spontaneously
 * @time 2018-09-09 下午7:27
 */
@Target(ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {

    /**
     * 是否检测IP
     * @return
     */
    boolean checkIp() default false;
}
