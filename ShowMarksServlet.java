import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ShowMarksServlet extends HttpServlet 
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession se=req.getSession(true);
		Object o=se.getAttribute("uidno");
		Integer i1=(Integer)o;
		int sidno=i1.intValue();

		String path="sun.jdbc.odbc.JdbcOdbcDriver";
		String url="jdbc:odbc:xyz";
		String un="root";
		String pw="root";
		DataAcess d1=new DataAcess(path,url,un,pw);
		int marks[]=d1.getStudentMarks(sidno);
		PrintWriter out=res.getWriter();
		out.println("<html><body><h2>marks details</h2>");
		out.println("sub1:" + marks[0] + "<br>");
        out.println("sub2:" + marks[1] + "<br>");
        out.println("sub3:" + marks[2] + "<br>");
        out.println("sub4:" + marks[3] + "<br>");
		out.println("sub5:" + marks[4] + "<br>");
		out.println("sub6:" + marks[5] + "<br>");
        out.println("total marks:" + marks[6] + "<br>");
       out.println("<a href=http://localhost:8888/college11/parentmenu.html>home</a></body></html>");

	}
}
