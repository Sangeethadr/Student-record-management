import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ShowDetailMarksServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	 String id=req.getParameter("sidno"); //getParameter returns string.Reading idno from request object
	 int sidno=Integer.parseInt(id);  //or Integer.parseInt(req.getParameter("sidno"));
	 String sname=req.getParameter("sname");
     String path="sun.jdbc.odbc.JdbcOdbcDriver";
	 String url="jdbc:odbc:xyz";
	 String un="root";
	 String pw="root";
	 DataAcess d1=new DataAcess(path,url,un,pw);
	 int marks[]=d1.getStudentMarks(sidno); //gives all marks of student
	 PrintWriter out=res.getWriter();
	 out.println("<html><body><h3>marks of "+sname+"</h3><br>");
	 out.println("sub1:"+marks[0]+"<br>");
	 out.println("sub2:"+marks[1]+"<br>");
	 out.println("sub3:"+marks[2]+"<br>");
	 out.println("sub4:"+marks[3]+"<br>");
	 out.println("sub5:"+marks[4]+"<br>");
	 out.println("sub6:"+marks[5]+"<br>");
	 out.println("Tmarks:"+marks[6]+"<br>");
	 out.println("<a href=http://localhost:8888/college11/facultymenu.html>Home</a></body></html>");

}
}
