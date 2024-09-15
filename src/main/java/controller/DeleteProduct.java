package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;

@WebServlet("/deleteproduct")
public class DeleteProduct extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDao pdao = new ProductDao();
		int id = Integer.parseInt(req.getParameter("id"));
		try {
				HttpSession ses = req.getSession();
				String email = (String)ses.getAttribute("email");
				
				if(email!=null)
				{
					int res = pdao.deleteProduct(id);
					req.setAttribute("products", pdao.findAll());
					req.setAttribute("deleteMessage", "*PRODUCT DETAILS DELETED SUCCESSFULLY ");
					RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
					dispatcher.include(req, resp);
				}
				else
				{
					req.setAttribute("logmessage","*LOGIN REQUIRED");
					RequestDispatcher dispatcher =  req.getRequestDispatcher("login.jsp");
					dispatcher.include(req, resp);
					
				}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
