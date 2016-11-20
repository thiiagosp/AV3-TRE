package entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name="user_type")
public class UserType {

	@Id
	@GeneratedValue
	@Column(name = "id_user_type")
	private float idUserType;
}
