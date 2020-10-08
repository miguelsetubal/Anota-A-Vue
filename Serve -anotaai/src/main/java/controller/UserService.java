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

import dao.UserDAO;
import model.User;

@WebServlet("/api/users/*")
public class UserService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserService() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// GET BY ID
		String pathInfo = request.getPathInfo();

		if (pathInfo != null) {
			String[] params = pathInfo.split("/");

			if (params.length > 0) {
				User user = UserDAO.getUser(Integer.parseInt(params[1]));

				if (user != null) {
					JSONObject jsonObject = new JSONObject();

					jsonObject.put("id", user.getId());
					jsonObject.put("nome", user.getNome());
					jsonObject.put("email", user.getEmail());
					jsonObject.put("senha", user.getSenha());
					jsonObject.put("acesso", user.getAcesso());
					jsonObject.put("cpf", user.getCpf());

					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().print(jsonObject.toString());
					response.getWriter().flush();
				}
				return;
			}
		}
		
		// GET BY NAME
        if (request.getParameter("login") != null) {
        	System.out.println(request.getParameter("login"));
        	System.out.println(request.getParameter("password"));
        	
            User user = UserDAO.getUserByLogin(request.getParameter("login"));
 
            if (user != null) {
 
                JSONObject jsonObject = new JSONObject();
 
                jsonObject.put("id", user.getId());
				jsonObject.put("nome", user.getNome());
				jsonObject.put("email", user.getEmail());
				jsonObject.put("senha", user.getSenha());
				jsonObject.put("acesso", user.getAcesso());
				jsonObject.put("cpf", user.getCpf());
				
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print(jsonObject.toString());
                response.getWriter().flush();
 
            }
            return;
        }

		// GET ALL
		List<User> list = UserDAO.getAllFuncionarios();

		try {
			JSONArray jArray = new JSONArray();

			for (User user : list) {
				JSONObject jsonObject = new JSONObject();

				jsonObject.put("id", user.getId());
				jsonObject.put("nome", user.getNome());
				jsonObject.put("email", user.getEmail());
				jsonObject.put("senha", user.getSenha());
				jsonObject.put("acesso", user.getAcesso());
				jsonObject.put("cpf", user.getCpf());
				
				jArray.put(jsonObject);
			}

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jArray.toString());
			response.getWriter().flush();
		} catch (Exception e) {

		}

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

		User user = null;
		JSONObject jsonObject = null;

		try {
			// Request
			jsonObject = new JSONObject(jb.toString());
			user = UserDAO.addUser(jsonObject.getString("nome"), jsonObject.getString("email"),jsonObject.getString("senha"),jsonObject.getInt("acesso"), jsonObject.getString("cpf") );

			// Response
			jsonObject = new JSONObject();
			jsonObject.put("id", user.getId());
			jsonObject.put("nome", user.getNome());
			jsonObject.put("email", user.getEmail());
			jsonObject.put("senha", user.getSenha());
			jsonObject.put("acesso", user.getAcesso());
			jsonObject.put("cpf", user.getCpf());

		} catch (JSONException e) {
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonObject.toString());
		response.getWriter().flush();
	}
	
	
	
	

}
