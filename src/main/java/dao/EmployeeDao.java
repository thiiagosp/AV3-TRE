package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

import entity.Employee;

public class EmployeeDao {

	/** Portugues: Insere um novo Employee
	 *  English: Insert a new Employee
	 * 
	 * @param pEmployee
	 * @author Guilherme gui_dutralves@hotmail.com
	 * 
	 * log alteração: 
	 * <Name></Name>
	 * <Date></Date>
	 * <Description></Description>	
	 */
	public void insertNewEmploye(Employee pEmployee){
		try{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
			EntityManager manager = factory.createEntityManager();
			
			manager.getTransaction().begin(); 
			manager.persist(pEmployee);
			manager.getTransaction().commit();
			
		}catch(Exception e){
			System.out.println("EmployeeDao -> insertNewEmploye(Employee): " + e);
		}
	}
	
	/** Portugues: busca um Employee por Id
	 *  English: find a Employee by Id
	 * 
	 * @param float pId
	 * @author Guilherme gui_dutralves@hotmail.com
	 * 
	 * log alteração: 
	 * <Name></Name>
	 * <Date></Date>
	 * <Description></Description>	
	 */
	public Employee getEmployeeById(float pId){
		
		Employee employee = null;
		
		try{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
			EntityManager manager = factory.createEntityManager();
			
			List<Employee> lista = manager
					  .createQuery("select e from Employee as e where e.idEmployee = " + pId)
					  .getResultList();
		
			// se for maior que 0, então retorna o primeiro da lista.
			if(lista.size() > 0){
				employee = lista.get(0);	
			}

		}catch(Exception e){
			System.out.println("EmployeeDao -> getEmployeeWithId(float Id): " + e);
		}

		return employee;
	}
	
	/** Portugues: Retorna um Employee por CodeRegistration e Password
	 *  English:  Return a Employee by CodeRegistration and Password
	 * @param pCodeRegistration
	 * @param pPassword
	 * @return Employee (null)
	 * @author Guilherme gui_dutralves@hotmail.com
	 * 
	 * log alteração: 
	 * <Name></Name>
	 * <Date></Date>
	 * <Description></Description>	
	 */
	public Employee getEmployeeByCodeRegistrationAndPassword(String pCodeRegistration, String pPassword){
		
		Employee employee = null;
		
		try{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
			EntityManager manager = factory.createEntityManager();
			
			List<Employee> lista = manager
					  .createQuery("select e from Employee as e where e.codeRegistration = " + pCodeRegistration + " and e.dePassword = " + pPassword )
					  .getResultList();
		
			// se for maior que 0, então retorna o primeiro da lista.
			if(lista.size() > 0){
				employee = lista.get(0);	
			}

		}catch(Exception e){
			System.out.println("EmployeeDao -> getEmployeeByCodeRegistrationAndPasword(pCodeRegistration, pPassword): " + e);
		}

		return employee;
	}
	
	
	/** Portugues: Salva um Employee
	 *  English:  Save a employee
	 * 
	 * @param pEmployee
	 * @author Guilherme gui_dutralves@hotmail.com
	 * 
	 * log alteração: 
	 * <Name></Name>
	 * <Date></Date>
	 * <Description></Description>				
	 */
	public void updateEmployee(Employee pEmployee){
		try{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
			EntityManager manager = factory.createEntityManager();
			
			manager.getTransaction().begin(); 
			manager.merge(pEmployee);
			manager.getTransaction().commit();
			
		}catch(Exception e){
			System.out.println("EmployeeDao -> updateEmployee(Employee): " + e);
		}
	}
	
	
	
	
}
