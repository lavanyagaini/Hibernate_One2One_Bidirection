package e1_onetoone_hibernate_crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import onetoone_bidirection2_dto.Pancard;

public class PanCardCrud {
	public EntityManager getmanager() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("Lavanya");
		EntityManager manager=factory.createEntityManager();
		return manager;
	}
	
	public void savePanCard(Pancard card) {
		
		
		EntityManager manager=getmanager();
		EntityTransaction transaction=manager.getTransaction();
		
		transaction.begin();
		manager.persist(card);
		transaction.commit();
		
	}
	
	public void updateCard(int id,Pancard card) {
		EntityManager manager=getmanager();
	    Pancard dbcard=manager.find(Pancard.class, id);
		
	    if(dbcard!=null) {
	    	
	    dbcard.setName(card.getName());
	    dbcard.setPhone(card.getPhone());
	    EntityTransaction transaction=manager.getTransaction();
	    transaction.begin();
	    manager.merge(dbcard);
	    transaction.commit();
	    
	    }
	}
	    
	    public void deleteCard(int id) {
	    EntityManager manager=getmanager();
	    
	    Pancard dbcard=manager.find(Pancard.class, id);
	    
	    if(dbcard!=null) {
	    EntityTransaction transaction=manager.getTransaction();
	    transaction.begin();
	    manager.remove(dbcard);
	    transaction.commit();
	   
	    }
	    else
	    	System.out.println("your id is not exist to delete");
	}
	    
	    
	    public void getPanCardById(int id) {
	    	 EntityManager manager=getmanager();
	    	 Pancard dbcard=manager.find(Pancard.class, id);
	    	 if(dbcard!=null) {
	    		 System.out.println(dbcard);
	    	 }
	    	 else {
	    		 System.out.println("no user found based on" +id);
	    	 }
	    	
	    }
}


