package menu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cricket.data.Player;
import cricket.data.PlayerDao;

/**
 * Servlet implementation class DisplayAll
 */
@WebServlet("/DisplayAll")
public class DisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>All Players List</h1>");
		List<Player> list = PlayerDao.display();
		out.print("<table border='1' width='100%'");  
        
        out.print("<tr><th>Id</th><th>Name</th><th>Player type</th><th>Matches Played</th><th>Runs</th><th>Wickets</th><th>Out On Zero</th><th>Average Score</th></tr>");  
       
        for(Player e:list)
        {  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPlayer_type()+"</td><td>"+e.getMatches_played()+"</td><td>"+e.getRuns()+"</td><td>"+e.getWickets()+"</td><td>"+e.getOut_on_zero()+"</td><td>"+e.getAvg_score()+"</td><td></tr>");  
        }  
        out.print("</table>");  
          
        out.close(); 
	}
		
		
		
	}

