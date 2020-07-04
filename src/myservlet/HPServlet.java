package myservlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HPServlet
 */
@WebServlet("/HPServlet")
public class HPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String Login(String name,String password)
    {
    	String ret = "<html><body><h1>%s</h1></body></html>";
    	if(name.equals("chenzhuo")&&password.equals("123456"))
    	{
    		ret = ret.format("Login Succeed!");
    	}
    	else 
    	{
    		ret = ret.format("Login Failed!");
		}
    	return ret;
    }
    
    public void writeRegister(String name,String password,String telephone)
    {
    	
		try {
			File f = new File("d:\\user.txt");
			FileWriter fw = new FileWriter(f);
			fw.write(name+":"+password+":"+telephone);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    
 


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operation = request.getParameter("opt");
		
		if(operation==null || operation=="")
		{
			response.getWriter().append("invalid request.");
			return;
		}
		switch (operation) {
		case "login":
			String loginUn = request.getParameter("name");
	    	String loginPw = request.getParameter("password");
	    	response.getWriter().append(Login(loginUn, loginPw));
			
			break;
		case"regist":
			
			break;
		case"changepassword":
			break;
		default:
			response.getWriter().append("invalid request.");
			return;
		}
    	
    	
    	
    	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
