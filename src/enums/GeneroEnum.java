package enums;

public enum GeneroEnum {
	Transgenero("Transg�nero"),Cisgenero("Cisg�nero"), NaoBinario("N�o-bin�rio");
	private String descricao;

	GeneroEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.getDescricao();
	}

	public static GeneroEnum getEnum(String value) {
		if (value == null)
			throw new IllegalArgumentException();
		for (GeneroEnum v : values())
			if (value.equalsIgnoreCase(v.getDescricao()))
				return v;
		throw new IllegalArgumentException();
	}
}
