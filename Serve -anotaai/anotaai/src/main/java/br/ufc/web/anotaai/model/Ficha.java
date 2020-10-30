package br.ufc.web.anotaai.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="ficha")
public class Ficha {
	@Id
    @GeneratedValue
    int id;
	int id_cliente;
	int id_user;
	String data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Ficha(int id, int id_cliente, int id_user, String data) {
		super();
		this.id = id;
		this.id_cliente = id_cliente;
		this.id_user = id_user;
		this.data = data;
	}
	public Ficha(int id_cliente, int id_user, String data) {
		super();
		this.id_cliente = id_cliente;
		this.id_user = id_user;
		this.data = data;
	}
	public Ficha() {
	
	}
	
	
}
