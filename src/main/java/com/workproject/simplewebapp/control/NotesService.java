package com.workproject.simplewebapp.control;


import java.util.List;
import java.util.logging.Logger;

import com.workproject.simplewebapp.entity.*;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;


@Stateless
public class NotesService {
	@Inject
	private Logger log;
	
	@Inject 
	private Event<AuthorEntity> authorEntityEventSrc;
	
	@Inject
	private Event<NoteEntity> noteEntityEventSrc;
	
	@Inject
	private AuthorEntityDAO authorEntityDao;
	
	@Inject
	private NoteEntityDAO noteEntityDao;
	
	public void createAuthorEntity(AuthorEntity authorEntity) throws Exception{
		log.info("Creating notes");
		authorEntityDao.persist(authorEntity);
		authorEntityEventSrc.fire(authorEntity);
		
	}
	
	public void createNoteList(List<AuthorEntity> authorEntities){
		for(AuthorEntity author: authorEntities){
			for(int ii=0; ii<authorEntities.size(); ii++){
				final NoteEntity note = new NoteEntity();
				note.setAuthorEntity(author);
				noteEntityDao.persist(note);
			}
		}
	}
	
	public void updateNoteDescription(long noteID, String description){
		final NoteEntity note = noteEntityDao.find(noteID);
		note.setDescription(description);
		noteEntityDao.persist(note);
		noteEntityEventSrc.fire(note);
	}
	
	public void doCleanup(){
		noteEntityDao.deleteAll();
		authorEntityDao.deleteAll();
	}
	
	
}
