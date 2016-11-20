package controller;

import java.util.List;

import dao.HouseDao;
import entity.House;

public class HouseController {

	/* Classe para realizar as regras de negócios e chamar as classes DAO.
	 * */
	
	HouseDao userDao = new HouseDao();
	
	public List<House> getAllUsers(){
		return userDao.getAllUsers();
	}

}
