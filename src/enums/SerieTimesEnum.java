package enums;

public enum SerieTimesEnum {
	A("Série A"),B("Série B"),C("Série C"),D("Série D");
	
	private String descricao;
		
	SerieTimesEnum(String descricao) {
			this.descricao = descricao;
		}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.getDescricao();
	}

	public static SerieTimesEnum getEnum(String value) {
		if (value == null)
			throw new IllegalArgumentException();
		for (SerieTimesEnum v : values())
			if (value.equalsIgnoreCase(v.getDescricao()))
				return v;
		throw new IllegalArgumentException();
	}

}
