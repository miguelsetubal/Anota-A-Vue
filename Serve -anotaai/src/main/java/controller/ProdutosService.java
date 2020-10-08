package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.ProdutosDAO;
import model.Produtos;

@WebServlet("/api/produtos/*")
public class ProdutosService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProdutosService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
		}

		Produtos produto = null;
		JSONObject jsonObject = null;

		try {
			// Request
			jsonObject = new JSONObject(jb.toString());
			produto = ProdutosDAO.addProduto(jsonObject.getString("descricao"), jsonObject.getFloat("valor"));

			// Response
			jsonObject = new JSONObject();
			jsonObject.put("id", produto.getId());
			jsonObject.put("descricao", produto.getDescricao());
			jsonObject.put("valor", produto.getValor());
			

		} catch (JSONException e) {
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonObject.toString());
		response.getWriter().flush();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// GET ALL
		List<Produtos> list = ProdutosDAO.getAllProdutos();

		try {
			JSONArray jArray = new JSONArray();

			for (Produtos produto : list) {
				JSONObject jsonObject = new JSONObject();

				jsonObject.put("id", produto.getId());
				jsonObject.put("descricao", produto.getDescricao());
				jsonObject.put("valor", produto.getValor());
				
				
				jArray.put(jsonObject);
			}

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jArray.toString());
			response.getWriter().flush();
		} catch (Exception e) {

		}
	}
}
