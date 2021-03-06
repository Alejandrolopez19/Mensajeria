package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Usuario;
import model.UsuarioDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		
		String usuarioTxt = request.getParameter("usuario");
		String claveTxt = request.getParameter("password");
		 
		Usuario usuario = new Usuario(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
		 
		usuario.setUsuario(usuarioTxt); //setting the username and password through the loginBean object then only you can get it in future.
		usuario.setClave(claveTxt);
		 
		UsuarioDao loginDao = new UsuarioDao(); //creating object for LoginDao. This class contains main logic of the application.
		 
		String userValidate = loginDao.validarUsuario(usuario); //Calling authenticateUser function
		 System.out.println(userValidate);
		if(userValidate.contentEquals("SUCCESS")) {
			session.setAttribute("userName", usuarioTxt); 
			request.setAttribute("msgResultado", "Usuario " + usuarioTxt + " bienvenido a la plataforma de mensajes"); 			
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		} else { 
			session.setAttribute("errMessage", userValidate);
			request.setAttribute("msgResultado", "Hay un error en las credenciales, puedes intentar nuevamente"); 
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
