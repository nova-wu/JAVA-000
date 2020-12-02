package org.nova.wu.javacamp.dynamicdatasource.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.nova.wu.javacamp.dynamicdatasource.routing.RoutingDataSourceContext;
import org.nova.wu.javacamp.dynamicdatasource.annotation.RoutingWith;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RoutingAspect {
    @Around("@annotation(routingWith)")
    public Object routingWithDataSource(ProceedingJoinPoint joinPoint, RoutingWith routingWith) throws Throwable {
        String key = routingWith.value();
        try (RoutingDataSourceContext ctx = new RoutingDataSourceContext(key)) {
            return joinPoint.proceed();
        }
    }
}
