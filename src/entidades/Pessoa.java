package entidades;

import java.util.Date;

import enums.GeneroEnum;
import enums.SexoEnum;

public abstract class Pessoa extends EntidadeBasica {
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private SexoEnum sexo;
	private GeneroEnum genero;
	
	public Pessoa(String nome, String cpf) {
		
	} 
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public SexoEnum getSexo() {
		return sexo;
	}
	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}


	public GeneroEnum getGenero() {
		return genero;
	}


	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}
	
	
	
	 

}
