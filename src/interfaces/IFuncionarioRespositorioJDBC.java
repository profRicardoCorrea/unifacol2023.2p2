package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Funcionario;
import entidades.Time;
 

public interface IFuncionarioRespositorioJDBC {	 
	public Funcionario listarPorCpf(String cpf) throws SQLException;	 
	public Funcionario listarPorMatricula(int matricula) throws SQLException;
	

}
