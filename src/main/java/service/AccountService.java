package service;

import entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import repository.AccountRepository;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    private JpaTransactionManager transactionManager;

    // Dependency injection via constructor
    public AccountService(JpaTransactionManager transactionManager){
        this.transactionManager = transactionManager;
    }
    public AccountService(){
    }
}
