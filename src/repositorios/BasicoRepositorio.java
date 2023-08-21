package repositorios;

import java.util.ArrayList;

import entidades.EntidadeBasica;
import entidades.Time;
import interfaces.IBasicoRepositorio;

public class BasicoRepositorio<Entidade> implements IBasicoRepositorio<Entidade>{
	public ArrayList<Entidade> entidadesList = null;
	public BasicoRepositorio(ArrayList<Entidade> arraylist) {
		entidadesList=arraylist;
	}
	@Override
	public void salvar(Entidade et) {
		entidadesList.add(et);		
	}
	@Override
	public void alterar(Entidade etAlterar) {
		
		for (Entidade entidade : entidadesList) {
			 
			if(((EntidadeBasica) etAlterar ).getCodigo()==((EntidadeBasica)entidade).getCodigo())
				entidade=etAlterar;
			
		} 
		
	}
	 
	
	public void qualquerCoisa() {}
	@Override
	public ArrayList<Time> listarTodos() {
		
		return times;
	}
	public int gerarCodigo() {
		return  this.times.size()+1;
	}
	
	public Time pesquisarPorCodigo(int codigo) {
		 
		for (Time time : times) {
			if(codigo==time.getCodigo())
				return time;
			
		}
		return null;
	}
	@Override
	public void excluir(Time time) {
		this.times.remove(time);
		
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
