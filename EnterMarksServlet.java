import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class EnterMarksServlet extends HttpServlet
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
	 String s1=req.getParameter("sub1");
	 int sub1=Integer.parseInt(s1);
	 String s2=req.getParameter("sub2");
	 int sub2=Integer.parseInt(s2);
	 String s3=req.getParameter("sub3");
	 int sub3=Integer.parseInt(s3);
	 String s4=req.getParameter("sub4");
	 int sub4=Integer.parseInt(s4);
	 String s5=req.getParameter("sub5");
	 int sub5=Integer.parseInt(s5);
	 String s6=req.getParameter("sub6");
	 int sub6=Integer.parseInt(s6);
	 
	 DataAcess d1=new DataAcess(path,url,un,pw);
	 boolean fl=d1.insertMarks(sidno,sname,sub1,sub2,sub3,sub4,sub5,sub6);
	 PrintWriter out=res.getWriter();
	 if(fl)
		{
		 out.println("<html><body><h2>successfully inserted marks of " + sname +"</h2><br>");
		 out.println("<a href=http://localhost:8888/college11/adminmenu.html>home</a></body></html>");
		}
		else
		{
			out.println("<html><body><h2> failed to insert marks of" + sname +"</h2><br>");
			out.println("<a href=http://localhost:8888/college11/adminmenu.html>home</a></body></html>");
        }
	}
}
