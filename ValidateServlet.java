import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ValidateServlet extends HttpServlet 
{
	String path,url,un,pw;

	public void init(ServletConfig config)throws ServletException
	{
		ServletContext context=config.getServletContext();
		path=context.getInitParameter("path");
        url=context.getInitParameter("url");
         un=context.getInitParameter("uname");
		 pw=context.getInitParameter("pword");
		 System.out.println("path:"+path);
		 System.out.println("url:"+url);
		 System.out.println("un:"+un);
		 System.out.println("pw:"+pw);
	}

	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
     String uname=req.getParameter("uname");
	 String pword=req.getParameter("pword");
	 DataAcess d1=new DataAcess(path,url,un,pw);
	 int typ=d1.getUserType(uname,pword);
	 if(typ!=0)
		{
		 int uidno=d1.getUserId(uname,pword);
		 HttpSession se=req.getSession(true);
		 se.setAttribute("uidno",new Integer(uidno));
		 if(typ==1)
			{
			 res.sendRedirect("http://localhost:8888/college11/adminmenu.html");
			}
			if(typ==2)
		{
        res.sendRedirect("http://localhost:8888/college11/facultymenu.html");
		}
		if(typ==3)
		{
		res.sendRedirect("http://localhost:8888/college11/parentmenu.html");
		}
		}
		else
		{
       res.sendRedirect("http://localhost:8888/college11/invaliduser.html");
		}

	 	}

}
