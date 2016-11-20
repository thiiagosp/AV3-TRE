package entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue
	@Column(name = "id_address")
	private float idAddress;
	
}
