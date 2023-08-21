package enums;

 
public enum TimeStatusEnum {
	ATIVO("Ativo"),INATIVO("Inativo"),SUSPENSO("Suspenso");
	
	private String descricao;
	
	TimeStatusEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.getDescricao();
	}

	public static TimeStatusEnum getEnum(String value) {
		if (value == null)
			throw new IllegalArgumentException();
		for (TimeStatusEnum v : values())
			if (value.equalsIgnoreCase(v.getDescricao()))
				return v;
		throw new IllegalArgumentException();
	}

}
