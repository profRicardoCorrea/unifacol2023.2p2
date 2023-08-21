package gui;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import entidades.Atleta;
import entidades.Funcionario;
import entidades.Pessoa;
import entidades.Time;
import enums.GeneroEnum;
import enums.PosicaoAtletaEnum;
import enums.SexoEnum;
import enums.TipoFuncionario;
import interfaces.ITimeServico;
import repositorios.AtletaMySqlRepositorio;
import repositorios.TimeMySqlRepositorio;
import servicos.TimeServico;
import util.ConnectionFactory;
import util.ConnectionSingleton;
import util.DatetimeExtensions;

public class MainAtleta {
	public static AtletaMySqlRepositorio rpAtleta= new AtletaMySqlRepositorio();
	
	public static void imprimirTodos() throws SQLException {
		System.out.println("----------------------------");
		for (Atleta atleta : rpAtleta.listarTodos()) {
			System.out.println("Id:"+atleta.getCodigo());
			System.out.println("NOME:"+atleta.getNome());
			System.out.println("Posicao:"+atleta.getPosicao());
		}
	}
	public static void main(String[] args) throws ParseException, SQLException {
		//Connection cnnMysql=ConnectionFactory.createConnection();
		
		//Cadastrar Time
		try {
			
			//Connection conn =ConnectionSingleton.getInstance().conexao;
			//Connection conn1 =ConnectionSingleton.getInstance().conexao;
			
			/*Atleta tec =new  Atleta("","");
			tec.setMatricula(2);
			tec.setNome("FULANO 11");
			tec.setCpf("111113");
			tec.setDataContratacao(DatetimeExtensions.toDate("12/01/2022"));
			tec.setDataNascimento(DatetimeExtensions.toDate("15/03/2002"));
			tec.setTipoFuncionario(TipoFuncionario.Contratado);
			tec.setSexo(SexoEnum.Masculino);
			tec.setGenero(GeneroEnum.Cisgenero);
			tec.setPosicao(PosicaoAtletaEnum.Armador);
			rpAtleta.salvar(tec);*/
			imprimirTodos();
			
			 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR:"+e.getMessage());
		}
		
		
		
	}
}
