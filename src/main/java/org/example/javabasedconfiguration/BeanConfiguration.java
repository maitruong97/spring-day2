package org.example.javabasedconfiguration;

import org.example.pojobeans.AccountRepository;
import org.example.pojobeans.AccountRepositoryImpl;
import org.example.pojobeans.AccountService;
import org.example.pojobeans.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public AccountService accountService() {
        AccountServiceImpl bean = new AccountServiceImpl();
        bean.setAccountRepository(accountDao());
        return bean;
    }
    @Bean
    public AccountRepository accountDao() {
        AccountRepositoryImpl bean = new AccountRepositoryImpl();
        return bean;
    }

}
