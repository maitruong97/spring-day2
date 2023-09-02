package org.example.pojobeans;

import java.util.HashMap;
import java.util.Map;

public class AccountRepositoryImpl implements AccountRepository{
    private Map<Long,Account> accountMap = new HashMap<>();
    {
        Account account1 = new Account();
        account1.setId(1L);
        account1.setOwnerName("maitruong");
        account1.setBalance(10.0);

        Account account2 = new Account();
        account2.setId(2L);
        account2.setOwnerName("nhinhi");
        account2.setBalance(20.0);

        accountMap.put(account1.getId(),account1);
        accountMap.put(account2.getId(),account2);

    }
    @Override
    public void insert(Account account) {
        accountMap.put(account.getId(), account);
    }

    @Override
    public void update(Account account) {
        accountMap.put(account.getId(), account);
    }

    @Override
    public Account find(long accountId) {
        return accountMap.get(accountId);
    }
}
