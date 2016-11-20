package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Employee;
import entity.Session;

public class SessionDao {

	/** Portugues: Insere uma nova session
	 *  English:   Insert a new session
	 * @param pSession
	 */
	public void insertNewSession(Session pSession){
		try{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("session");
			EntityManager manager = factory.createEntityManager();
			
			manager.getTransaction().begin(); 
			manager.persist(pSession);
			manager.getTransaction().commit();
			
		}catch(Exception e){
			System.out.println("SessionDao -> insertNewSession(Session): " + e);
		}
	}
	
	/** Portugues: Retorna uma sessão ativa por Employee
	 *  English: Return a active session by Employee 
	 * @param pEmployee
	 * @return Session (Null)
	 */
	public Session getActiveSessionByEmployee(Employee pEmployee){
		
		Session session = null;
		
		try{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("session");
			EntityManager manager = factory.createEntityManager();
			
			List<Session> lista = manager
					  .createQuery("select s from Session as s where s.isActive = 1 and s.employee = " + pEmployee.getIdEmployee())
					  .getResultList();
		
			// se for maior que 0, então retorna o primeiro da lista.
			if(lista.size() > 0){
				session = lista.get(0);	
			}

		}catch(Exception e){
			System.out.println("EmployeeDao -> getEmployeeWithId(float Id): " + e);
		}

		return session;
	}
	
}
