import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CreateUserServlet extends HttpServlet
{
	String path,url,un,pw;
	public void init(ServletConfig config)throws ServletException
	{
		ServletContext context=config.getServletContext();
		path=context.getInitParameter("path");
        url=context.getInitParameter("url");
	    un=context.getInitParameter("uname");
        pw=context.getInitParameter("pword");
	}
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
      String s=req.getParameter("uidno");
	  int uidno=Integer.parseInt(s);
	  String uname=req.getParameter("uname");
	  String pword=req.getParameter("pword");
	  String tp=req.getParameter("utype");
	  int utyp=Integer.parseInt(tp);
      DataAcess d1=new DataAcess(path,url,un,pw);
	  boolean fl=d1.createuser(uidno,uname,pword,utyp);
      PrintWriter out=res.getWriter(); 
	   if(fl)
		{
		   out.println("<html><body><h2>successfully created the user<br>");
		   out.println("with the idno:" + uidno + "uname:" + uname + "pword: " +pword + " utype:" + utyp +"</h2><br>");
		   out.println("<a href=http://localhost:8888/college11/adminmenu.html> home </a></body></html>");
		}
		else
		{
			out.println("<html><body><h2> failed to create the user</h2><br>");
			out.println("<a href=http://localhost:8888/college11/adminmenu.html> home </a></body></html>");
        }
	}
}


