package business;

import mysql.Procedure;

public class Register {

	public int InsertUser(String username, String userpassword) {
		Procedure pro = new Procedure();
		try {

			return pro.InsertUser(username, userpassword);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
