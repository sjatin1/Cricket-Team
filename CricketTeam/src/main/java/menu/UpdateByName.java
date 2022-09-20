package menu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cricket.data.PlayerDao;

/**
 * Servlet implementation class UpdateByName
 */
@WebServlet("/UpdateByName")
public class UpdateByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("pname");
		String type = request.getParameter("dat_type");
		String data = request.getParameter("data");
		
		double pdata = Double.parseDouble(data);
		
		PlayerDao.update_by_name(name, type, pdata);
		response.sendRedirect("index.html");
		
	}

}
