package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface itemServices {
	void getItemByID(HttpServletRequest request, HttpServletResponse response);
	void getItemByName(HttpServletRequest request, HttpServletResponse response);
	void getItemByPrice(HttpServletRequest request, HttpServletResponse response);
	void saveItems(HttpServletRequest request, HttpServletResponse response);
	
}
