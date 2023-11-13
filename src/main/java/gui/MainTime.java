package gui;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import entidades.Atleta;
import entidades.Funcionario;
import entidades.Pessoa;
import entidades.Time;
import interfaces.ITimeServico;
import repositorios.TimeRepositorio;
import servicos.TimeServico;
import util.ConnectionFactory;
import util.DatetimeExtensions;

public class MainTime {
	public static TimeRepositorio rpTime= new TimeRepositorio();
	
	public static void imprimirTodos() throws SQLException {
		System.out.println("----------------------------");
		for (Time time : rpTime.listarTimes()) {
			System.out.println("Id:"+time.getCodigo());
			System.out.println("NOME:"+time.getNome());
		}
	}
	public static void main(String[] args) throws ParseException, SQLException {
		 
		try {			
			Atleta tec =new  Atleta("","");
			tec.setCodigo(0);
			Time t= new Time("Clube 2 Nautico Capibaribe", tec,DatetimeExtensions.toDate("10/08/1995"));	
			
			
			rpTime.adicionar(t);
			imprimirTodos();
			
			 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR:"+e.getMessage());
		}
		
		
		
	}
}
