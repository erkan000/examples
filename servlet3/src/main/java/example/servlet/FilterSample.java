package example.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/*"}, asyncSupported=true)
public class FilterSample implements Filter{

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.err.println("SampleFilter initialized");		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		System.err.println("SampleFilter doFilter");
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		response.setCharacterEncoding("UTF-8");
		
		RequestDispatcher rd = null;
		if(request.getServletPath().equals("/") && request.getMethod().equals("GET")) {
			rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}else{
			chain.doFilter(request, response);
		}
		
	}
	
	@Override
	public void destroy() {
		System.err.println("SampleFilter destroy");
		
	}

}
