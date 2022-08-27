package collections_1;
import java.util.*;

public class Code1 {

	public static void main(String[] args) throws PlayerTypeNotFoundException,PlayerNotFoundException{
		Scanner sc = new Scanner(System.in);
		List<Data1> data = new ArrayList<>();
		double avg_score;
		int id=0,cnt=0,flag=0;
		String player_type=" ",name=" ";
		int matches_played=0;
		double runs=0,wickets=0;
		int out_on_zero=0;
		int total_players=20,i;
		int menu;
		boolean run=true;
		while(run) {
			System.out.println("Press 1 to display all 20 players");
			System.out.println("Press 2 to update player information by name");
			System.out.println("Press 3 to display final team");
			System.out.println("Press 4 to add player information");
			System.out.println("Press 5 to exit");
		menu=sc.nextInt();
		switch(menu) {
		case 1 :
		
			if((cnt>=3) && (flag<=1)) {
			data.forEach((d)->System.out.println("Player_Type : "+ d.player_type+" Name : "+d.name+" Matches Played : "+d.matches_played+" Runs : "+d.runs+" Wickets : "+d.wickets+" Out On Zero : "+d.out_on_zero+" Average Score :"+d.avg_score));
			}
			else {
				System.out.println("Add the details of the players with minimum 3 bowlers and maximum 1 wicketkeeper");
			}
			
			break;
		
		case 2 :
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
							break;
						case 2 :
							System.out.println("enter the updated runs");
							int rs = sc.nextInt();
							d.setRuns(rs);
							d.setAvg_score(rs/matches_played);
							break;
						case 3 :
							System.out.println("enter the updated wickets");
							int ws = sc.nextInt();
							d.setWickets(ws);
							break;
						case 4 :
							System.out.println("enter the updated out on zeroes");
							int os = sc.nextInt();
							d.setOut_on_zero(os);
							break;
						case 5 :
							x=false;
							break;
						default :
							System.out.println("Choose a valid number to update");
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
				
			break;
			
		case 3 :
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
			Collections.sort(data,Comparator.comparingDouble(Data1::getAvg_score));
			for(int j=1; j<=bowler;j++) {
				//data.forEach((d)->System.out.println("Player_Type : "+ d.player_type+" Name : "+d.name+" Matches Played : "+d.matches_played+" Runs : "+d.runs+" Wickets : "+d.wickets+" Out On Zero : "+d.out_on_zero+" Average Score :"+d.avg_score));
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
			Collections.sort(data,Comparator.comparingDouble(Data1::getAvg_score));
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
			Collections.sort(temp,new NameComparator());
			Iterator<Data1> itr4 = final_team.iterator();
			while(itr4.hasNext()) {
				Data1 dat4 = itr4.next();
				System.out.println("Id : "+ dat4.getId()+" Name : "+dat4.getName()+" Player Type : "+dat4.getPlayer_type()+" Matches Played : "+dat4.getMatches_played()+ " Runs : "+dat4.getRuns()+ " Wickets : "+dat4.getWickets()+" Out on Zero : "+dat4.getOut_on_zero()+" Average Score : "+dat4.getAvg_score());
				System.out.println(" ");
			}
			break;
		case 4 :
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
					
				}
				//player_type=sc.next();
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
				
				//System.out.println(cnt+" "+flag);
				
				break;		
		case 5 :
			run=false;
			System.out.println("Exit");
			}	
		}
	
	}

}
