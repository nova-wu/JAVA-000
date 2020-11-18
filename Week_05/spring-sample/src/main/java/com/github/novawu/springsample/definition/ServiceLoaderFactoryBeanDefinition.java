package com.github.novawu.springsample.definition;

import com.github.novawu.springsample.definition.bean.DefaultPeopleFactory;
import com.github.novawu.springsample.definition.bean.PeopleServiceLoaderFactoryBean;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceLoaderFactoryBeanDefinition {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册当前类
        applicationContext.register(PeopleServiceLoaderFactoryBean.class);
        //启动应用上下文
        applicationContext.refresh();

        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        ServiceLoader<DefaultPeopleFactory> bean = autowireCapableBeanFactory.getBean(ServiceLoader.class);

        Iterator<DefaultPeopleFactory> iterator = bean.iterator();
        while (iterator.hasNext()) {
            DefaultPeopleFactory next = iterator.next();
            System.out.println(next.createPeople().toString());
        }

    }
}
