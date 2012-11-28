package business;

import java.util.ArrayList;

import mysql.Procedure;

public class Comment {

	public void InsertComment(String username, String shop_key, String content) {
		Procedure pro = new Procedure();
		try {

			pro.InsertComment(username, shop_key, content);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<model.Comment> getComments(String shop_key)
	{
		Procedure pro = new Procedure();
		return pro.getComments(shop_key);
	}
	
	public void like(int com_id) {
		Procedure pro = new Procedure();
		pro.LikeComment(com_id);
	}
	
	public void dislike(int com_id) {
		Procedure pro = new Procedure();
		pro.DislikeComment(com_id);
	}
}
