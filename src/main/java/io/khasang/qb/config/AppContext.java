package io.khasang.qb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

    @Autowired
    HibernateConfig hibernateConfig;
}