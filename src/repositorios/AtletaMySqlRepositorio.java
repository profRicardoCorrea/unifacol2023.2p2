package repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

 
import entidades.Atleta;
import enums.PosicaoAtletaEnum;
import interfaces.IAtletaRepositorio;
import interfaces.IBasicoRepositorio;
 
import util.ConnectionFactory;
import util.ConnectionSingleton;

public class AtletaMySqlRepositorio implements IBasicoRepositorio<Atleta>,IAtletaRepositorio {
	//private FuncionarioMySqlRepositorio funcionarioMySqlRepositorio=null;
	private Connection conn;
	public AtletaMySqlRepositorio()  {
		try {
			//this.funcionarioMySqlRepositorio=new FuncionarioMySqlRepositorio();
			this.conn = ConnectionSingleton.getInstance().conexao;	
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	@Override
	public long salvar(Atleta Atleta) throws SQLException   {

		try {			
			String sqlAtleta = "INSERT INTO Atleta (Nome,CPF)"
					+ "values(?,?)";		 
			
			PreparedStatement ps = conn.prepareStatement(sqlAtleta, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, Atleta.getNome().toString());
			ps.setString(2, Atleta.getCpf()); 
			 
			int retorno = ps.executeUpdate();
			System.out.println("AQUIsalvo");
			if (retorno == 0) {
				throw new SQLException("Persistencia do Atleta falhou , ID do Atleta n�o foi gerado.");
			}

			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getLong(1);
					
				} else {
					throw new SQLException("Persistencia do Atleta  falhou , ID do Atleta n�o foi gerado.");
				}
			}
			
		} catch (SQLException e2) {
			System.out.printf("Erro:%s",e2.getMessage());
			throw new SQLException("Persistencia do Atleta falhou.");
		}

	}

	@Override
	public void alterar(Atleta Atleta) throws SQLException {
		try {			 
			this.funcionarioMySqlRepositorio.alterar(Atleta);
			String sql = "UPDATE Atleta "
					+ "SET idFuncionario=?,posicaoJogadorEnum=?,isTitular=?"				 
					+ "Where idFuncionario=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Atleta.getCodigo());
			ps.setString(2, Atleta.getPosicao().toString());
			ps.setBoolean(3, Atleta.isSituacao()); 
			 
			System.out.println(">>ALTERAR:"+Atleta.getNome());
			int retorno = ps.executeUpdate();
			 
			if (retorno == 0) {
				throw new SQLException("Alteracao do Atleta falhou");
			}			 
			
		} catch (SQLException e2) {
			System.out.printf("Erro:%s",e2.getMessage());
			throw new SQLException("Alteracao do Atleta falhou");
		}

	}

	 

	@Override
	public ArrayList<Atleta> listarTodos() throws SQLException {
		 
		String sql="SELECT  nome,cpf FROM Atleta;";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();

		ArrayList<Atleta> Atletas=new ArrayList<Atleta>();
		while(rs.next()){
			 
				Atleta e=new Atleta();
				e.setNome(rs.getString("nome"));
				e.setCpf(rs.getString("cpf"));
				//e.setPosicao(PosicaoAtletaEnum.getEnum(rs.getString("posicaoJogadorEnum")));
				//e.setTitular(rs.getBoolean("isTitular"));  
				  
				Atletas.add(e);
		 		 
			 	 
		}
		return Atletas;
	}

	@Override
	public void excluir(Atleta Atleta)  throws SQLException{
		try {			 
			 
			String sql = "DELETE from Atleta Where idAtleta=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Atleta.getCodigo());		 
			System.out.println(">>Excluir:"+Atleta.getCodigo());
			ps.execute();
			 
					 
			
		} catch (SQLException e2) {
			System.out.printf("Erro:%s",e2.getMessage());
			throw new SQLException("Exclusao do Atleta falhou");
		}
		
	}
 
	@Override
	public Atleta listarPorCodigo(int condigo) throws SQLException {
		try {
			Atleta e=(Atleta)this.funcionarioMySqlRepositorio.listarPorCodigo(condigo);
			String sql = " select idFuncionario, posicaoJogadorEnum, isTitular FROM Atleta Where idFuncionario=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e.getCodigo());
			ResultSet rs = ps.executeQuery();
			rs.next();			 
			e.setCodigo(rs.getInt("idFuncionario"));
			e.setPosicao(PosicaoAtletaEnum.getEnum(rs.getString("posicaoJogadorEnum")) );
			e.setSituacao(rs.getBoolean("isTitular")); 
			return e;
		} catch (SQLException e2) {
			System.out.printf("Erro:%s",e2.getMessage());
			throw new SQLException("ListarPorCodigo do Atleta falhou");
		}
	}
 
	public Atleta listarPorCpf(String cpf) throws SQLException {
		try {
			
			Atleta e=(Atleta)this.funcionarioMySqlRepositorio.listarPorCpf(cpf);
			String sql = "SELECT idFuncionario, posicaoJogadorEnum, isTitular FROM Atleta FROM Atleta Where cpf=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getCpf());
			ResultSet rs = ps.executeQuery();
			rs.next();

			e.setCodigo(rs.getInt("idFuncionario"));
			e.setPosicao(PosicaoAtletaEnum.getEnum(rs.getString("posicaoJogadorEnum")) );
			e.setSituacao(rs.getBoolean("isTitular")); 
			return e;
		} catch (SQLException e2) {
			System.out.printf("Erro:%s",e2.getMessage());
			throw new SQLException("ListarPorCpf do Atleta falhou");
		}
	}
	 
	@Override
	public ArrayList<Atleta> persquisarPorPosicao(PosicaoAtletaEnum posicao) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Atleta> persquisarPorCamisaNumero(int numeroCamisa) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
 
	 

}
