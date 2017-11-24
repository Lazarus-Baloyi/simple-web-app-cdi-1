package com.workproject.simplewebapp.control;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.workproject.simplewebapp.entity.NoteEntity;

public class NoteEntityProducer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private NoteEntityDAO noteEntityDao; 
	
	private List<NoteEntity> noteEntities;
	
	@PostConstruct
	public void retrieveAllNoteEntities(){
		noteEntities = noteEntityDao.findAll();
	}
	
	@Produces
	@Named
	public List<NoteEntity> getNoteEntities(){
		return noteEntities;
	}
	
	public void onMemberListChanged(/*@Observes(notifyObserver = Reception.IF_EXISTS)*/ final NoteEntity member){
		retrieveAllNoteEntities();
	}
}
