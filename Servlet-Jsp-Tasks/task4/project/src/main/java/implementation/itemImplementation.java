package implementation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import services.itemServices;

public class itemImplementation implements itemServices {
	
	private DataSource dataSource;
	private PrintWriter printWriter = null;
	
	public itemImplementation(DataSource dataSource){
		this.dataSource = dataSource ;
	}

	@Override
	public void getItemByID(HttpServletRequest request, HttpServletResponse response) {
			String query = "select * from items where id = 1 or id = 2";
			selectItemsBy(response , query);
	}

	@Override
	public void getItemByName(HttpServletRequest request, HttpServletResponse response) {
		String query = "select * from items where product_name like'%i%'";
		selectItemsBy(response , query);
	}

	@Override
	public void getItemByPrice(HttpServletRequest request, HttpServletResponse response) {
		String query = "select * from items where price between 20 and 5000";
		selectItemsBy(response , query);
		
	}

	@Override
	public void saveItems(HttpServletRequest request, HttpServletResponse response) {
		try {
			printWriter = response.getWriter();
			// get my connection to start execute
			Connection connection = dataSource.getConnection();
			
			// Query for insert
			String query = "INSERT INTO items (product_name, product_quantity, price) VALUES ('pc' , 50 , 1100)";
			
			// create statement to execute the query 
			PreparedStatement  statement = connection.prepareStatement(query);
			
			// execute my Query
			int rowsInserted = statement.executeUpdate();
			
			printWriter.append("Rows inserted: " + rowsInserted);
		
		} catch (SQLException | IOException e) {
			 printWriter.append(e.getMessage());
		}
		
	}
	
	public void selectItemsBy( HttpServletResponse response ,String query ) {
		try {
			printWriter = response.getWriter();
			// get my connection to start execute
			Connection connection = dataSource.getConnection();
			PreparedStatement  statement = connection.prepareStatement(query);
			
			// execute my Query
			ResultSet resultSet = statement.executeQuery();
			
			// Looping on the table columns' 
			while (resultSet.next()) {
			    printWriter.append(resultSet.getInt("product_quantity") + "     ");
			    printWriter.append(resultSet.getString("product_name") + " ");
			    printWriter.append("\n");
			}

		} catch (SQLException | IOException e) {
			 printWriter.append(e.getMessage());
		}
		
	}

}
