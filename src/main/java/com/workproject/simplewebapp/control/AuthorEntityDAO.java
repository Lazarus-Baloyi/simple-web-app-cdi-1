package com.workproject.simplewebapp.control;

import javax.ejb.Stateless;

import com.workproject.simplewebapp.entity.AuthorEntity;

@Stateless
public class AuthorEntityDAO extends AbstractDao<AuthorEntity> {
	public AuthorEntityDAO(){
		super(AuthorEntity.class);
	}
}
