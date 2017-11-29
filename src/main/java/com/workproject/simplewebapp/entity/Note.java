package com.workproject.simplewebapp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

/**
 * Entity implementation class for Entity: NoteEntity
 *
 */
@Entity
@Table(name="note_table")
public class Note implements Serializable {
	
	public Note(Long id, String title, String description,
			Category categoryObj, Date dateCreated, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.categoryObj = categoryObj;
		this.dateCreated = dateCreated;
		this.author = author;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	@XmlElement(name = "title")
	private String title;
	
	@Column(name = "description")
	@XmlElement(name = "description")
	private String description;

	private static final long serialVersionUID = 1L;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "categoryobj")
	private Category categoryObj;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datecreated")
	@XmlElement(name = "created")
	private Date dateCreated;
	
	@ManyToOne
	@JoinColumn(name="authorentity_id")
	private Author author;
	
	private boolean deleted;
	
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Note() {
		super();
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public Category getCategoryObj() {
		return this.categoryObj;
	}

	public void setCategoryObj(Category categoryObj) {
		this.categoryObj = categoryObj;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String Description) {
		this.description = Description;
	}   
	public Date getCreated() {
		return this.dateCreated;
	}

	public void setCreated(Date created) {
		this.dateCreated = created;
	}   
   
}
