package com.jackie.testOne.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/8/31
 */

@Configuration
@ImportResource(locations= {"classpath:aop-spring.xml"})
public class Config {
}
