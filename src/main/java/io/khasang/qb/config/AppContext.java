package io.khasang.qb.config;

import io.khasang.qb.dao.AnswersDao;
import io.khasang.qb.dao.QuestionDao;
import io.khasang.qb.dao.RolesDao;
import io.khasang.qb.dao.UsersDao;
import io.khasang.qb.dao.impl.AnswersDaoImpl;
import io.khasang.qb.dao.impl.QuestionDaoImpl;
import io.khasang.qb.dao.impl.RolesDaoImpl;
import io.khasang.qb.dao.impl.UsersDaoImpl;
import io.khasang.qb.entity.Answer;
import io.khasang.qb.logic.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
@PropertySource(value = {"classpath:auth.properties"})
public class AppContext {

    @Autowired
    HibernateConfig hibernateConfig;

    @Autowired
    Environment environment;

    @Bean
    public AnswersDao answersDao() {
        return new AnswersDaoImpl();
    }

    @Bean
    public QuestionDao questionsDao() {
        return new QuestionDaoImpl();
    }

    @Bean
    public RolesDao rolesDao() {
        return new RolesDaoImpl();
    }

    @Bean
    public Answer answers() {
        return new Answer();
    }

    @Bean
    public UsersDao usersDao() {
        return new UsersDaoImpl();
    }

    @Bean
    public Authentication authentication() {
        return new Authentication();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
        jdbcImpl.setDataSource(hibernateConfig.dataSource());
        jdbcImpl.setUsersByUsernameQuery(environment.getRequiredProperty("usersByQuery"));
        jdbcImpl.setAuthoritiesByUsernameQuery(environment.getRequiredProperty("rolesByQuery"));
        return jdbcImpl;
    }
}