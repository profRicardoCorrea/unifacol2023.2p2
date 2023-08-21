package gui;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import entidades.Atleta;
import entidades.Funcionario;
import entidades.Pessoa;
import entidades.Time;
import interfaces.ITimeServico;
import repositorios.TimeMySqlRepositorio;
import servicos.TimeServico;
import util.ConnectionFactory;
import util.DatetimeExtensions;

public class MainTime {
	public static TimeMySqlRepositorio rpTime= new TimeMySqlRepositorio();
	
	public static void imprimirTodos() throws SQLException {
		System.out.println("----------------------------");
		for (Time time : rpTime.listarTodos()) {
			System.out.println("Id:"+time.getCodigo());
			System.out.println("NOME:"+time.getNome());
		}
	}
	public static void main(String[] args) throws ParseException, SQLException {
		//Connection cnnMysql=ConnectionFactory.createConnection();
		
		//Cadastrar Time
		try {
			
			 
			
			Atleta tec =new  Atleta("","");
			tec.setCodigo(0);
			Time t= new Time("Sport Clube Recife", tec,DatetimeExtensions.toDate("20/03/2000"));	
			
			
			rpTime.salvar(t);
			imprimirTodos();
			
			/*Atleta tec1 =new  Atleta("João","01010");
			tec.setCodigo(1);
			Time t1= new Time("Bota Fogo", tec,DatetimeExtensions.toDate("11/23/2002"));
			t1.setCodigo(3);
			rpTime.alterar(t1);
			imprimirTodos();*/
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR:"+e.getMessage());
		}
		
		
		
	}
}
