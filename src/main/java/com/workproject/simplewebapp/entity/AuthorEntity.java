package com.workproject.simplewebapp.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * Entity implementation class for Entity: AuthorEntity
 *
 */
@Entity

public class AuthorEntity implements Serializable {

	private String AuthorName;
	private String AuthorSurname;
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy="authorEntity", fetch=FetchType.EAGER)
	private List<NoteEntity> notes;

	public String getAuthorName() {
		return AuthorName;
	}

	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}

	public String getAuthorSurname() {
		return AuthorSurname;
	}

	public void setAuthorSurname(String authorSurname) {
		AuthorSurname = authorSurname;
	}
	
//	public AuthorEntity() {
//		super();
//	}
//	
//	public String getAuthorName() {
//		return this.AuthorName;
//	}
//
//	public void setAuthorName(String AuthorName) {
//		this.AuthorName = AuthorName;
//	}   
//	public String getAuthorSurname() {
//		return this.AuthorSurname;
//	}
//
//	public void setAuthorSurname(String AuthorSurname) {
//		this.AuthorSurname = AuthorSurname;
//	}
}
