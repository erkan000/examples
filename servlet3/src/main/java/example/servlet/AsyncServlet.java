package example.servlet;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/async", asyncSupported=true)
public class AsyncServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final AsyncContext ctx = request.startAsync();
		ctx.setTimeout(2000);
        ctx.addListener(new AsyncListener() {			
			@Override
			public void onTimeout(AsyncEvent event) throws IOException {
				System.out.println("onTimeout:" + Thread.currentThread().getId());			
			}			
			@Override
			public void onStartAsync(AsyncEvent event) throws IOException {
				System.out.println("onStartAsync:" + Thread.currentThread().getId());				
			}			
			@Override
			public void onError(AsyncEvent event) throws IOException {
				System.out.println("onError:" + Thread.currentThread().getId());				
			}			
			@Override
			public void onComplete(AsyncEvent event) throws IOException {
				System.out.println("onComplete:" + Thread.currentThread().getId());				
			}
		});
        ctx.start(() -> {
        	try {
        		ctx.getResponse().getWriter().write("Async response: " + Thread.currentThread().getId());
        	}catch (Exception e) {
				e.printStackTrace();
			}
        	ctx.complete();
        });
        
//         also we can process response on another async servlet. Instead start we call dispatch
//        ctx.dispatch("/dispatch");
	}

}
