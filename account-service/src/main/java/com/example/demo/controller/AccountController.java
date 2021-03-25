package com.example.demo.controller;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.AccountDto;
import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.exception.EmailNotFoundException;
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
	public ResponseEntity<AccountResponseModel> createAccount(@RequestBody AccountRequestModel accRequestModel) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AccountDto accountDto = mapper.map(accRequestModel, AccountDto.class);
		accountDto.setAccountId(UUID.randomUUID().toString());
		AccountDto response = accountService.createAccount(accountDto);
		AccountResponseModel model = mapper.map(response, AccountResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(model);

	}

	@GetMapping("/accounts/{accountId}")
	public ResponseEntity<AccountResponseModel> getAccountByAccountId(@PathVariable("accountId") String accountId) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AccountDto dto = accountService.findByAccountId(accountId);
		if (dto == null) {
			throw new AccountNotFoundException("no such account with id: " + accountId);
		}
		AccountResponseModel response = mapper.map(dto, AccountResponseModel.class);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/accounts/email/{email}")
	public ResponseEntity<AccountDto> findAccountByEmail(@PathVariable("email") String email) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AccountDto dto = accountService.findByEmail(email);
		if (dto == null) {
			throw new EmailNotFoundException("email not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}

	@DeleteMapping("/accounts/{accountId}")
	public ResponseEntity<Integer> deleteAccount(@PathVariable("accountId") String accountId) {

		Integer result = accountService.deleteByAccountId(accountId);
		if (result < 1) {
			throw new AccountNotFoundException("no account found.");
		}
		return ResponseEntity.ok(result);

	}

	@PutMapping("/accounts/{accountid}")
	public ResponseEntity<AccountDto> updateAccount(@PathVariable("accountid") String accountId,
			@RequestBody AccountRequestModel requestModel)
	{
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		AccountDto dto= mapper.map(requestModel, AccountDto.class);
		AccountDto d= accountService.updateAccount(accountId, dto);
		return ResponseEntity.status(HttpStatus.OK).body(d);
	}
}
