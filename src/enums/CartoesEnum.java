package enums;

 

public enum CartoesEnum {
	Amarelo("Amarelo"),
	Vermelho("Vermelho");
	
	private String descricao;

	CartoesEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.getDescricao();
	}

	public static CartoesEnum getEnum(String value) {
		if (value == null)
			throw new IllegalArgumentException();
		for (CartoesEnum v : values())
			if (value.equalsIgnoreCase(v.getDescricao()))
				return v;
		throw new IllegalArgumentException();
	}
}
