package business;

import mysql.Procedure;

public class Register {

	public void InsertUser(String username, String userpassword) {
		Procedure pro = new Procedure();
		try {

			pro.InsertUser(username, userpassword);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
