package br.ufc.web.anotaai.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue
	long id;
	String telefone;
	String matricula;
	String curso;
	int periodo;
	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
     User user;
	

	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
