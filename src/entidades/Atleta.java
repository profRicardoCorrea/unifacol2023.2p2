package entidades;

import java.util.ArrayList;

import enums.CartoesEnum;
import enums.PosicaoAtletaEnum;
 

public class Atleta extends Funcionario{
	
	private PosicaoAtletaEnum posicao;
	private boolean isTitular;
	private ArrayList<CartoesEnum> cartoes=new ArrayList<>();
	
	public Atleta(String nome, String cpf) {
		super(nome, cpf);
		// TODO Auto-generated constructor stub
	}
	public Atleta(int codigo) {
		super(null, null);
		this.setCodigo(codigo);
	}
	public Atleta() {
		super(null, null);
		 
	}
	
	
	public PosicaoAtletaEnum getPosicao() {
		return posicao;
	}
	public void setPosicao(PosicaoAtletaEnum posicao) {
		this.posicao = posicao;
	}
	public boolean isTitular() {
		return isTitular;
	}
	public void setTitular(boolean isTitular) {
		this.isTitular = isTitular;
	}
	public ArrayList<CartoesEnum> getCartoes() {
		return cartoes;
	}
	public void setCartoes(ArrayList<CartoesEnum> cartoes) {
		this.cartoes = cartoes;
	}
	
	

}
