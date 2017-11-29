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
	private Event<Author> authorEntityEventSrc;
	
	@Inject
	private Event<Note> noteEntityEventSrc;
	
	@Inject
	private AuthorDAO authorDao;
	
	@Inject
	private NoteDAO noteEntityDao;
	
	public void createAuthor(Author author) throws Exception{
		log.info("Creating Authors");
		authorDao.persist(author);
		authorEntityEventSrc.fire(author);
	}
	
	public void createNoteList(List<Author> authors){
		for(Author author: authors){
			for(int ii=0; ii<authors.size(); ii++){
				final Note note = new Note();
				note.setAuthor(author);
				noteEntityDao.persist(note);
			}
		}
	}
	
	public void updateNoteDescription(long noteID, String description){
		final Note note = noteEntityDao.find(noteID);
		note.setDescription(description);
		noteEntityDao.persist(note);
		noteEntityEventSrc.fire(note);
	}
	
	public void doCleanup(){
		noteEntityDao.deleteAll();
		authorDao.deleteAll();
	}
	
	
}
