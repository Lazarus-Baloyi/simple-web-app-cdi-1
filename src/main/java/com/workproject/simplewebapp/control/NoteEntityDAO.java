package com.workproject.simplewebapp.control;

import javax.ejb.Stateless;

import com.workproject.simplewebapp.entity.NoteEntity;

@Stateless
public class NoteEntityDAO extends AbstractDao<NoteEntity> {
	public NoteEntityDAO(){
		super(NoteEntity.class);
	}
}
