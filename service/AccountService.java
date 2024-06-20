package com.myapp.service;

import com.myapp.models.Account;
import com.myapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccountById(String id) {
        return accountRepository.findById(id).orElse(null);
    }
}
