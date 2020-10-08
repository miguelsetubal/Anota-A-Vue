package model;

public class Cliente extends User {	
	int id;
	int id_user;
	String telefone;
	String matricula;
	String curso;
	int periodo;		

	public Cliente(int id, String nome, String email, String senha, int acesso, String cpf, int id_user,
			String telefone, String matricula, String curso, int periodo) {
		super(id_user, nome, email, senha, acesso, cpf);
		this.id = id;
		this.id_user = id_user;
		this.telefone = telefone;
		this.matricula = matricula;
		this.curso = curso;
		this.periodo = periodo;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", id_user=" + id_user + ", telefone=" + telefone + ", matricula=" + matricula
				+ ", curso=" + curso + ", periodo=" + periodo + ", nome=" + nome + ", email=" + email + ", senha="
				+ senha + ", acesso=" + acesso + ", cpf=" + cpf + "]";
	}



	public int getId() {
		return id;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
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
	
	
	}
