package example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/dispatch")
public class DispatcherSample extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String kullanici = request.getParameter("user");
		String sifre = request.getParameter("pass");
		
		RequestDispatcher rd = null;
		
		if(kullanici.equals("admin") && sifre.equals("admin")){
			rd = request.getRequestDispatcher("/result.jsp");
			rd.forward(request, response);
//			OR
//			response.sendRedirect("result.jsp");
		}else{
			rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
//			OR
//			response.sendRedirect("login.jsp");
		}
	}

}
