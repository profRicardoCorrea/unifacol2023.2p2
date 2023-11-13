package enums;

public enum TipoFuncionario {
Contratado("Contratado"), Clt("Clt"), Diarista("Diarista"), Mensalista("Mensalista");
	private String descricao;

	TipoFuncionario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.getDescricao();
	}

	public static TipoFuncionario getEnum(String value) {
		if (value == null)
			throw new IllegalArgumentException();
		for (TipoFuncionario v : values())
			if (value.equalsIgnoreCase(v.getDescricao()))
				return v;
		throw new IllegalArgumentException();
	}
}
