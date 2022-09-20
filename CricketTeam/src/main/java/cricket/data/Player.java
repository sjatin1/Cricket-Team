package cricket.data;
import java.util.*;

class AvgComp implements Comparator<Player>{
	public int compare(Player d1, Player d2) {
		return (int) (d2.getAvg_score()-d1.getAvg_score());
	}
}

public class Player implements Comparable<Player>{
	public int id;
	public String player_type;
	public String name;
	public int matches_played;
	public double runs;
	public double wickets;
	public int out_on_zero;
	public double avg_score;

	public Player(int id,String player_type,String name, int matches_played, double runs, double wickets, int out_on_zero, double avg_score) {
		this.id=id;
		this.player_type=player_type;
		this.name = name;
		this.matches_played = matches_played;
		this.runs = runs;
		this.wickets = wickets;
		this.out_on_zero = out_on_zero;
		this.avg_score=avg_score;
	}

	public Player() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getPlayer_type() {
		return player_type;
	}

	public void setPlayer_type(String player_type) {
		this.player_type = player_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMatches_played() {
		return matches_played;
	}

	public void setMatches_played(int matches_played) {
		this.matches_played = matches_played;
	}

	public double getRuns() {
		return runs;
	}

	public void setRuns(double runs) {
		this.runs = runs;
	}

	public double getWickets() {
		return wickets;
	}

	public void setWickets(double wickets) {
		this.wickets = wickets;
	}

	public int getOut_on_zero() {
		return out_on_zero;
	}

	public void setOut_on_zero(int out_on_zero) {
		this.out_on_zero = out_on_zero;
	}
	
	public double getAvg_score() {
		return avg_score;
	}
	public void setAvg_score(double avg_score) {
		this.avg_score=avg_score;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Player)) return false;
		Player Player = (Player) o;
		return getAvg_score()  ==  Player.getAvg_score() && getId() == Player.getId() && getMatches_played() == Player.getMatches_played() && Double.compare(Player.getRuns(), getRuns()) == 0 && Double.compare(Player.getWickets(), getWickets()) == 0 && getOut_on_zero() == Player.getOut_on_zero() && getPlayer_type().equals(Player.getPlayer_type()) && getName().equals(Player.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(),getPlayer_type(), getName(), getMatches_played(), getRuns(), getWickets(), getOut_on_zero(), getAvg_score());
	}

	@Override
	public int compareTo(Player o) {
		// TODO Auto-generated method stub
		return this.id-o.getId();
	}

	

}


