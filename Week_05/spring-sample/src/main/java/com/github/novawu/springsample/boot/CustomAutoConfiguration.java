package com.github.novawu.springsample.boot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Klass.class,School.class,Student.class})
public class CustomAutoConfiguration {
}
