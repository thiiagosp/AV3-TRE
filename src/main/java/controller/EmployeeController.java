package controller;

import java.util.List;

import dao.EmployeeDao;
import dao.SessionDao;
import entity.Employee;
import entity.Session;

public class EmployeeController {

	EmployeeDao employeeDao = new EmployeeDao();
	SessionDao sessionDao = new SessionDao();
	
	
	/** Portugues: Método responsável pelo login
	 *  English: Method responsible for login
	 *  
	 * @param pCodeRegistration
	 * @param pPassword
	 * @return Employee
	 * @author Guilherme gui_dutralves@hotmail.com
	 * 
	 * log alteração: 
	 * <Name></Name>
	 * <Date></Date>
	 * <Description></Description>	
	 */
	public Employee Login(String pCodeRegistration, String pPassword){
		
		//valida se o usuário é válido ou não, se não é válido, retorna NULL
		Employee employee = employeeDao.getEmployeeByCodeRegistrationAndPasword(pCodeRegistration, pPassword);
		
		//Se o Employee não é nulo, necessário verificar a session.
		if(employee != null){
			
			Session session = sessionDao.getActiveSessionByEmployee(employee);
			
			// se a session é null então vai ser realizado o login inserindo uma nova session
			if(session == null){
				session = new Session(employee);
				sessionDao.insertNewSession(session);
				employee.setToken(session.getToken()); // atualiza o token
				employeeDao.updateEmployee(employee); // atualiza o Employee com o token
			}
		}
		return employee;
	}
	
}
