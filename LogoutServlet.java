import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class LogoutServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		HttpSession se=req.getSession(true);
		se.invalidate();
		PrintWriter out=res.getWriter();
		out.println("<html><body><h2>Successfully logged out</h2><br>");
		out.println("<a href=http://localhost:8888/college11/login.html>Login again</a></body></html>");

	}

}  

