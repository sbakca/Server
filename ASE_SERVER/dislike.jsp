<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	int cid=0;
	
	try
	{
		cid = Integer.parseInt(request.getParameter("cid").toString()); 
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	if(cid==0)
	{
		out.println("failed");
	}
	else
	{
	  business.Comment  c = new business.Comment();
	  c.dislike(cid);
	  out.println("succeed");
	}
 %>
