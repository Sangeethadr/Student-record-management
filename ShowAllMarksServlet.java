import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
public class ShowAllMarksServlet extends HttpServlet 
{
	public void service(HttpServletRequest req , HttpServletResponse res)throws ServletException,IOException
	{
     String path="sun.jdbc.odbc.JdbcOdbcDriver";
	 String url="jdbc:odbc:xyz";
	 String un="root";
	 String pw="root";
	 DataAcess d1=new DataAcess(path,url,un,pw);
	 ArrayList<Tmarks> a1=d1.getAllMarks();  //arraylist contains total marks of all students in form of tmarks 
	 PrintWriter out=res.getWriter();
	 out.println("<html><body>");
	 for(int i=0;i<a1.size();i++)
		{
       Tmarks t1=a1.get(i);   //retrieving id,name,marks from tmaks using arraylist object
	   int sidno=t1.getSidno();
	   String sname=t1.getSname();
	   int tmks=t1.getTmks();
	   out.println("<h3>"+sidno +"   <a href=http://localhost:8888/college11/showdetailmarks?sidno="+sidno+"&sname="+sname+">" + sname + "</a>" + tmks +"</h3><br>");
		}
		
       out.println("<a href=http://localhost:8888/college11/facultymenu.html>home</a></body></html>");
   }
}

