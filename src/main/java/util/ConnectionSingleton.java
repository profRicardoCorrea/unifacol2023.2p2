package util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public final class ConnectionSingleton {

	private static ConnectionSingleton instance;
	public Connection conexao = null;

	private ConnectionSingleton() throws SQLException, InterruptedException {

		String url = "jdbc:mysql://localhost:3306/futebol_online?useTimezone=true&serverTimezone=UTC"; // Nome da base de dados
		String user = "root"; // nome do usu�rio do MySQL
		String password = "root"; // senha do MySQL

		this.conexao = DriverManager.getConnection(url, user, password);

	}

	public static ConnectionSingleton getInstance() throws SQLException, InterruptedException {
		if (instance == null|| instance.conexao.isClosed()) {
			instance = new ConnectionSingleton();
			System.out.println("Novo Objeto");
		}
		else {
			
			System.out.println("REUSO DE CONEXAO");
		}
		return instance;
	}
}
