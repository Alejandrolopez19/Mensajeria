package util;

import java.util.List;

import dao.MensajeDao;
import dao.UsuarioDao;
import entities.Mensaje;
import entities.Usuario;

public class Prueba {

	public static void main(String[] args) {
		
		UsuarioDao uDao = new UsuarioDao();
		List<Usuario> usuarios = uDao.list();
		System.out.println(usuarios.size());
		
		MensajeDao mDao = new MensajeDao();
		List<Mensaje> mensajes = mDao.list();
		System.out.println(mensajes.size());
	}

}
