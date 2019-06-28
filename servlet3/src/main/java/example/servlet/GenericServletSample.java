package example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value="/generic", loadOnStartup=1)
public class GenericServletSample extends HttpServlet {

	private static final long serialVersionUID = -5700139365793123567L;

	@Override
	public void init() throws ServletException {
		System.err.println("Generic Servlet init");
	}
	
//	called in every HTTP request
//	this method calls doGet or doPost or .. with appriciate incoming HTTP request 
//	if you override this doXxx methods doesnt works
	public void service(ServletRequest req, ServletResponse response) throws ServletException, IOException {
		String param = req.getParameter("id");
		if(param != null){
		      response.getWriter().write("<html><body>You sent a parameter</body></html>");
		  }else{
		      response.getWriter().write("<html><body>You can send id parameter</body></html>");
		  }
	}
	
	@Override
	public void destroy() {
		System.err.println("Generic Servlet destroy");
	}

}
