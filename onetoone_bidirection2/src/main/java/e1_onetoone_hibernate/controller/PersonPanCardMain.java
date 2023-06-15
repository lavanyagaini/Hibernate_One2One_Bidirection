package e1_onetoone_hibernate.controller;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




import e1_onetoone_hibernate_crud.PanCardCrud;
import e1_onetoone_hibernate_crud.PersonCrud;
import onetoone_bidirection2_dto.Pancard;
import onetoone_bidirection2_dto.Person;

public class PersonPanCardMain {

	public static void main(String[]args) {
		
		
		PanCardCrud crud=new PanCardCrud();
		PersonCrud crud1=new PersonCrud();
		Scanner sc=new Scanner(System.in);
		boolean check=true;
		do {
			System.out.println("choose option \n1.savepanCard \n2.save person \n3.update pancard \n4.update person");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:{
				System.out.println("enter your name");
				String name=sc.next();
				System.out.println("enter your address");
				String address=sc.next();
				System.out.println("enter your phone");
				long phone=sc.nextLong();
				System.out.println("enter your pannumber");
				String panNum=sc.next();
				
				
				Pancard card=new Pancard ();
				card.setName(name);
				card.setAddress(address);
				card.setPhone(phone);
				card.setPanNum(panNum);
				crud.savePanCard(card);
				
				
			}
			break;
			
			case 2:{
				System.out.println("enter your name");
				String name=sc.next();
				System.out.println("enter your phone");
				long phone=sc.nextLong();
				System.out.println("enter your address");
				String address=sc.next();
				
				
				
				System.out.println("enter your panid");
				int cardid=sc.nextInt();
				Person person=new Person();
				person.setName(name);
				person.setPhone(phone);
				person.setAddress(address);
				crud1.savePerson(person,cardid);
				
				
			}break;
			case 3:{
				System.out.println("enter your name");
				String name=sc.next();
				System.out.println("enter your id");
				int id=sc.nextInt();
				System.out.println("enter your phone");
				long phone=sc.nextLong();
				
				Pancard card=new Pancard();
				card.setName(name);
				card.setPhone(phone);
				crud.updateCard(id, card);
				
			}break;
			
			case 4:{
				System.out.println("enter your name");
				String name=sc.next();
				System.out.println("enter your id");
				int id=sc.nextInt();
				System.out.println("enter your phone");
				long phone=sc.nextLong();
				System.out.println("enter your address");
				String address=sc.next();
				
				Person person=new Person();
				person.setName(name);
				person.setPhone(phone);
				person.setAddress(address);
				//person.setCard(id);
				crud1.updatePerson(id, person);
				
				
			}break;
			default:
				break;
			}
			
			
		}while(check);
	}

}

