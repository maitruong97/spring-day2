package main;

import configuration.JPAConfig;
import entity.AccountEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.AccountRepository;
import service.AccountService;

import java.util.Date;

public class MainTestTransaction {

    public static void main(String[] args) throws Exception {
//         AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
//         AccountRepository accountRepository = applicationContext.getBean("accountRepository", AccountRepository.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
         AccountService accountService = context.getBean("accountService", AccountService.class);
         accountService.transferMoney(1,2,100);
    }
}
