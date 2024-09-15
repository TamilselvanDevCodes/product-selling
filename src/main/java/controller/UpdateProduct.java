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
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import dao.ProductDao;
import dto.ProductDto;

@WebServlet("/updateproduct")
@MultipartConfig(maxFileSize = 1024*1024*1024*5)
public class UpdateProduct extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("newname");
		String brand = req.getParameter("newbrand");
		double price = Double.parseDouble(req.getParameter("newprice"));
		double discount = Double.parseDouble(req.getParameter("newdiscount"));
		Part image = req.getPart("newimage");
		
		ProductDto product = new ProductDto();
		if(image.getSize()>1)
		{
			product.setImage(image.getInputStream().readAllBytes());
		}
		else
		{
			ProductDao pdao = new ProductDao();
			try {
				ProductDto p = pdao.findProductById(id);
				product.setImage(p.getImage());
						
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		product.setId(id);
		product.setName(name);
		product.setBrand(brand);
		product.setPrice(price);
		product.setDiscount(discount);
		
		ProductDao pdao = new ProductDao();
		try {
		int res = pdao.updateProduct(product);
		if(res == 1) 
		{
			req.setAttribute("products", pdao.findAll());
			req.setAttribute("updateMessage", "*PRODUCT DETAILS UPDATED SUCCESSFULLY ");
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.include(req, resp);
		}
		else
		{
			req.setAttribute("message", "*ENTER VALID DETAILS");
			RequestDispatcher dispatcher = req.getRequestDispatcher("editproduct.jsp");
			dispatcher.include(req, resp);
		}
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}

	}
}
