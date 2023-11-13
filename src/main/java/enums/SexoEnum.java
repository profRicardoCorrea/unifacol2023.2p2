package enums;

public enum SexoEnum {
	Masculino("Masculino"),Feminino("Feminino"), Outros("Outros");
	private String descricao;

	SexoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.getDescricao();
	}

	public static SexoEnum getEnum(String value) {
		if (value == null)
			throw new IllegalArgumentException();
		for (SexoEnum v : values())
			if (value.equalsIgnoreCase(v.getDescricao()))
				return v;
		throw new IllegalArgumentException();
	}
}
