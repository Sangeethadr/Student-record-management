import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class EnterAttendenceServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
     String path="sun.jdbc.odbc.JdbcOdbcDriver";
	 String url="jdbc:odbc:xyz";
	 String un="root";
	 String pw="root";
	 String si=req.getParameter("sidno");
	 int sidno=Integer.parseInt(si);
	 String sname=req.getParameter("sname");
	 String a1=req.getParameter("att");
	 int att=Integer.parseInt(a1);
      System.out.println("inside service of atten");	 
	 DataAcess d1=new DataAcess(path,url,un,pw);
	 boolean fl=d1.insertAttendence(sidno,sname,att);
	 System.out.println("sucess atte inserted");
	 PrintWriter out=res.getWriter();
	 if(fl)
		{
		 out.println("<html><body><h2>successfully inserted attendence of " + sname +"</h2><br>");
		 out.println("<a href=http://localhost:8888/college11/adminmenu.html>home</a></body></html>");
		}
		else
		{
			out.println("<html><body><h2> failed to insert attendence of" + sname +"</h2><br>");
			out.println("<a href=http://localhost:8888/college11/adminmenu.html>home</a></body></html>");
        }
	}
}
