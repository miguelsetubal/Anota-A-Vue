package br.ufc.web.anotaai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="users")
public class User {
	@Id
    @GeneratedValue
    int id;
	String nome;
	String email;
	String senha;
	int acesso;
	String cpf;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getAcesso() {
		return acesso;
	}
	public void setAcesso(int acesso) {
		this.acesso = acesso;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", acesso=" + acesso
				+ ", cpf=" + cpf + "]";
	}
	public User(int id, String nome, String email, String senha, int acesso, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.acesso = acesso;
		this.cpf = cpf;
	}
	
	public User(String nome, String email, String senha, int acesso, String cpf) {
		super();		
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.acesso = acesso;
		this.cpf = cpf;
	}
	
	public User() {
		
	}
		
}
