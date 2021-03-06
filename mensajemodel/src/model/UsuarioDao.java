package model; 

import entities.Usuario;
import util.Conexion;

public class UsuarioDao 
	extends Conexion<Usuario> 
	implements GenericDao<Usuario>{
	
	public UsuarioDao(){
		super(Usuario.class);
	}
	
	public String validarUsuario(Usuario u){
		Usuario user = this.find(u.getUsuario());

		if(user != null)
			if (user.getClave().contentEquals(u.getClave())){
				return "SUCCESS";
			}
		return "ERROR";
	}
}
