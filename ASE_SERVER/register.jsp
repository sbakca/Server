<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	String uid=null;
	String upw=null;
	
	try
	{
		
		uid = request.getParameter("uid").toString();
		uid =new String(uid.getBytes("ISO8859_1"),"UTF-8");
		
		upw = request.getParameter("upw").toString();
		upw =new String(upw.getBytes("ISO8859_1"),"UTF-8");
	}
	
	catch(Exception e)
	{
		uid="";
		upw="";
		e.printStackTrace();
	}
	
	
	business.Register r=new business.Register();
	r.InsertUser(uid,upw);
 %>