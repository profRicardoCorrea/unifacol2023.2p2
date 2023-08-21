package repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

 
import entidades.Atleta;
import entidades.Funcionario;
import enums.GeneroEnum;
import enums.SexoEnum;
import enums.TipoFuncionario;
import interfaces.IBasicoRepositorio;
import interfaces.IFuncionarioRespositorioJDBC;
import util.ConnectionFactory;
import util.ConnectionSingleton;

public class FuncionarioMySqlRepositorio implements IBasicoRepositorio<Funcionario>,IFuncionarioRespositorioJDBC {
	
	private Connection conn;
	public FuncionarioMySqlRepositorio()  {
		try {
			this.conn = this.conn = ConnectionSingleton.getInstance().conexao;	;		 
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Override
	public long salvar(Funcionario Funcionario) throws SQLException   {

		try {			 
			 
			String sqlEleitor = "INSERT INTO Funcionario"
					+ "( matricula,data_contratacao"
					+ ",tipo_funcionario,salario,situacao,"
					+ "nome,cpf,data_nascimento,sexo,genero)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sqlEleitor, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, Funcionario.getMatricula());
			ps.setDate(2, new java.sql.Date(Funcionario.getDataContratacao().getTime()));
			ps.setString(3, Funcionario.getTipoFuncionario().toString());
			ps.setDouble(4, Funcionario.getSalario());
			ps.setBoolean(5, Funcionario.isSituacao());
			ps.setString(6, Funcionario.getNome());
			ps.setString(7, Funcionario.getCpf());
			ps.setDate(8, new java.sql.Date(Funcionario.getDataNascimento().getTime()));
			ps.setString(9, Funcionario.getSexo().toString());	
			ps.setString(10, Funcionario.getGenero().toString());
			 
			int retorno = ps.executeUpdate();
			System.out.println("AQUIsalvo");
			if (retorno == 0) {
				throw new SQLException("Persistencia do Funcionario falhou , ID do Funcionario não foi gerado.");
			}

			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getLong(1);
					
				} else {
					throw new SQLException("Persistencia do Funcionario  falhou , ID do Funcionario não foi gerado.");
				}
			}
			
		} catch (SQLException e2) {
			System.out.printf("Erro:%s",e2.getMessage());
			throw new SQLException("Persistencia do Funcionario falhou.");
		}

	}

	@Override
	public void alterar(Funcionario Funcionario) throws SQLException {
		try {			 
			 
			String sqlEleitor = "UPDATE Funcionario "
					+ "SET matricula=?,"
					+ "data_contratacao=?,"
					+ "data_demissao=?,"
					+ "data_renovacao=?,"
					+ "tipo_funcionario=?,"
					+ "salario,situacao=?,"
					+ "situacao=?"
					+ "nome=?,"
					+ "cpf=?,"
					+ "data_nascimento=?,"
					+ "sexo=?"	
					+ "genero=?"
					+ "Where idFuncionario=?;";
			PreparedStatement ps = conn.prepareStatement(sqlEleitor);
			ps.setInt(1, Funcionario.getMatricula());
			ps.setDate(2, new java.sql.Date(Funcionario.getDataContratacao().getTime()));
			ps.setString(3, Funcionario.getTipoFuncionario().toString());
			ps.setDouble(4, Funcionario.getSalario());
			ps.setBoolean(5, Funcionario.isSituacao());
			ps.setString(6, Funcionario.getNome());
			ps.setString(7, Funcionario.getCpf());
			ps.setDate(8, new java.sql.Date(Funcionario.getDataNascimento().getTime()));
			ps.setString(9, Funcionario.getSexo().toString());
			ps.setString(10, Funcionario.getGenero().toString());	
			 
			System.out.println(">>ALTERAR:"+Funcionario.getNome());
			int retorno = ps.executeUpdate();
			 
			if (retorno == 0) {
				throw new SQLException("Alteracao do Funcionario falhou");
			}			 
			
		} catch (SQLException e2) {
			System.out.printf("Erro:%s",e2.getMessage());
			throw new SQLException("Alteracao do Funcionario falhou");
		}

	}

	 

	@Override
	public ArrayList<Funcionario> listarTodos() throws SQLException {
		String sql="SELECT idfuncionario,matricula,data_contratacao,data_demissao,data_renovacao,tipo_funcionario,salario,situacao,\r\n"
				+ "nome,cpf,data_nascimento,sexo, genero FROM Funcionario;";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();

		ArrayList<Funcionario> Funcionarios=new ArrayList<Funcionario>();
		while(rs.next()){
			try {
				Funcionario e=new Funcionario();
				e.setCodigo(rs.getInt("idFuncionario"));
				e.setMatricula(rs.getInt("matricula"));
				e.setDataContratacao(rs.getDate("data_contratacao"));  
				e.setDataDemissao(rs.getDate("data_demissao"));  
				e.setDataRenovacao(rs.getDate("data_renovacao"));   
				e.setTipoFuncionario(TipoFuncionario.getEnum(rs.getString("data_renovacao")));  
				e.setNome(rs.getString("nome"));	
				e.setCpf(rs.getString("cpf"));						
				e.setDataNascimento(rs.getDate("dataNascimento"));
				e.setSexo(SexoEnum.getEnum(rs.getString("sexo")));
				e.setGenero(GeneroEnum.getEnum(rs.getString("genero")));
				Funcionarios.add(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				 
			}			 
			 	 
		}
		return Funcionarios;
	}

	@Override
	public void excluir(Funcionario Funcionario)  throws SQLException{
		try {			 
			 
			String sqlEleitor = "DELETE from Funcionario Where idFuncionario=?";
			PreparedStatement ps = conn.prepareStatement(sqlEleitor);
			ps.setInt(1, Funcionario.getCodigo());		 
			System.out.println(">>Excluir:"+Funcionario.getCodigo());
			ps.execute();
			 
					 
			
		} catch (SQLException e2) {
			System.out.printf("Erro:%s",e2.getMessage());
			throw new SQLException("Exclusao do Funcionario falhou");
		}
		
	}
 
	@Override
	public Funcionario listarPorCodigo(int condigo) throws SQLException {
		try {
			String sql = "SELECT idfuncionario,matricula,data_contratacao,"
					+ "data_demissao,data_renovacao,tipo_funcionario,salario,situacao,"
					+ "nome,cpf,data_nascimento,sexo FROM Funcionario Where idFuncionario=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, condigo);
			ResultSet rs = ps.executeQuery();
			rs.next();

			Funcionario e = new Funcionario();
			e.setCodigo(rs.getInt("idFuncionario"));
			e.setMatricula(rs.getInt("matricula"));
			e.setDataContratacao(rs.getDate("data_contratacao"));
			e.setDataDemissao(rs.getDate("data_demissao"));
			e.setDataRenovacao(rs.getDate("data_renovacao"));
			e.setTipoFuncionario(TipoFuncionario.getEnum(rs.getString("data_renovacao")));
			e.setNome(rs.getString("nome"));
			e.setCpf(rs.getString("cpf"));
			e.setDataNascimento(rs.getDate("dataNascimento"));
			e.setSexo(SexoEnum.getEnum(rs.getString("sexo")));
			e.setGenero(GeneroEnum.getEnum(rs.getString("genero")));
			return e;
		} catch (SQLException e2) {
			System.out.printf("Erro:%s",e2.getMessage());
			throw new SQLException("ListarPorCodigo do Funcionario falhou");
		}
	}
	@Override
	public Funcionario listarPorCpf(String cpf) throws SQLException {
		try {
			String sql = "SELECT idfuncionario,matricula,data_contratacao,"
					+ "data_demissao,data_renovacao,tipo_funcionario,salario,situacao,"
					+ "nome,cpf,data_nascimento,sexo FROM Funcionario Where cpf=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cpf);
			ResultSet rs = ps.executeQuery();
			rs.next();

			Funcionario e = new Funcionario();
			e.setCodigo(rs.getInt("idFuncionario"));
			e.setMatricula(rs.getInt("matricula"));
			e.setDataContratacao(rs.getDate("data_contratacao"));
			e.setDataDemissao(rs.getDate("data_demissao"));
			e.setDataRenovacao(rs.getDate("data_renovacao"));
			e.setTipoFuncionario(TipoFuncionario.getEnum(rs.getString("data_renovacao")));
			e.setNome(rs.getString("nome"));
			e.setCpf(rs.getString("cpf"));
			e.setDataNascimento(rs.getDate("dataNascimento"));
			e.setSexo(SexoEnum.getEnum(rs.getString("sexo")));
			e.setGenero(GeneroEnum.getEnum(rs.getString("genero")));
			return e;
		} catch (SQLException e2) {
			System.out.printf("Erro:%s",e2.getMessage());
			throw new SQLException("ListarPorCpf do Funcionario falhou");
		}
	}
	@Override
	public Funcionario listarPorMatricula(int matricula) throws SQLException {
		try {
			String sql = "SELECT idfuncionario,matricula,data_contratacao,"
					+ "data_demissao,data_renovacao,tipo_funcionario,salario,situacao,"
					+ "nome,cpf,data_nascimento,sexo FROM Funcionario Where matricula=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, matricula);
			ResultSet rs = ps.executeQuery();
			rs.next();

			Funcionario e = new Funcionario();
			e.setCodigo(rs.getInt("idFuncionario"));
			e.setMatricula(rs.getInt("matricula"));
			e.setDataContratacao(rs.getDate("data_contratacao"));
			e.setDataDemissao(rs.getDate("data_demissao"));
			e.setDataRenovacao(rs.getDate("data_renovacao"));
			e.setTipoFuncionario(TipoFuncionario.getEnum(rs.getString("data_renovacao")));
			e.setNome(rs.getString("nome"));
			e.setCpf(rs.getString("cpf"));
			e.setDataNascimento(rs.getDate("dataNascimento"));
			e.setSexo(SexoEnum.getEnum(rs.getString("sexo")));
			e.setGenero(GeneroEnum.getEnum(rs.getString("genero")));
			return e;
		} catch (SQLException e2) {
			System.out.printf("Erro:%s",e2.getMessage());
			throw new SQLException("ListarPorMatricula do Funcionario falhou");
		}
	}
	
 
	 

}
