package menu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cricket.data.Player;
import cricket.data.PlayerDao;

/**
 * Servlet implementation class AddPlayer
 */
@WebServlet("/AddPlayer")
public class AddPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String name = request.getParameter("pname");
		String mp = request.getParameter("mp");
		String runs = request.getParameter("runs");
		String wickets = request.getParameter("wickets");
		String type = request.getParameter("type");
		String oz = request.getParameter("oz");
		
		int pid = Integer.parseInt(id);
		int mpl = Integer.parseInt(mp);
		int ooz = Integer.parseInt(oz);
		double pruns = Double.parseDouble(runs);
		double pwickets = Double.parseDouble(wickets);
		
		double avg_score = pruns/mpl;
		
		Player p = new Player();
		p.setId(pid);
		p.setName(name);
		p.setMatches_played(mpl);
		p.setPlayer_type(type);
		p.setRuns(pruns);
		p.setWickets(pwickets);
		p.setOut_on_zero(ooz);
		p.setAvg_score(avg_score);
		
		PlayerDao.saveUser(p);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.forward(request, response);
		
	}

}
