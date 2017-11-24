package com.workproject.simplewebapp.control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.workproject.simplewebapp.entity.AuthorEntity;

@javax.enterprise.context.RequestScoped
public class AuthorEntityProducer {

	@Inject
	private AuthorEntityDAO authorEntityDao;
	private List<AuthorEntity> authorEntities;

	@PostConstruct
	public void retrieveAllAuthorEntities(){
		authorEntities = authorEntityDao.findAll();
	}
	
	@Produces
	@Named
	public List<AuthorEntity> getAuthorEntities(){
		return authorEntities;
	}
	
	public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final AuthorEntity member){
		retrieveAllAuthorEntities();
	}
}
