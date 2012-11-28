package business;

import mysql.Procedure;

public class Login {

	// login successfully: 1
	// failed: 0
	public int login(String username,String userpassword) {
		int result = 0;
		Procedure pro = new Procedure();
		try {
			
			result = pro.Login(username, userpassword);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

}
