package com.jdc.shout.service;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.jdc.shout.entity.Account;

@Local
@Stateless
public interface AccountService {
	void signUp(Account account);
	Account findById(String loginId);
}
