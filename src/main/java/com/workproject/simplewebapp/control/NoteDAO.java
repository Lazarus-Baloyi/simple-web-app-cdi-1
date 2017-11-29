package com.workproject.simplewebapp.control;

import javax.ejb.Stateless;

import com.workproject.simplewebapp.entity.Note;

@Stateless
public class NoteDAO extends AbstractDao<Note> {
	public NoteDAO(){
		super(Note.class);
	}
}
