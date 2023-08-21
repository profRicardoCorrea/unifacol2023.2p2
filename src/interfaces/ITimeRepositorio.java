package interfaces;

import java.util.ArrayList;

import entidades.Time;

public interface ITimeRepositorio {
	 
	public ArrayList<Time> persquisarPorNome(String nome);
	public ArrayList<Time> persquisarClassificacao();
	 
	

}
