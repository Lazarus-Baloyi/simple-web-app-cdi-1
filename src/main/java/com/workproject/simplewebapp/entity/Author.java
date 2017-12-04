package com.workproject.simplewebapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
/**
 * Entity implementation class for Entity: AuthorEntity
 *
 */
@Entity
@XmlRootElement
public class Author implements Serializable {


	public Author(String authorName, String authorSurname, Long id,
			List<Note> notes) {
		super();
		this.name = authorName;
		this.surname = authorSurname;
		this.id = id;
		this.notes = notes;
	}

	public Author(){
		
	}
	
	
	@Column(name = "authorname")
	@XmlElement(name= "name")
	private String name;
	
	
	@Column(name = "authorsurname")
	@XmlElement(name= "surname")
	private String surname;
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@OneToMany(mappedBy="author", fetch=FetchType.EAGER)
	private List<Note> notes;

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public String getAuthorName() {
		return name;
	}

	public void setAuthorName(String authorName) {
		name = authorName;
	}

	public String getAuthorSurname() {
		return surname;
	}

	public void setAuthorSurname(String authorSurname) {
		surname = authorSurname;
	}
	
}
