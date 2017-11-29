package com.workproject.simplewebapp.control;

import javax.ejb.Stateless;

import com.workproject.simplewebapp.entity.Author;

@Stateless
public class AuthorDAO extends AbstractDao<Author> {
	public AuthorDAO(){
		super(Author.class);
	}
}
