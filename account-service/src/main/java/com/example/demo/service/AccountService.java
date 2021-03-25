package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.AccountModel;

public interface AccountService {

	public AccountDto createAccount(AccountDto accountDto);

	public AccountDto findByAccountId(String accountId);

	public AccountDto findByEmail(String email);

	public Integer deleteByAccountId(String accountId);
	
	public AccountDto updateAccount(String accountId,AccountDto accountDto);
	
	public List<AccountModel> getAccountByFirstName(String firstName);

}
