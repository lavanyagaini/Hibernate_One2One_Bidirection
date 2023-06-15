package e1_onetoone_hibernate_crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoone_bidirection2_dto.Pancard;
import onetoone_bidirection2_dto.Person;




public class PersonCrud {

	public EntityManager getmanager() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("Lavanya");
		EntityManager manager=factory.createEntityManager();
		return manager;
	}
	
	public void savePerson(Person person,int cardid) {
		EntityManager manager=getmanager();
	Pancard card=manager.find(Pancard.class, cardid);
		if(card!=null) {
			//person.setCard(card);
			person.setPancard(card);
			card.setPerson(person);
			
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			manager.persist(person);
			manager.merge(card);
			transaction.commit();
		}
		
	}
	public void updatePerson(int id,Person person) {
		EntityManager manager=getmanager();
		Person dbperson=manager.find(Person.class, id);
		if(dbperson!=null) {
			dbperson.setName(person.getName());
			dbperson.setPhone(person.getPhone());

			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			manager.merge(dbperson);
			transaction.commit();
		}
		
	}
	
	public void deleteperson(int id) {
	
		EntityManager manager=getmanager();
		Person dbperson=manager.find(Person.class, id);
		
		if(dbperson!=null) {
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			manager.remove(dbperson);
			transaction.commit();
			
		}
		else {
			System.out.println("your id is not exist to delete");
		}
}
	
	public void fetchbyId(int id) {
		EntityManager manager=getmanager();
		Person dbperson=manager.find(Person.class, id);
		
		if(dbperson!=null) {
			System.out.println(dbperson);
		}
		else {
			System.out.println("existed data is not there");
		}
	}
	
	
}