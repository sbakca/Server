<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" import="java.util.*,Util.*" pageEncoding="UTF-8"%>
<%
	String username ="";
	
	try
	{
		username = request.getParameter("u_name").toString(); 
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	if(username=="")
	{
		out.println("failed");
	}
	else
	{
		business.CheckIn ci=new business.CheckIn();
		ArrayList<model.Shop> al = ci.getUserHistoryLocation(username);
		for(int i=0;i<al.size();i++)
		{
			out.println(""+al.get(i).getName()+";");
		}
	}
 %>
