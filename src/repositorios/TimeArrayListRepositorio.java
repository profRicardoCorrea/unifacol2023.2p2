package repositorios;

import java.util.ArrayList;

import entidades.Time;
import interfaces.IBasicoRepositorio;
import interfaces.ITimeRepositorio;

public class TimeArrayListRepositorio implements IBasicoRepositorio<Time>,ITimeRepositorio {
	public ArrayList<Time> times = new  ArrayList<Time>();

	public TimeArrayListRepositorio(ArrayList<Time> times) {
		 
		this.times = times;
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

	@Override
	public void salvar(Time et) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Time et) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Time> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Time listarPorCodigo(int condigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Time et) {
		// TODO Auto-generated method stub
		
	}
	

}
