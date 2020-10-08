package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import util.DbUtil;

public class ClienteDAO {
	private static Connection connection = DbUtil.getConnection();
	
	public static Cliente addCliente(String nome, String email, String senha, int acesso, String cpf, String telefone, String matricula, String curso, int periodo) {
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
            rs.next();
            
            PreparedStatement pStmt2 = connection.prepareStatement("INSERT INTO clientes(id_user, telefone, matricula, curso, periodo) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pStmt2.setInt(1, rs.getInt("id"));
            pStmt2.setString(2, telefone);
            pStmt2.setString(3, matricula);
            pStmt2.setString(4, curso);
            pStmt2.setInt(5, periodo);
            pStmt2.executeUpdate();
           ResultSet rs2 = pStmt2.getGeneratedKeys();
           if (rs2.next()) {
               return new Cliente(rs2.getInt("id"), rs2.getString("nome"), rs2.getString("email"), rs2.getString("senha"), rs2.getInt("acesso"), rs2.getString("cpf"), rs2.getInt("id_user"), rs2.getString("telefone"), rs2.getString("matricula"), rs2.getString("curso"), rs2.getInt("periodo"));
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
	
	public static List<Cliente> getAllClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from clientes inner join users ON clientes.id_user = users.id WHERE users.acesso = 2");
            
            while (rs.next()) {
                Cliente user = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getInt("acesso"), rs.getString("cpf"), rs.getInt("id_user"), rs.getString("telefone"), rs.getString("matricula"), rs.getString("curso"), rs.getInt("periodo"));
                clientes.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return clientes;
    }
	

}
