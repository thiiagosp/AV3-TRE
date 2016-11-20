package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name="UserTest")
public class House {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="profession")
	private String profession;

	public House(){}
   
	public House(int id, String name, String profession){
		this.id = id;
		this.name = name;
		this.profession = profession;
	}

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
	
	public String getProfession() {
		return profession;
	}
   
	public void setProfession(String profession) {
		this.profession = profession;
	} 
}

