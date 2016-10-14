package com.jdc.shout.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-10-14T11:20:34.041+0630")
@StaticMetamodel(Post.class)
public class Post_ {
	public static volatile SingularAttribute<Post, Integer> id;
	public static volatile SingularAttribute<Post, String> title;
	public static volatile SingularAttribute<Post, String> description;
	public static volatile SingularAttribute<Post, String> image;
	public static volatile SingularAttribute<Post, Account> owner;
	public static volatile SingularAttribute<Post, Date> creation;
	public static volatile SetAttribute<Post, Category> categories;
	public static volatile SetAttribute<Post, Smile> smiles;
}
