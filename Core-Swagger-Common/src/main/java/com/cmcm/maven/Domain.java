package com.cmcm.maven;

import java.lang.annotation.*;

/**
 * 定义域名
 * @author Spontaneously
 * @time 2018-09-09 下午7:27
 */
@Target(ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface Domain {
}
