package business;

import java.util.ArrayList;

import model.Shop;
import mysql.Procedure;

public class CheckIn {

	public void InsertCheckIn(String username, String shop_name) {
		Procedure pro = new Procedure();
		try {

			pro.InsertCheckIn(username, shop_name);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<Shop> getUserHistoryLocation(String username)
	{
		Procedure pro = new Procedure();
		return pro.getUserHistoryLocation(username);
	}
}
