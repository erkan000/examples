package example.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/*"}, asyncSupported=true)
public class FilterSample implements Filter{
	
	private ServletContext context;

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("SampleFilter initialized");		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		this.context.log("SampleFilter doFilter");
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		printRequestUri(request);
		printRequestParams(req);
		printRequestCookies(request);
		printRequestIp(request);
		printRequestSession(request);
		
		response.setCharacterEncoding("UTF-8");
		
		RequestDispatcher rd = null;
		if(request.getServletPath().equals("/") && request.getMethod().equals("GET")) {
			rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}else{
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}
	
	private void printRequestSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);		
		if(session == null){
			this.context.log("Session object is null");
		}else {
			this.context.log("Session object : " + session.getCreationTime());
		}
	}

	private void printRequestUri(HttpServletRequest request) {
		String uri = request.getRequestURI();
		this.context.log("Requested Resource : " + uri);		
	}

	private void printRequestIp(HttpServletRequest request) {
		this.context.log("Request IP address : " + request.getRemoteAddr());
	}

	private void printRequestCookies(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				this.context.log("Cookie : { "+cookie.getName()+","+cookie.getValue()+" }");
			}
		}
	}

	private void printRequestParams(ServletRequest req) {
		HttpServletRequest request = (HttpServletRequest) req;
		Enumeration<String> params = request.getParameterNames();
		while(params.hasMoreElements()){
			String name = params.nextElement();
			String value = req.getParameter(name);
			this.context.log("Request Params : { " + name + " = " + value + " }");
		}
	}

	@Override
	public void destroy() {
		this.context.log("SampleFilter destroy");
	}

}
