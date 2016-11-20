package controller;

import dao.EmployeeDao;
import dao.SessionDao;
import entity.Employee;
import entity.Session;

public class EmployeeController {

	EmployeeDao employeeDao = new EmployeeDao();
	SessionDao sessionDao = new SessionDao();
	
	public Employee Login(String pCodeRegistration, String pPassword){
		
		//valida se o usu�rio � v�lido ou n�o, se n�o � v�lido, retorna NULL
		Employee employee = employeeDao.getEmployeeByCodeRegistrationAndPasword(pCodeRegistration, pPassword);
		
		//Se o Employee n�o � nulo, necess�rio verificar a session.
		if(employee != null){
			
			Session session = sessionDao.getActiveSessionByEmployee(employee);
			
			// se a session � null ent�o vai ser realizado o login inserindo uma nova session
			if(session == null){
				session = new Session(employee);
				sessionDao.insertNewSession(session);
			}
		}
		return employee;
	}
	
}
