package repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Atleta;
import entidades.Time;
import interfaces.IBasicoRepositorio;
import interfaces.ITimeRepositorio;
import util.ConnectionFactory;
import util.ConnectionSingleton;

public class TimeMySqlRepositorio implements IBasicoRepositorio<Time>, ITimeRepositorio {

	private Connection conn;

	public TimeMySqlRepositorio() {
		try {
			this.conn = ConnectionSingleton.getInstance().conexao;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error:\n" + e);
		}

	}

	@Override
	public long salvar(Time time) throws SQLException {

		try {

			String sql_atleta = "INSERT INTO time" + "( nome,dataNascimento)" + "VALUES(?,?);";
			PreparedStatement ps = conn.prepareStatement(sql_atleta, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, time.getNome());

			ps.setDate(2, new java.sql.Date(time.getDataNascimento().getTime()));

			// Executa a instru��o

			int retorno = ps.executeUpdate();
			System.out.println("AQUIsalvo");
			if (retorno == 0) {
				throw new SQLException("Persistencia do TIME falhou , ID do TIME n�o foi gerado.");
			}

			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getLong(1);

				} else {
					throw new SQLException("Persistencia do TIME  falhou , ID do TIME n�o foi gerado.");
				}
			}

		} catch (SQLException e2) {
			System.out.printf("Erro:%s", e2.getMessage());
			throw new SQLException("Persistencia do TIME falhou.");
		}

	}

	@Override
	public void alterar(Time time) throws SQLException {
		try {

			String sqlEleitor = "UPDATE time SET nome=?,idAtleta=?" + ",dataNascimento=? Where idTime=?;";
			PreparedStatement ps = conn.prepareStatement(sqlEleitor);
			ps.setString(1, time.getNome());
			ps.setInt(2, time.getTecnico().getCodigo());
			ps.setDate(3, new java.sql.Date(time.getDataNascimento().getTime()));
			ps.setInt(4, time.getCodigo());
			System.out.println(">>ALTERAR:" + time.getNome());
			int retorno = ps.executeUpdate();

			if (retorno == 0) {
				throw new SQLException("Alteracao do TIME falhou");
			}

		} catch (SQLException e2) {
			System.out.printf("Erro:%s", e2.getMessage());
			throw new SQLException("Alteracao do TIME falhou");
		}

	}

	@Override
	public ArrayList<Time> listarTodos() throws SQLException {
		String sql = "SELECT idtime,nome, dataNascimento FROM time;";
		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		ArrayList<Time> times = new ArrayList<Time>();
		while (rs.next()) {
			try {
				Time e = new Time();
				e.setCodigo(rs.getInt("idtime"));
				e.setNome(rs.getString("nome"));

				e.setDataNascimento(rs.getDate("dataNascimento"));
				times.add(e);
			} catch (SQLException e1) {
				System.out.println(e1);

			}

		}
		return times;
	}

	@Override
	public void excluir(Time time) {
		// TODO Auto-generated method stub

	}

	@Override
	public Time listarPorCodigo(int condigo) throws SQLException {
		String sql = "SELECT  idtime,nome,idAtleta,dataNascimento " + "FROM time Where idtime=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, condigo);
		ResultSet rs = ps.executeQuery();
		rs.next();

		Time e = new Time();
		e.setCodigo(rs.getInt("idtime"));
		e.setNome(rs.getString("nome"));
		e.setTecnico(new Atleta(rs.getInt("idAtleta")));
		e.setDataNascimento(rs.getDate("dataNascimento"));

		return e;
	}

	@Override
	public ArrayList<Time> persquisarPorNome(String nome) throws SQLException {
		ArrayList<Time> times = new ArrayList<Time>();
		try {

			String sql = "SELECT  idtime,nome,idAtleta,dataNascimento " + "FROM time Where nome=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Time e = new Time();
				e.setCodigo(rs.getInt("idtime"));
				e.setNome(rs.getString("nome"));
				e.setTecnico(new Atleta(rs.getInt("idAtleta")));
				e.setDataNascimento(rs.getDate("dataNascimento"));
				times.add(e);
			}

		} catch (Exception e) {
			System.out.println("Error ArrayList<Time> persquisarPorNome(String nome)");
			throw e;
		}
		return times;

	}

	@Override
	public ArrayList<Time> persquisarClassificacao() {
		// TODO Auto-generated method stub
		return null;
	}

}
