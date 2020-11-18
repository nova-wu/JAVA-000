package com.github.novawu.springsample.definition;

import com.github.novawu.springsample.definition.bean.PeopleFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * FactoryBean实例化
 */
public class FactoryBeanDefinition {

    public static void main(String[] args) throws Exception {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册当前类
        applicationContext.register(PeopleFactoryBean.class);
        //启动应用上下文
        applicationContext.refresh();

        PeopleFactoryBean bean = applicationContext.getBean(PeopleFactoryBean.class);
        System.out.println(bean.getObject().toString());
    }
}
