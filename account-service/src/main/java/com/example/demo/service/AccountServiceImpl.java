package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AccountDto;
import com.example.demo.exception.EmailNotFoundException;
import com.example.demo.model.AccountModel;
import com.example.demo.repo.AccountRepository;
@Service

public class AccountServiceImpl implements AccountService {
	private AccountRepository accountRepository;

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	
	public AccountDto createAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AccountModel model = mapper.map(accountDto, AccountModel.class);
		accountRepository.save(model);
		AccountDto dto= mapper.map(model, AccountDto.class);
		return dto;
	}

	@Override

	public AccountDto findByAccountId(String accountId) {
		// TODO Auto-generated method stub
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AccountModel model=accountRepository.findByAccountId(accountId);
		if(model==null)
		{
			return null;
		}
		else
		{
			AccountDto dto=mapper.map(model, AccountDto.class);
			return dto;
		}
		
	}

	@Override

	public AccountDto findByEmail(String email) {
		// TODO Auto-generated method stub
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AccountModel model=accountRepository.findByEmail(email);
		System.out.println(model);
	
		
			return (mapper.map(model, AccountDto.class));
		
		
		 
	}

	@Override
	@Transactional
	public Integer deleteByAccountId(String accountId) {
		// TODO Auto-generated method stub
		
		return accountRepository.deleteByAccountId(accountId);
	}
	
}
