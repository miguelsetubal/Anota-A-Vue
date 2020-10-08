package dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import model.User;
import util.DbUtil;
 
public class UserDAO {
 
    private static Connection connection = DbUtil.getConnection();
 
    public static User addUser(String nome, String email, String senha, int acesso, String cpf) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("INSERT INTO users(nome, email, senha, acesso, cpf) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pStmt.setString(1, nome);
            pStmt.setString(2, email);
            pStmt.setString(3, senha);
            pStmt.setInt(4, acesso);
            pStmt.setString(5, cpf);
            pStmt.executeUpdate();
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getInt("acesso"), rs.getString("cpf"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
    
 
    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users order by id");
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getInt("acesso"), rs.getString("cpf"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return users;
    }
    
    public static List<User> getAllFuncionarios() {
        List<User> funcionarios = new ArrayList<User>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users WHERE acesso = 1");
            while (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getInt("acesso"), rs.getString("cpf"));
                funcionarios.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return funcionarios;
    }
 
    public static User getUser(int id) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("select * from users where id=?");
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getInt("acesso"), rs.getString("cpf"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
    
    public static User getUserByLoginAndPassword(String login, String password) {
		List<User> list = getAllUsers();

		for (User user : list) {
			if (user.getEmail().equals(login) && user.getSenha().equals(password)) {
				return user;
			}
		}

		return null;
	}
 
    public static User getUserByLogin(String login) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("select * from users where email=?");
            pStmt.setString(1, login);
            ResultSet rs = pStmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getInt("acesso"), rs.getString("cpf"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
}