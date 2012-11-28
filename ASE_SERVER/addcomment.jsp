<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	String username ="";
	String shop_key="";
	String content="";

	try
	{
		
		
		username = request.getParameter("u_name").toString(); 
		shop_key = request.getParameter("s_key").toString(); 
		content = request.getParameter("con").toString(); 
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	if(username==""){
	out.println("failed");}
	else{
	business.Comment c=new business.Comment();
	c.InsertComment(username,shop_key,content);
	out.println("succeed");}
 %>
