package com.github.novawu.springsample.definition.bean;

import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class PeopleServiceLoaderFactoryBean extends ServiceLoaderFactoryBean {

    @PostConstruct
    public void setServiceType() {
        super.setServiceType(DefaultPeopleFactory.class);
    }
}
