package menu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cricket.data.Player;
import cricket.data.PlayerDao;

/**
 * Servlet implementation class Display11
 */
@WebServlet("/Display11")
public class Display11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String cn = request.getParameter("cnt");
		int cnt = Integer.parseInt(cn);
		List<Player> final_team = new ArrayList<>();
		
		if(cnt>=3) {
		out.println("<h1>Playing 11</h1>");
		List<Player> list = PlayerDao.display_final_team(cnt);
		out.print("<table border='1' width='100%'");  
        
        out.print("<tr><th>Id</th><th>Name</th><th>Player type</th><th>Matches Played</th><th>Runs</th><th>Wickets</th><th>Out On Zero</th><th>Average Score</th></tr>");  
       
        for(Player e:list)
        {  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPlayer_type()+"</td><td>"+e.getMatches_played()+"</td><td>"+e.getRuns()+"</td><td>"+e.getWickets()+"</td><td>"+e.getOut_on_zero()+"</td><td>"+e.getAvg_score()+"</td><td></tr>");  
        }  
        out.print("</table>");  
          
        out.close(); 
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("display11.html");
			rd.include(request, response);
			out.println("");
			out.println("<center><font color = red> Minimum no. of bowlers should be 3 </font></center>");
		}
	}

}
