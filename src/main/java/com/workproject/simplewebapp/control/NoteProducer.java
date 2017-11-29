package com.workproject.simplewebapp.control;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.workproject.simplewebapp.entity.Note;

public class NoteProducer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private NoteDAO noteEntityDao; 
	
	private List<Note> notes;
	
	@PostConstruct
	public void retrieveAllNoteEntities(){
		notes = noteEntityDao.findAll();
	}
	
	@Produces
	@Named
	public List<Note> getNoteEntities(){
		return notes;
	}
	
	public void onMemberListChanged(/*@Observes(notifyObserver = Reception.IF_EXISTS)*/ final Note member){
		retrieveAllNoteEntities();
	}
}
