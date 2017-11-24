package com.workproject.simplewebapp.controller;

import java.util.Arrays;
import java.util.List;
//import java.util.Locale.Category;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.workproject.simplewebapp.control.NotesService;
import com.workproject.simplewebapp.entity.AuthorEntity;
import com.workproject.simplewebapp.entity.Category;
//import com.workproject.simplewebapp.entity.NoteEntity;

@Model
public class NotesListSetupService {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject 
	private NotesService notesService;
	
	@Inject
	private List<AuthorEntity> authorEntities;
	
	@Produces
	@Named
	private AuthorEntity newAuthorEntity;
	
	@PostConstruct
	public void initNewAuthorEntity(){
		newAuthorEntity = new AuthorEntity();
	}
	
	public String createNoteList(){
		notesService.createNoteList(authorEntities);
		return "Notes";
	}
	
	public String restart(){
		notesService.doCleanup();				
		return "/index";
	}
	
	public void addNewNotes() throws Exception{
		try{
			notesService.createAuthorEntity(newAuthorEntity);
			
			final FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Done", "Author added");
			facesContext.addMessage(null, m);
			initNewAuthorEntity();			
		} catch (Exception e){
			final String errorMessage = getRootErrorMessage(e);
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Error while saving data");
			facesContext.addMessage(null, m);
		}
	}

	private String getRootErrorMessage(Exception e) {
		// Default to general error message that registration failed.
		String errorMessage = "Registration failed. See server log for more	information";
		if (e == null) {
		// This shouldn’t happen, but return the default messages
			return errorMessage;
		}
		// Start with the exception and recurse to find the root cause
		Throwable t = e;
		while (t != null) {
			// Get the message from the Throwable class instance
			errorMessage = t.getLocalizedMessage();
			t = t.getCause();
		}
		// This is the root cause message
		return errorMessage;
		}
		
		public List<Category> getCategories(){
			return Arrays.asList(Category.values());
		}
}
