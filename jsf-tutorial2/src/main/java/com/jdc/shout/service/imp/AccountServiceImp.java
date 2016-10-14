package com.jdc.shout.service.imp;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.jdc.shout.entity.Account;
import com.jdc.shout.repository.AccountRepository;
import com.jdc.shout.service.AccountService;

@Local
@Stateless
public class AccountServiceImp implements AccountService {

	@Inject
	private AccountRepository repo;
	
	@Override
	public void signUp(Account account) {
		repo.add(account);
	}

	@Override
	public Account findById(String loginId) {
		return repo.findById(loginId);
	}

}
