package controller;

import java.io.IOException;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import implementation.itemImplementation;


@WebServlet("/itemController")
public class itemController extends HttpServlet {
	
	@Resource (name = "jdbc/connection")
	  private DataSource dataSource;
	
	itemImplementation itemImpl;

      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String action = request.getParameter("action");
		itemImpl = new itemImplementation(dataSource);
		if(Objects.isNull(action)) {
			response.getWriter().append("Invalid");
		}
		switch (action) {
		case "getItemByID":
			itemImpl.getItemByID(request , response);
			break;
		case "getItemByName":
			itemImpl.getItemByName(request , response );
			break;
		case "getItemByPrice" :
			itemImpl.getItemByPrice(request , response );
			break;
		case "saveItems":
			itemImpl.saveItems(request , response );
			break;
		default:
			response.getWriter().append("Invalid action");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
