package br.com.jops425.aula2932jpa.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("br.com.jops425.aulas2932jpa");;
	
	public static EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
	
}
