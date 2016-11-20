package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import entity.House;

public class HouseDao {
	
	//Classe responsavel por conexao com o banco de dados.
	
	public List<House> getAllUsers(){
      List<House> userList = null;
      try {
         File file = new File("Users.dat");
         if (!file.exists()) {
            House user = new House(1, "Mahesh", "Teacher");
            userList = new ArrayList<House>();
            userList.add(user);
            saveUserList(userList); 
         }
         else{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            userList = (List<House>) ois.readObject();
            ois.close();
         }
      } catch (IOException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } 
      return userList;
   }

   private void saveUserList(List<House> userList){
      try {
         File file = new File("Users.dat");
         FileOutputStream fos;

         fos = new FileOutputStream(file);

         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(userList);
         oos.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }   
}