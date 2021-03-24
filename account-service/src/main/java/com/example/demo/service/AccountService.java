package com.example.demo.service;

import com.example.demo.dto.AccountDto;

public interface AccountService {
	
	public AccountDto createAccount(AccountDto accountDto);
	public AccountDto findByAccountId(String accountId);

}
