package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Time;

public interface ITimeRepositorio {
	 
	public ArrayList<Time> persquisarPorNome(String nome) throws SQLException;
	public ArrayList<Time> persquisarClassificacao();
	 
	

}
