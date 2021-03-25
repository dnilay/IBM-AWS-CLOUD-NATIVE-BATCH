package com.example.demo.service;

import com.example.demo.dto.AccountDto;

public interface AccountService {

	public AccountDto createAccount(AccountDto accountDto);

	public AccountDto findByAccountId(String accountId);

	public AccountDto findByEmail(String email);

	public Integer deleteByAccountId(String accountId);
	
	public AccountDto updateAccount(String accountId,AccountDto accountDto);

}
