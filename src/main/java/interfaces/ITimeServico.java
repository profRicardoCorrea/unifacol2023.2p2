package interfaces;

import java.util.ArrayList;

import entidades.Time;

public interface ITimeServico {
	public void cadastrar(Time time);
	public void cadastrar(String nomeTime);
	public void alterar(Time time);
	public ArrayList<Time> persquisar(String nome);
	public void excluir(Time time);

}
