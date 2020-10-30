package br.ufc.web.anotaai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="produtos")
public class Produto {
	
	@Id
    @GeneratedValue
    int id;
	String descricao;
	float valor;
	
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
	public Produto(int id, String descricao, float valor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}
	public Produto(String descricao, float valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}
	public Produto() {		
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", valor=" + valor + "]";
	}
	
			

}
