package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MensajeDao;
import dao.UsuarioDao;
import entities.Mensaje;
import entities.Usuario;


@WebServlet("/MensajeController")
public class MensajeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public MensajeController() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("act");
		if (act == null) {

		}else if (act.equals("actualizar")) {
			
			String name = request.getParameter("name1");
			String email = request.getParameter("email1");
			String website = request.getParameter("website1");
			String message = request.getParameter("message1");
			String user = request.getParameter("usuario1");
			
			Mensaje m = new Mensaje();
			
			UsuarioDao uDao = new UsuarioDao();
			List<Usuario> ul = uDao.list();
			
			for(Usuario u: ul) {
				if(u.getUser().equalsIgnoreCase(user)) {
					m.setUsuarioBean(u);
				}
			}

			MensajeDao m1Dao = new MensajeDao();
			List<Mensaje> ml = m1Dao.list();
			
			for(Mensaje m1: ml) {
				if(m1.getName().equalsIgnoreCase(name)) {
					m.setId(m1.getId());
					m.setName(name);
				}
			}

			m.setEmail(email);
			m.setWebsite(website);
			m.setMessage(message);
			
			System.out.println(m.getMessage());
			
			
			m1Dao.update(m);
			
			String site = new String("http://localhost:8080/mensajesJSP/index.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);

		}else if(act.equals("delete")) {
			
			String name = request.getParameter("name2");

			MensajeDao m1Dao = new MensajeDao();
			List<Mensaje> ml = m1Dao.list();
			
			for(Mensaje m1: ml) {
				if(m1.getName().equalsIgnoreCase(name)) {
					m1Dao.delete(m1);
				}
			}
			
			String site = new String("http://localhost:8080/mensajesJSP/index.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);
			
		}else if (act.equals("update")) {
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String website = request.getParameter("website");
			String message = request.getParameter("message");
			String user = request.getParameter("usuario");

			Mensaje m = new Mensaje();
			UsuarioDao uDao = new UsuarioDao();
			List<Usuario> ul = uDao.list();
			
			for(Usuario u: ul) {
				if(u.getUser().equalsIgnoreCase(user)) {
					m.setUsuarioBean(u);
				}
			}
			m.setName(name);
			m.setEmail(email);
			m.setWebsite(website);
			m.setMessage(message);
			
			System.out.println(m.getMessage());
			
			MensajeDao mDao = new MensajeDao();
			
			mDao.insert(m);
			
			String site = new String("http://localhost:8080/mensajesJSP/index.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);
		}else 
                {
	
			String site = new String("http://localhost:8080/mensajesJSP/index.jsp");
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site);

		}

	}

}
