package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ProductDao;
import dao.SellerDao;
import dto.ProductDto;
import dto.SellerDto;

@WebServlet("/addproduct")
@MultipartConfig(maxFileSize = 1024*1024*1024*5)
public class AddProduct extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String brand = req.getParameter("brand");
		double price = Double.parseDouble(req.getParameter("price"));
		double discount = Double.parseDouble(req.getParameter("discount"));
		Part image = req.getPart("image");
		
		ProductDto product = new ProductDto();
		product.setImage(image.getInputStream().readAllBytes());
		product.setId(id);
		product.setName(name);
		product.setBrand(brand);
		product.setPrice(price);
		product.setDiscount(discount);
		
		ProductDao pdao = new ProductDao();
		try {
			 
			int res = pdao.saveProduct(product);
			if(res == 1)
			{
				
				req.setAttribute("products", pdao.findAll());
				req.setAttribute("addMessage", "*SUCCESSFULLY ADDED THE PRODUCT ");
				RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
				dispatcher.include(req, resp);
			}
			else
			{
				req.setAttribute("notAddMessage", "*PRODUCT SAVING FAILED ");
				RequestDispatcher dispatcher = req.getRequestDispatcher("addproduct.jsp");
				dispatcher.include(req, resp);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
