package entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue
	@Column(name = "id_role")
	private float idRole;
	
}
