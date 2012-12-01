<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String shop_key="";

	try
	{

		shop_key = request.getParameter("s_key").toString(); 
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	business.Comment c=new business.Comment();
		ArrayList<model.Comment> al = c.getComments(shop_key);
		for(int i=0;i<al.size();i++)
		{
			out.println(""+al.get(i).getUsername()+".:,"+al.get(i).getContent()+".:,"+al.get(i).getNlike()+".:,"+al.get(i).getDislike()+".:,"+al.get(i).getComentId()+".:,");
		}
	
 %>
