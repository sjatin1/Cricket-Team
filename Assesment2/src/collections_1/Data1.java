package collections_1;

import java.util.*;

class NameComparator implements Comparator<Data1>{

	@Override
	public int compare(Data1 d1, Data1 d2) {
		// TODO Auto-generated method stub
		return d1.getName().compareTo(d2.getName());
	}
}

/*class AvgComp implements Comparator<Data1>{
	public int compare(Data1 d1, Data1 d2) {
		return d1.getAvg_score().compareTo(d2.getAvg_score());
	}
}*/

public class Data1 implements Comparable<Data1>{
	public int id;
	public String player_type;
	public String name;
	public int matches_played;
	public double runs;
	public double wickets;
	public int out_on_zero;
	public double avg_score;

	public Data1(int id,String player_type,String name, int matches_played, double runs, double wickets, int out_on_zero, double avg_score) {
		this.id=id;
		this.player_type=player_type;
		this.name = name;
		this.matches_played = matches_played;
		this.runs = runs;
		this.wickets = wickets;
		this.out_on_zero = out_on_zero;
		this.avg_score=avg_score;
	}

	public Data1() {
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
	public int compareTo(Data1 d) {
		// TODO Auto-generated method stub
		return this.id-d.getId();
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Data1)) return false;
		Data1 data1 = (Data1) o;
		return getAvg_score()  ==  data1.getAvg_score() && getId() == data1.getId() && getMatches_played() == data1.getMatches_played() && Double.compare(data1.getRuns(), getRuns()) == 0 && Double.compare(data1.getWickets(), getWickets()) == 0 && getOut_on_zero() == data1.getOut_on_zero() && getPlayer_type().equals(data1.getPlayer_type()) && getName().equals(data1.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(),getPlayer_type(), getName(), getMatches_played(), getRuns(), getWickets(), getOut_on_zero(), getAvg_score());
	}

	

}
