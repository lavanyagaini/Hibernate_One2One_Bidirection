package onetoone_bidirection2_dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pancard {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private long phone;
	private String panNum;
	
	@OneToOne
	@JoinColumn
	private Person person;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	

	public String getPanNum() {
		return panNum;
	}

	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}

	@Override
	public String toString() {
		return "Pancard [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", panNum="
				+ panNum + ", person=" + person + "]";
	}

	public Pancard(int id, String name, String address, long phone, String panNum, Person person) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.panNum = panNum;
		this.person = person;
	}

	public Pancard() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
