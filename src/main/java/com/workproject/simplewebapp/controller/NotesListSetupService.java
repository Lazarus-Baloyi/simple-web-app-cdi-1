package com.workproject.simplewebapp.controller;

import java.util.Arrays;
import java.util.List;
import java.io.File;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.workproject.simplewebapp.control.NotesService;
import com.workproject.simplewebapp.entity.Author;
import com.workproject.simplewebapp.entity.Category;
//import com.workproject.simplewebapp.entity.NoteEntity;
import com.workproject.simplewebapp.entity.Note;

@Model
public class NotesListSetupService {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject 
	private NotesService notesService;
	
	@Inject
	private List<Author> authors;

	@Inject
	private List<Note> notes;
	
	@Produces
	@Named
	private Author newAuthor;
	
	@PostConstruct
	public void initNewAuthor(){
		newAuthor = new Author();
	}
	
	//File file = new File("C:\\notes.xml");

	
	public String createNoteList(){
		notesService.createNoteList(authors);
		return "Notes";
	}
	
	public void unmarshallXML(){
		
		try {
			JAXBContext context = JAXBContext.newInstance(Author.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File("\\main\resources\notes.xml");
			
			newAuthor = (Author)unmarshaller.unmarshal(file);
			notes = newAuthor.getNotes();
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void addNewNotes() throws Exception{
		try{
			notesService.createAuthor(newAuthor);
			
			final FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Done", "Author added");
			facesContext.addMessage(null, m);
			initNewAuthor();			
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
		
	public String restart(){
			notesService.doCleanup();				
			return "/index";
	}

		
}
