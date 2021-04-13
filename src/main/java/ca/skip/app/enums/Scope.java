package ca.skip.app.enums;

public enum Scope {
	BY_FUNCTIONALITY("0"),
	BY_APPLICATION("1");
 
    private String descricao;
 
	Scope(String descricao) {
		this.descricao = descricao;
		getDescricao();
	}

	public String getDescricao() {
		return descricao;
	}
}
