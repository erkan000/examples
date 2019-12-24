package example.jsf.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        ServletRegistration.Dynamic registration = servletContext.addServlet("faces-servlet", javax.faces.webapp.FacesServlet.class);
		registration.addMapping("*.jsf");
		registration.setLoadOnStartup(1);
		servletContext.setInitParameter("primefaces.THEME", "redmond");
		servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
    }

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
}
