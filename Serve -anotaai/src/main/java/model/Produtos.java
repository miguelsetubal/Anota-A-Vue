package model;

public class Produtos {
	int id;
	String descricao;
	float valor;
	
	@Override
	public String toString() {
		return "Produtos [id=" + id + ", descricao=" + descricao + ", valor=" + valor + "]";
	}

	public Produtos(int id, String descricao, float valor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}
