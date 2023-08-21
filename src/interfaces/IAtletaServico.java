package interfaces;

import java.util.ArrayList;

import entidades.Atleta;
import enums.PosicaoJogadorEnum;


public interface IAtletaServico {
	public void cadastrar(Atleta atleta);
	public void alterarPosicao(Atleta atleta, PosicaoJogadorEnum novaPosicao);
	public void imprimir();
	public ArrayList<Atleta> listarTodos();
	
	

}
