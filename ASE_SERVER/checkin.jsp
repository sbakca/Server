<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	String username ="";
	String shop_name="";
	
	try
	{
		
		
		username = request.getParameter("u_name").toString(); 
		shop_name = request.getParameter("s_name").toString(); 
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	if(username==""||shop_name==""){
	out.println("failed");}
	else{
	business.CheckIn ci=new business.CheckIn();
	ci.InsertCheckIn(username,shop_name);
	out.println("succeed");}
 %>
