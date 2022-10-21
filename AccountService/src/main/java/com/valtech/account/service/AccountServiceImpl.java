package com.valtech.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.account.entity.Account;
import com.valtech.account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	
	@Autowired
	private AccountRepository accountRepository;
	
	
	@Override
	public Account createAccount(Account acc){
		return accountRepository.save(acc);
		
	}
	
	
	@Override
	public Account updateAccount(Account acc){
		return accountRepository.save(acc);
		
	}
	
	@Override
	public Account getAccount(long id){
		return accountRepository.findById(id).get();
			
	}
	
	
	@Override
	public List<Account> getAllAccounts(){
		return accountRepository.findAll();
	}

	@Override
	public Account createSavingsAccount(double balance) {
		Account acc=new Account("SB",balance);
		return accountRepository.save(acc);
	}

	@Override
	public Account createCurrentAccount(double balance) {
		Account acc=new Account("CA",balance);
		return accountRepository.save(acc);
		
	}
}
