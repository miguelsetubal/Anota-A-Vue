package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Produtos;
import util.DbUtil;

public class ProdutosDAO {
	private static Connection connection = DbUtil.getConnection();
	public static Produtos addProduto(String descricao, float valor) {
        try {
            PreparedStatement pStmt = connection.prepareStatement("INSERT INTO produtos(descricao, valor) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pStmt.setString(1, descricao);
            pStmt.setFloat(2, valor);           
            pStmt.executeUpdate();
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                return new Produtos(rs.getInt("id"), rs.getString("descricao"), rs.getFloat("valor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
	

    public static List<Produtos> getAllProdutos() {
        List<Produtos> produtos = new ArrayList<Produtos>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM produtos order by id");
            while (rs.next()) {
                Produtos produto = new Produtos(rs.getInt("id"), rs.getString("descricao"), rs.getFloat("valor"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return produtos;
    }

}
