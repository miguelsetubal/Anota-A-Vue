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
import dao.ClienteDAO;
import dao.ProdutosDAO;
import model.Cliente;
import model.Produtos;



@WebServlet("/api/clientes/*")
public class ClienteService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClienteService() {
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

		Cliente cliente = null;
		
		JSONObject jsonObject = null;

		try {
			// Request
			jsonObject = new JSONObject(jb.toString());
			cliente = ClienteDAO.addCliente(jsonObject.getString("nome"), jsonObject.getString("email"),jsonObject.getString("senha"),jsonObject.getInt("acesso"), jsonObject.getString("cpf"), jsonObject.getString("telefone"), jsonObject.getString("matricula"), jsonObject.getString("curso"), jsonObject.getInt("periodo"));

			// Response
			jsonObject = new JSONObject();
			jsonObject.put("id", cliente.getId());
			jsonObject.put("nome", cliente.getNome());
			jsonObject.put("email", cliente.getEmail());
			jsonObject.put("senha", cliente.getSenha());
			jsonObject.put("acesso", cliente.getAcesso());
			jsonObject.put("cpf", cliente.getCpf());
			jsonObject.put("telefone", cliente.getTelefone());
			jsonObject.put("matricula", cliente.getMatricula());
			jsonObject.put("curso", cliente.getCurso());
			jsonObject.put("periodo", cliente.getPeriodo());

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
		List<Cliente> list = ClienteDAO.getAllClientes();

		try {
			JSONArray jArray = new JSONArray();

			for (Cliente cliente : list) {
				JSONObject jsonObject = new JSONObject();

				jsonObject.put("id", cliente.getId());
				jsonObject.put("nome", cliente.getNome());
				jsonObject.put("email", cliente.getEmail());
				jsonObject.put("senha", cliente.getSenha());
				jsonObject.put("acesso", cliente.getAcesso());
				jsonObject.put("cpf", cliente.getCpf());				
				jsonObject.put("id_user", cliente.getId_user());
				jsonObject.put("telefone", cliente.getTelefone());
				jsonObject.put("matricula", cliente.getMatricula());
				jsonObject.put("curso", cliente.getCurso());
				jsonObject.put("periodo", cliente.getPeriodo());
				
				
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
