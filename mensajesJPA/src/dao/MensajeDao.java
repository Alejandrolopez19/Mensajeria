package dao;

import entities.Mensaje;
import entities.Usuario;
import util.Conexion;

public class MensajeDao extends Conexion<Mensaje> implements GenericDao<Mensaje> {
	
	public MensajeDao() {
		super(Mensaje.class);
	}

}
