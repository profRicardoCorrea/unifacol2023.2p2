package repositorios;

import java.util.ArrayList;

import entidades.Time;
import interfaces.IBasicoRepositorio;
import interfaces.ITimeRepositorio;

public class TimeSqlLiteRepositorio implements IBasicoRepositorio<Time>,ITimeRepositorio {

	@Override
	public void salvar(Time time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Time time) {
		// TODO Auto-generated method stub
		
	}

	 

	@Override
	public ArrayList<Time> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Time time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Time listarPorCodigo(int condigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Time> persquisarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Time> persquisarClassificacao() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
