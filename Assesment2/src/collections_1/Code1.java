package collections_1;
import java.util.*;
public class Code1 {
	public double avg_score;
	public int id=0,cnt=0,flag=0;
	public String player_type=" ",name=" ";
	public int matches_played=0;
	public double runs=0,wickets=0;
	public int out_on_zero=0;
	public int total_players=20,i;
	List<Data1> data = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	public void hardcodeddata() {
		List<Data1> data1 = new ArrayList<>();
		data1.add(new Data1(1, "batsman","Joseph", 8, 190, 4, 5,  190/8));
		data1.add(new Data1(2, "bowler","Jose", 8, 200, 4, 5,  200/8));
		data1.add(new Data1(3, "bowler","Josph", 80, 1900, 4, 5,  1900/80));
		data1.add(new Data1(4, "batsman","Jseph", 18, 190, 4, 5,  190/18));
		data1.add(new Data1(5, "bowler","Jeph", 28, 190, 4, 5,  190/28));
		data1.add(new Data1(6, "batsman","oseph", 38, 190, 4, 5,  190/38));
		data1.add(new Data1(7, "bowler","Joh", 48, 190, 4, 5,  190/48));
		data1.add(new Data1(8, "batsman","Jeph", 58, 190, 4, 5,  190/58));
		data1.add(new Data1(9, "batsman","Jweoseph", 68, 190, 4, 5,  190/68));
		data1.add(new Data1(10, "batsman","Jofdsseph", 78, 190, 4, 5,  190/78));
		data1.add(new Data1(11, "batsman","Josefgph", 88, 190, 4, 5,  190/88));
		data1.add(new Data1(12, "batsman","Joseprdfdh", 98, 190, 4, 5,  190/98));
		data1.add(new Data1(13, "batsman","Josephgh", 108, 190, 4, 5,  190/108));
		data1.add(new Data1(14, "batsman","Josephr", 81, 190, 4, 5,  190/81));
		data1.add(new Data1(15, "batsman","Josephfht", 82, 190, 4, 5,  190/82));
		data1.add(new Data1(16, "batsman","Josepwsh", 83, 190, 4, 5,  190/83));
		data1.add(new Data1(17, "batsman","Josepyhgh", 84, 190, 4, 5,  190/84));
		data1.add(new Data1(18, "batsman","Josephjyt", 85, 190, 4, 5,  190/85));
		data1.add(new Data1(19, "batsman","Josepbprkh", 86, 190, 4, 5,  190/86));
		data1.add(new Data1(20, "batsman","Josepwrnh", 87, 190, 4, 5,  190/87));
		
		display(data1);
	}
	public void display(List<Data1> data) {
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%15s%10s%8s%8s%8s%8s%8s", "NAME" , "PLAYER_TYPE" , "MATCHES_PLAYED" , "RUNS" , "WICKETS" , "OUT_ON_ZERO" , "AVG_SCORE");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
		Iterator<Data1> itr2 = data.iterator();
		while(itr2.hasNext()) {
			Data1 d = itr2.next();
			System.out.printf("%20s%10s%8d%8f%8f1%8d%8f", d.name,d.player_type,d.matches_played,d.runs,d.wickets,d.out_on_zero,d.avg_score);
			System.out.println("");
		}
		
		//data.forEach((d)->System.out.printf("%20s%10s%8d%8d%8d%8d%8f", d.name,d.player_type,d.matches_played,d.runs,d.wickets,d.out_on_zero,d.avg_score));
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
	public void update_by_name() {
		String upname;
		System.out.println("Enter the name of the player to update the information");
		upname=sc.next();
		boolean found =false;
		Iterator<Data1> itr1 = data.iterator();
		while(itr1.hasNext()) {
			Data1 d = itr1.next();
			if(upname.equals(d.getName())) {
				found=true;
				boolean x=true;
				int update;
				while(x) {
					System.out.println("press 1 to update no. of matches played");
					System.out.println("press 2 to update no. of runs");
					System.out.println("press 3 to update no. of wickets");
					System.out.println("press 4 to update no. of Out on zeroes");
					System.out.println("press 5 to exit");
					update=sc.nextInt();
					switch(update) {
					case 1 :
						System.out.println("enter the updated matches played");
						int mp = sc.nextInt();
						d.setMatches_played(mp);
						d.setAvg_score(runs/mp);
						System.out.println("Matches Updated Successfully");
						break;
					case 2 :
						System.out.println("enter the updated runs");
						int rs = sc.nextInt();
						d.setRuns(rs);
						d.setAvg_score(rs/matches_played);
						System.out.println("Runs updated Successfully");
						break;
					case 3 :
						System.out.println("enter the updated wickets");
						int ws = sc.nextInt();
						d.setWickets(ws);
						System.out.println("Wickets updated successfully");
						break;
					case 4 :
						System.out.println("enter the updated out on zeroes");
						int os = sc.nextInt();
						d.setOut_on_zero(os);
						System.out.println("Out on Zeroes updated successfully");
						break;
					case 5 :
						x=false;
						break;
					default :
						System.out.println("Choose a valid number to update");
						System.out.println(" ");
					}
				}
			 }
		}
		 if(found==false){
			 try {
			 PlayerNotFoundException pnfe = new PlayerNotFoundException("Player name not matching with 20 people");
			 throw pnfe;
			 }
			 catch(PlayerNotFoundException pnfe) {
				 System.out.println(upname+ " name not found");
			 }
		 }
		
	}
	public void display_final_team() throws PlayerTypeNotFoundException {
		List<Data1> temp = new ArrayList<>();
		List<Data1> final_team = new ArrayList<>();
		temp=data;
		int bowler=0;
		System.out.println("Enter the no. of bowlers to be added in playing 11");
		bowler=sc.nextInt();
		if(bowler>cnt) {
			PlayerTypeNotFoundException ptnfe = new PlayerTypeNotFoundException("Player type not found in given 20 players ");
			throw(ptnfe);
		}
		Collections.sort(temp,new AvgComp());
		for(int j=1; j<=bowler;j++) {
			Iterator<Data1> itrr = temp.iterator();
			while(itrr.hasNext()) {
				Data1 dat2 = itrr.next();
				if(dat2.getPlayer_type().equals("bowler")) {
					final_team.add(dat2);
					temp.remove(dat2);
					break;
				}
			}
		}
		Collections.sort(temp,new AvgComp());
		Iterator<Data1> itr2 = temp.iterator();
		int rem = 11-bowler;
		while(itr2.hasNext()) {
			Data1 dat3 = itr2.next();
			final_team.add(dat3);
			rem--;
			if(rem==0) {
				break;
			}	
		}
		Collections.sort(final_team,new NameComparator());
		display(final_team);
	}
	public void add_info() {
		for(i=1; i<=total_players;i++) {
			System.out.println("Enter the details of the player : "+i);
			System.out.println("ID : ");
			id=sc.nextInt();
			System.out.println("Player Type : ");
			System.out.println("press 1 for bowler");
			System.out.println("press 2 for batsman");
			System.out.println("press 3 for wicketkeeper");
			System.out.println("press 4 for allrounder");
			int pt = sc.nextInt();
			switch(pt) {
			case 1 : player_type="bowler";
					break;
			case 2 : player_type="batsman";
					break;
			case 3 : player_type="wicket_keeper";
					break;
			case 4: player_type="allrounder";
					break;
			default: System.out.println("Player Type is batsman as the number does not match any above number");
					 player_type="batsman";
			}
			if(player_type.equals("wicket_keeper")) {
				flag++;
			}
			else if(player_type.equals("bowler")) {
				cnt++;
			}
			System.out.println("Name : ");
			name = sc.next();
			System.out.println("Matches Played : ");
			matches_played=sc.nextInt();
			System.out.println("Runs : ");
			runs=sc.nextDouble();
			System.out.println("Wickets : ");
			wickets=sc.nextDouble();
			System.out.println("Out On Zero : ");
			out_on_zero=sc.nextInt();
			avg_score=runs/matches_played;
			System.out.println("Average score is : "+avg_score);
			data.add(new Data1(id,player_type,name,matches_played,runs,wickets,out_on_zero,avg_score));
			}
	}
	public static void main(String[] args) throws PlayerTypeNotFoundException,PlayerNotFoundException{
		Scanner sc = new Scanner(System.in);
		List<Data1> data = new ArrayList<>();
		List<Data1> data1 = new ArrayList<>();
		int menu;
		boolean run=true;
		Code1 ob = new Code1();
		ob.hardcodeddata();
		while(run) {
			System.out.println("Press 1 to display all 20 players");
			System.out.println("Press 2 to update player information by name");
			System.out.println("Press 3 to display final team");
			System.out.println("Press 4 to add player information");
			System.out.println("Press 5 to exit");
		menu=sc.nextInt();
		switch(menu) {
		
		case 1 :
			Collections.sort(data,new NameComparator());
			Code1 c1 = new Code1();
			c1.display(data1);
			break;
		case 2 :
			Code1 c2 = new Code1();
			c2.update_by_name();
			break;
		case 3 :
			Code1 c3 = new Code1();
			c3.display_final_team();
			break;
		case 4 :
			Code1 c4 = new Code1();
			c4.add_info();
			break;		
		case 5 :
			run=false;
			System.out.println("Exit");
			break;
		default :
			System.out.println("Enter valid number");
			System.out.println(" ");
			}	
		}
	}
}
