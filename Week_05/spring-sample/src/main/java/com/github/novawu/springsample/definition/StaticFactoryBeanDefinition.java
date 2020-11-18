package com.github.novawu.springsample.definition;

import com.github.novawu.springsample.definition.bean.People;
import com.github.novawu.springsample.definition.bean.PeopleFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StaticFactoryBeanDefinition {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册当前类
        applicationContext.register(PeopleFactory.class);
        //启动应用上下文
        applicationContext.refresh();

        People bean = PeopleFactory.createBean();
        System.out.println(bean.toString());
    }
}
