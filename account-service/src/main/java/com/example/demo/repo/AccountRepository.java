package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AccountModel;
@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Integer> {
	@Query
	public AccountModel findByAccountId(String accountId);
	@Query
	public AccountModel findByEmail(String email);
	@Query
	public Integer deleteByAccountId(String accountId);
	@Query
	public List<AccountModel> findByFirstName(String firstName);
	

}
