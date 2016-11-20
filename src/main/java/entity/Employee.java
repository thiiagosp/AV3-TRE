package entity;

import java.sql.Date;
import java.util.GregorianCalendar;

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
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "id_employee")
	private float idEmployee;
	@Column(name = "nm_employee")
	private String nmEmployee;
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_admission")
	private Date dtAdmission;
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_leave")
	private Date dtLeave;
	@Column(name = "is_active")
	private boolean isActive;
	@Column(name = "de_email")
	private String deEmail;
	@Column(name = "code_registration")
	private String codeRegistration;
	@Column(name = "de_password")
	private String dePassword;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@Column(name = "id_address")
	private Address address;
	@ManyToOne(cascade = CascadeType.ALL)
	@Column(name = "id_role")
	private Role role;
	@ManyToOne(cascade = CascadeType.ALL)
	@Column(name = "id_user_type")
	private UserType userType;
	
	public float getIdEmployee() {
		return idEmployee;
	}
	public String getNmEmployee() {
		return nmEmployee;
	}
	public void setNmEmployee(String nmEmployee) {
		this.nmEmployee = nmEmployee;
	}
	public Date getDtAdmission() {
		return dtAdmission;
	}
	public void setDtAdmission(Date dtAdmission) {
		this.dtAdmission = dtAdmission;
	}
	public Date getDtLeave() {
		return dtLeave;
	}
	public void setDtLeave(Date dtLeave) {
		this.dtLeave = dtLeave;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getDeEmail() {
		return deEmail;
	}
	public void setDeEmail(String deEmail) {
		this.deEmail = deEmail;
	}
	public String getCodeRegistration() {
		return codeRegistration;
	}
	public void setCodeRegistration(String codeRegistration) {
		this.codeRegistration = codeRegistration;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
