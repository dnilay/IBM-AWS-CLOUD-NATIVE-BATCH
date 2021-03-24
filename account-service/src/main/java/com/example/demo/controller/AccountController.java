package com.example.demo.controller;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountDto;
import com.example.demo.service.AccountService;
import com.example.demo.shared.AccountRequestModel;
import com.example.demo.shared.AccountResponseModel;

@RestController
@RequestMapping("/api")
public class AccountController {
	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}


	@PostMapping("/accounts")
	public ResponseEntity<AccountResponseModel> createAccount(@RequestBody AccountRequestModel accRequestModel)
	{
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AccountDto accountDto=mapper.map(accRequestModel, AccountDto.class);
		accountDto.setAccountId(UUID.randomUUID().toString());
		AccountDto response= accountService.createAccount(accountDto);
		AccountResponseModel model=mapper.map(response, AccountResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(model);
		
	}

}
