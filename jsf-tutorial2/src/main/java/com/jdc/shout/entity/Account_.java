package com.jdc.shout.entity;

import com.jdc.shout.entity.Account.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-06T15:02:30.047+0630")
@StaticMetamodel(Account.class)
public class Account_ {
	public static volatile SingularAttribute<Account, String> loginId;
	public static volatile SingularAttribute<Account, String> name;
	public static volatile SingularAttribute<Account, String> email;
	public static volatile SingularAttribute<Account, String> phone;
	public static volatile SingularAttribute<Account, String> password;
	public static volatile SingularAttribute<Account, Role> role;
}
