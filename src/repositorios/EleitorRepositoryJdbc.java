package repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

 
import util.ConnectionFactory;

public class TimeRepositoryJdbc implements IBaseRepositorio<Time>,ITimeRespositorioJDBC {

	private Connection conn;
 

	public TimeRepositoryJdbc() throws SQLException {

		this.conn = ConnectionFactory.createConnection();
		 
	}
	
	 
	@Override
	public long salvar(Time e) throws SQLException   {

		try {			 
			e.getEndereco().setId(this.enderecoRepositoryJdbc.salvar(e.getEndereco()));
			e.getEleitoral().setId(this.enderecoEleitoralRepositoryJdbc.salvar(e.getEleitoral()));	
			
			String sqlEleitor = "INSERT INTO urnaeletronica.eleitor"
					+ "(titulo,nome,cpf,dataNascimento,rg,sexo,reservista,situacao,idEndereco,idEnderecoEleitoral,dataCadastro)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sqlEleitor, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, e.getTitulo());
			ps.setString(2, e.getNome());
			ps.setString(3, e.getCpf());
			ps.setDate(4, new java.sql.Date(e.getDataNascimento().getTime()));
			ps.setString(5, e.getRg());
			ps.setString(6, e.getSexo().getDescricao());
			ps.setString(7, e.getNumReservista());
			ps.setString(8, e.getSituacao().getDescricao());
			ps.setLong(9, e.getEndereco().getId());
			ps.setLong(10, e.getEleitoral().getId());
			ps.setDate(11, new java.sql.Date(e.getDataCadastro().getTime()));

			// Executa a instrução
			System.out.println("AQUIsalvar1");
			int retornoEleitor = ps.executeUpdate();
			System.out.println("AQUIsalvar2");
			if (retornoEleitor == 0) {
				throw new SQLException("Persistencia do Eleitor falhou , ID do Eleitor não foi gerado.");
			}

			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getLong(1);
					
				} else {
					throw new SQLException("Persistencia do Endereço Eleitoral falhou , ID do endereço Eleitoral não foi gerado.");
				}
			}
			
		} catch (SQLException e2) {
			System.out.printf("Erro:%s",e2.getMessage());
			throw new SQLException("Persistencia do Eleitor falhou.");
		}

	}

	@Override
	public void alterar(Eleitor e) throws SQLException {
		try {			 
			 
			String sqlEleitor = "UPDATE urnaeletronica.eleitor "
					+ "SET titulo=?,nome=?,dataNascimento=?,"
					+ "rg=?,sexo=?,reservista=?,situacao=?,idEndereco=?,idEnderecoEleitoral=?,dataCadastro=?"
					+ "Where cpf=?;";
			PreparedStatement ps = conn.prepareStatement(sqlEleitor);
			ps.setString(1, e.getTitulo());
			ps.setString(2, e.getNome());			
			ps.setDate(3, new java.sql.Date(e.getDataNascimento().getTime()));
			ps.setString(4, e.getRg());
			ps.setString(5, e.getSexo().getDescricao());
			ps.setString(6, e.getNumReservista());
			ps.setString(7, e.getSituacao().getDescricao());
			ps.setLong(8, e.getEndereco().getId());
			ps.setLong(9, e.getEleitoral().getId());
			ps.setDate(10, new java.sql.Date(e.getDataCadastro().getTime()));
			ps.setString(11, e.getCpf());
			System.out.println(">>ALTERAR:"+e.getNome());
			int retornoEleitor = ps.executeUpdate();
			 
			if (retornoEleitor == 0) {
				throw new SQLException("Altecao do Eleitor falhou , ID do Eleitor não foi gerado.");
			}			 
			
		} catch (SQLException e2) {
			System.out.printf("Erro:%s",e2.getMessage());
			throw new SQLException("Persistencia do Eleitor falhou.");
		}

	}

	@Override
	public void remover(Eleitor e) throws SQLException {
		try {			 
			 
			String sqlEleitor = "DELETE FROM urnaeletronica.eleitor WHERE cpf=?";
					 
			PreparedStatement ps = conn.prepareStatement(sqlEleitor);
			ps.setString(1, e.getCpf());
			 
			System.out.println(">>DELETE "+e.getCpf());
			int retornoEleitor = ps.executeUpdate();
			 
			if (retornoEleitor == 0) {
				throw new SQLException("Deleção do Eleitor falhou.");
			}			 
			
		} catch (SQLException e2) {
			System.out.printf("Erro:%s",e2.getMessage());
			throw new SQLException("Persistencia do Eleitor falhou.");
		}

	}

	@Override
	public ArrayList<Eleitor> listarTodos() throws SQLException {
		String sql="SELECT idEleitor, titulo,nome,cpf,dataNascimento,rg,sexo,reservista,situacao,idEndereco,idEnderecoEleitoral,dataCadastro FROM urnaeletronica.eleitor;";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();

		ArrayList<Eleitor> eleitores=new ArrayList<Eleitor>();
		while(rs.next()){
			Eleitor e=new Eleitor();
			e.setId(rs.getInt("idEleitor"));
			e.setTitulo(rs.getString("titulo"));
			e.setNome(rs.getString("nome"));
			e.setRg(rs.getString("rg"));
			e.setCpf(rs.getString("cpf"));			 
			e.setDataNascimento(rs.getDate("dataNascimento"));
			e.setSexo(SexoEnum.getEnum(rs.getString("sexo")));
			e.setNumReservista(rs.getString("reservista"));
			e.setSituacao(EleitorSituacaoEnum.getEnum(rs.getString("situacao")));
			e.setDataCadastro(rs.getDate("dataCadastro"));
			e.setEndereco(this.enderecoRepositoryJdbc.consultarPorId(rs.getLong("idEndereco")));
			e.setEnderecoEleitoral(this.enderecoEleitoralRepositoryJdbc.consultarPorId(rs.getLong("idEnderecoEleitoral")));
			
		 
			eleitores.add(e);
			
			 
		}
		return eleitores;
	}

	@Override
	public Eleitor listarPorCpf(String cpf) throws SQLException {
		String sql="SELECT idEleitor, titulo,nome,cpf,dataNascimento,rg,sexo,reservista,situacao,idEndereco,idEnderecoEleitoral,dataCadastro FROM urnaeletronica.eleitor Where cpf=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, cpf);
		ResultSet rs = ps.executeQuery();
		rs.next(); 
		 
		Eleitor e=new Eleitor();
		e.setId(rs.getInt("idEleitor"));
		e.setTitulo(rs.getString("titulo"));
		e.setNome(rs.getString("nome"));
		e.setRg(rs.getString("rg"));
		e.setCpf(rs.getString("cpf"));
		e.setDataNascimento(rs.getDate("dataNascimento"));
		e.setSexo(SexoEnum.getEnum(rs.getString("sexo")));
		e.setNumReservista(rs.getString("reservista"));
		e.setSituacao(EleitorSituacaoEnum.getEnum(rs.getString("situacao")));
		e.setDataCadastro(rs.getDate("dataCadastro"));
		e.setEndereco(this.enderecoRepositoryJdbc.consultarPorId(rs.getLong("idEndereco")));
		e.setEnderecoEleitoral(this.enderecoEleitoralRepositoryJdbc.consultarPorId(rs.getLong("idEnderecoEleitoral")));
			 
			 
		return e;
	}

	@Override
	public Eleitor listarPorTitulo(String titulo) throws SQLException {
		String sql="SELECT idEleitor,titulo,nome,cpf,dataNascimento,rg,sexo,reservista,situacao,idEndereco,idEnderecoEleitoral,dataCadastro FROM urnaeletronica.eleitor Where titulo=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, titulo);
		ResultSet rs = ps.executeQuery();
		rs.next(); 
		Eleitor e=new Eleitor();
		e.setId(rs.getInt("idEleitor"));
		e.setTitulo(rs.getString("titulo"));
		e.setNome(rs.getString("nome"));
		e.setCpf(rs.getString("cpf"));
		e.setDataNascimento(rs.getDate("dataNascimento"));
		e.setSexo(SexoEnum.getEnum(rs.getString("sexo")));
		e.setNumReservista(rs.getString("reservista"));
		e.setSituacao(EleitorSituacaoEnum.getEnum(rs.getString("situacao")));
		e.setDataCadastro(rs.getDate("dataCadastro"));
		e.setEndereco(this.enderecoRepositoryJdbc.consultarPorId(rs.getLong("idEndereco")));
		e.setEnderecoEleitoral(this.enderecoEleitoralRepositoryJdbc.consultarPorId(rs.getLong("idEnderecoEleitoral")));	 
			 
		return e;
	}

}
