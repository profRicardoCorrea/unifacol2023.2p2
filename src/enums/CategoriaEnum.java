package enums;

public enum CategoriaEnum {
Infantil("Infantil"),Juvenil("Juvenil"),Adulto("Adulto"), Master("Master");
	private String descricao;

	CategoriaEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.getDescricao();
	}

	public static CategoriaEnum getEnum(String value) {
		if (value == null)
			throw new IllegalArgumentException();
		for (CategoriaEnum v : values())
			if (value.equalsIgnoreCase(v.getDescricao()))
				return v;
		throw new IllegalArgumentException();
	}
}
