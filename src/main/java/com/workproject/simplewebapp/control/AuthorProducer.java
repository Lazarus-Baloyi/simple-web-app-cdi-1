package com.workproject.simplewebapp.control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.workproject.simplewebapp.entity.Author;

@javax.enterprise.context.RequestScoped
public class AuthorProducer {

	@Inject
	private AuthorDAO authorEntityDao;
	private List<Author> authors;

	@PostConstruct
	public void retrieveAllAuthorEntities(){
		authors = authorEntityDao.findAll();
	}
	
	@Produces
	@Named
	public List<Author> getAuthorEntities(){
		return authors;
	}
	
	public void onListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Author member){
		retrieveAllAuthorEntities();
	}
}
