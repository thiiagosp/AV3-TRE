package entity;

import java.security.SecureRandom;
import java.sql.Date;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Entity;

@Entity
@Table(name="session")
public class Session {

	@Id
	@GeneratedValue
	@Column(name = "id_session")
	private float idSession;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_login")
	private Calendar dtLogin;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_last_action")
	private Calendar dtLastAction;
	
	@Column(name = "is_active")
	private boolean isActive;
	@Column(name = "token", length = 20)
	private String token;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@Column(name = "id_employee")
	private Employee employee;
	
	public Session(Employee pEmployee ){
		//Generate Token
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		
		this.dtLogin = Calendar.getInstance(); 
		this.isActive = true;
		this.employee = pEmployee;
		this.token = bytes.toString();
	}
}


/*
x id_session float NOT NULL AUTO_INCREMENT,
x id_employee float NOT NULL,
x dt_login date,
x dt_last_action date,
x token varchar(20),
x is_active boolean NOT NULL,
primary key(id_session),
FOREIGN KEY (id_session) REFERENCES employee(id_employee)
*/