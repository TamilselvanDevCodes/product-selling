package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import dao.SellerDao;
import dto.SellerDto;
@WebServlet("/login")
public class Login extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		SellerDao sdao = new SellerDao();
			try {
				SellerDto s = sdao.findByEmail(email);
				ProductDao pdao = new ProductDao();
				if( s != null)
				{
					
					if(s.getPassword().equals(password))
					{
						HttpSession ses = req.getSession();
						ses.setAttribute("email", email);
						
						req.setAttribute("products", pdao.findAll());
						req.setAttribute("loginMessage", "LOGIN SUCCESSFUL. WELCOME MR."+s.getName().toUpperCase()+",");
						RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
						dispatcher.include(req, resp);
					}
					else
					{
						req.setAttribute("message", "*INVALID PASSWORD");
						RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
						dispatcher.include(req, resp);						
					}
				}
				else
				{
					req.setAttribute("message", "*INVALID EMAIL");
					RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
					dispatcher.include(req, resp);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
}
