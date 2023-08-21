package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

 

public interface IBasicoRepositorio<Entidade> {
	public long salvar(Entidade et)throws SQLException;
	public void alterar(Entidade et) throws SQLException; 	 
	public ArrayList<Entidade> listarTodos() throws SQLException;
	public Entidade listarPorCodigo(int condigo) throws SQLException;
	public void excluir(Entidade et)  throws SQLException;
}
