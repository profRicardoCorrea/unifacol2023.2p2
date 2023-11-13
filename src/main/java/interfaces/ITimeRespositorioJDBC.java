package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Time;
 

public interface ITimeRespositorioJDBC {	 
	public Time listarPorCpf(String cpf) throws SQLException;	 
	public Time listarPorTitulo(String titulo) throws SQLException;
	

}
