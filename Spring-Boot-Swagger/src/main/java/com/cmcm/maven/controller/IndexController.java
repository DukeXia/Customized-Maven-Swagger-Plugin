package com.cmcm.maven.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Spontaneously
 * @time 2018-09-10 上午11:27
 */
@RestController
@Api(value = "IndexController", description = "测试Swagger2使用")
public class IndexController {

    @ApiOperation(value = "测试方法", notes = "返回方法的入参", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping(value = "/index/{word}")
    public String index(@RequestParam(value = "word") String word) {
        return word;
    }
}
