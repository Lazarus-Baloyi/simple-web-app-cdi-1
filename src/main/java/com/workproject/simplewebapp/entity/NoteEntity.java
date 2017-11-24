package com.workproject.simplewebapp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: NoteEntity
 *
 */
@Entity
@Table(name="note_table")
public class NoteEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private String Title;
	private String Description;

	private static final long serialVersionUID = 1L;
	@Enumerated(EnumType.STRING)
	private Category categoryObj;
	@Temporal(TemporalType.TIMESTAMP)
	private Date DateCreated;
	
	@ManyToOne
	@JoinColumn(name="authorentity_id")
	private AuthorEntity authorEntity;
	
	public AuthorEntity getAuthorEntity() {
		return authorEntity;
	}
	public void setAuthorEntity(AuthorEntity authorEntity) {
		this.authorEntity = authorEntity;
	}
	public NoteEntity() {
		super();
	}   
	public String getTitle() {
		return this.Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}   
	public Category getCategoryObj() {
		return this.categoryObj;
	}

	public void setCategoryObj(Category categoryObj) {
		this.categoryObj = categoryObj;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}   
	public Date getCreated() {
		return this.DateCreated;
	}

	public void setCreated(Date Created) {
		this.DateCreated = Created;
	}   
   
}
