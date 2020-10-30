package br.ufc.web.anotaai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.web.anotaai.model.User;
import br.ufc.web.anotaai.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public User addUser(String nome, String email, String senha, Integer acesso, String cpf) {
		
		if(nome.length() < 10 || senha.length() <8) {
			return null;
		}else if(cpf == "" ||
		        cpf.length() < 11 ||
		        cpf == "00000000000" ||
		        cpf == "11111111111" ||
		        cpf == "22222222222" ||
		        cpf == "33333333333" ||
		        cpf == "44444444444" ||
		        cpf == "55555555555" ||
		        cpf == "66666666666" ||
		        cpf == "77777777777" ||
		        cpf == "88888888888" ||
		        cpf == "99999999999") {
			return null;
			
		}else {
		
		User user = new User(nome, email, senha, acesso, cpf);
		return userRepo.save(user);
		}
	}
	
	public User updateUser(Integer id, String nome, String email, String senha, String cpf) {
        User userAux = userRepo.findById(id).get();
        
        if(nome.length() < 10 || senha.length() <8) {
			return null;
		}else if(cpf == "" ||
		        cpf.length() < 11 ||
		        cpf == "00000000000" ||
		        cpf == "11111111111" ||
		        cpf == "22222222222" ||
		        cpf == "33333333333" ||
		        cpf == "44444444444" ||
		        cpf == "55555555555" ||
		        cpf == "66666666666" ||
		        cpf == "77777777777" ||
		        cpf == "88888888888" ||
		        cpf == "99999999999") {
			return null;
			
		}else {
        if(userAux != null) {
            userAux.setNome(nome);
            userAux.setEmail(email);
            userAux.setSenha(senha);
            userAux.setCpf(cpf);            
            userRepo.save(userAux);         
        }
        
        return userAux;
		}
    }
	
	public User getUserByEmailSenha(String email, String senha) {
		User user = userRepo.findByEmailAndSenha(email, senha);
		return user;
	}

	public boolean removeUser(Integer id) {
		if (userRepo.existsById(id)) {
			userRepo.deleteById(id);
			return true;
		}

		return false;
	}
	
	public List<User> getFuncionarios(){
		return userRepo.findByTipo();
	}

	public List<User> getUsers() {
		return userRepo.findAll();
	}

	public User getUser(Integer id) {		
		return userRepo.findById(id).get();
	}
	
	public List<User> getUserByCPF(String cpf) {
		 List<User> user = userRepo.findByCPF(cpf);
		 return user;
	 }

}
