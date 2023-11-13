package entidades;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
public abstract class EntidadeBasica {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	

}
