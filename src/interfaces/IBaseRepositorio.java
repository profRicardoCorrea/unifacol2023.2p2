package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

 

public interface IBaseRepositorio<Entidade> {

	public long salvar(Entidade e) throws SQLException;
	public void alterar(Entidade e) throws SQLException;
	public void remover(Entidade e) throws SQLException;	 
	public ArrayList<Entidade> listarTodos() throws SQLException;
	 
}
