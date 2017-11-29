package com.workproject.simplewebapp.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.workproject.simplewebapp.control.NotesService;


@Named
@javax.faces.view.ViewScoped
public class ListUpdateService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Logger logger;
	
	@Inject
	private NotesService notesService;
	
	@Inject
	private FacesContext facesContext;
	
	public void updateNote(long noteID, String description){
		logger.info("Updating description ");
		
		if(description.length()>50){
			final FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Description too long!", "Description updated");
			facesContext.addMessage(null, m);
			return;
			//logger.info("Description updated.");
		}
		
		notesService.updateNoteDescription(noteID, description);
		
		final FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Updated description", "Update successful");
		facesContext.addMessage(null, m);
		logger.info("Description updated.");
		
	}
}