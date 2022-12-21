package jakarta.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.UserTransaction;

@WebServlet(urlPatterns="/testServlet")
public class TestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3420573282596921445L;
	
	@PersistenceUnit(unitName="persistanceUnit")
    private EntityManagerFactory emf;
    
    @Resource
    private UserTransaction tx;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Person p");
            List<?> result = query.getResultList();
            if (result.isEmpty()) {
                out.println("No results Found");
            } else {
                for (Object o : result) {
                    out.println("<li>" + String.valueOf(o) + "</li>");
                }
            }
        } finally {
            em.close();
        }

	}

}
