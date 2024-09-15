package controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ProductDao;
import dto.ProductDto;

@WebServlet("/editproduct")
public class EditProduct extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ProductDao pdao = new ProductDao();
		
			
			try {
				HttpSession ses = req.getSession();
				String email = (String) ses.getAttribute("email");
				if(email != null)
				{
					ProductDto p = pdao.findProductById(id);
					req.setAttribute("product", p);
					RequestDispatcher dispatcher = req.getRequestDispatcher("editproduct.jsp");
					dispatcher.include(req, resp);
				}
				else
				{
					req.setAttribute("logmessage","*LOGIN REQUIRED");
					RequestDispatcher dispatcher =  req.getRequestDispatcher("login.jsp");
					dispatcher.include(req, resp);
					
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		
	}
}
