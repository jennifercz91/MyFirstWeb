package myservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jmx.snmp.internal.SnmpAccessControlModel;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String mypage="<html><body><form action=\"FirstServlet\" method=\"POST\">\r\n" + 
					"Username:<input type=\"text\" name=\"name\">\r\n" + 
					"<br />\r\n" + 
					"Password:<input type=\"text\" name=\"pass\" />\r\n" + 
					"<input type=\"submit\" value=\"Login\"/>\r\n" + 
					"</form>"
					+ "</body></html>";
		String sname=request.getParameter("name");
		String spass = request.getParameter("pass");
		String ret = "<html><body><h1>%s</h1></body></html>";
		
		if(sname.equals("chenzhuo")&&spass.equals("123456"))
		{
			ret = ret.format(ret, "Login Succeed! Responsed by Get.");
		}
		else {
			ret = ret.format(ret, "Login Failed! Responsed by Get");
		}
		response.setContentType("text/html");
		response.getWriter().append(ret).append(request.getRemoteHost());
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String sname=request.getParameter("name");
//		String spass = request.getParameter("pass");
//		String ret = "<html><body><h1>%s</h1></body></html>";
//		if(sname.equals("chenzhuo")&&spass.equals("123456"))
//		{
//			ret = ret.format(ret, "Login Succeed! Responsed by Post.");
//		}
//		else {
//			ret = ret.format(ret, "Login Failed! Responsed by Post");
//		}
//		response.setContentType("text/html");
//		response.getWriter().append(ret);
		this.doGet(request, response);

	}

}
