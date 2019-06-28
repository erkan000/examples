package example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/post", initParams = { @WebInitParam(name = "initParam", value = "12") })
public class ServletSample extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet init param is: " + config.getInitParameter("initParam"));
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get header info: " + request.getHeader("Content-Type"));
		
		String input = request.getParameter("input");
		request.setAttribute("input", input);
		
		for (Cookie cookie : request.getCookies()) {
			System.out.println(cookie.getName() + "-" + cookie.getValue());
		}		
		setCookie(request, response);
		
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("/sendPost.jsp");
		rd.forward(request, response);

	}
	
	void setCookie(HttpServletRequest request, HttpServletResponse response){
	    final String cookieName = "MyCookie";
	    final String cookieValue = "MyCookieValue123";
	    final Boolean useSecureCookie = false;
	    final int expiryTime = 60 * 60 * 24;  // 24h in seconds
	    final String cookiePath = "/";

	    Cookie cookie = new Cookie(cookieName, cookieValue);
	    cookie.setSecure(useSecureCookie);  // determines whether the cookie should only be sent using a secure protocol, such as HTTPS or SSL
	    cookie.setMaxAge(expiryTime);  // A negative value means that the cookie is not stored persistently and will be deleted when the Web browser exits. A zero value causes the cookie to be deleted.
	    cookie.setPath(cookiePath);  // The cookie is visible to all the pages in the directory you specify, and all the pages in that directory's subdirectories
	    
	    //cookie.setHttpOnly(true);	 // For prevent XSS, only https requests can obtain cookie
	    response.addCookie(cookie);
	    // For escape Chrome XSS protection ;)
	    response.addHeader("X-XSS-Protection","0");
	    
	}
	

}
