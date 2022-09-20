package cricket.data;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;
import java.util.Iterator;




public class PlayerDao {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports","root","password");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	public static int saveUser(Player player) {
		String sql=null;
		try {
		sql = "insert into CRICKET values(" + player.getId() + ",'" + player.getPlayer_type() + "','" + player.getName()+ "','" + player.getMatches_played() + "','" + player.getRuns() + "','" + player.getWickets() + "','" + player.getOut_on_zero() + "','" + player.getAvg_score() + "')";
		Statement st = (Statement) Util.getStatement();
		return st.executeUpdate(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static Player getId(int id) {
		Player p = new Player();
		try {
			String sql = "select * from CRICKET where id=?";
			Connection con = PlayerDao.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p.setId(rs.getInt(1));
				p.setName(rs.getString(3));
				p.setPlayer_type(rs.getString(2));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return p;
	}
	public static List<Player> display() throws RemoteException {
		List<Player> list = new ArrayList<Player>();
		  try{
	            String sql = "select * from CRICKET";
	            ResultSet rs = Util.getStatement().executeQuery(sql);
	            
	            while (rs.next()){
	            	Player b = new Player();
	                b.setId(rs.getInt(1));
	                b.setPlayer_type(rs.getString(2));
	                b.setName(rs.getString(3));
	                b.setMatches_played(rs.getInt(4));
	                b.setRuns(rs.getDouble(5));
	                b.setWickets(rs.getDouble(6));
	                b.setOut_on_zero(rs.getInt(7));
	                b.setAvg_score(rs.getDouble(8));
	                list.add(b);
	            }
	        }
	        catch (Exception et){
	            et.printStackTrace();
	        }
	        return list;
	}

	public static void update_by_name(String name, String type, double data) throws RemoteException {
		// TODO Auto-generated method stub
		 try {
			 	int mp;
			 	double runs;
	        	Statement st = Util.getStatement();
	    		String sql1 = "update CRICKET set "+type+ "='" +data+ "'where pname = '"+name+"' ";
	    		String sql2= "select * from CRICKET where pname = '"+name+"' ";
	    		ResultSet rs = Util.getStatement().executeQuery(sql2);
	    		rs.next();
	    		mp=rs.getInt(4);
	    		runs=rs.getDouble(5);
	    		String sql3=null;
	    		if(type.equals("runs")) {
	    			double avg = data/mp;
	    			sql3 = "update CRICKET set avg_score = '"+avg+"' where pname = '"+name+"' "; 
	    		}
	    		else if(type.equals("mp")) {
	    			double avg = runs/data;
	    			sql3 = "update CRICKET set avg_score = '"+avg+"' where pname = '"+name+"' "; 
	    		}
	    		st.executeUpdate(sql1);
	    		st.executeUpdate(sql3);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}

	public static List<Player> display_final_team(int cnt) throws RemoteException {
		List<Player> final_team = new ArrayList<Player>();
		  try {
	            String sql2 = "select * from CRICKET ORDER BY avg_score DESC LIMIT 11";
	            ResultSet rs2 = Util.getStatement().executeQuery(sql2);
	            
	            while (rs2.next()){
	            	Player b = new Player();
	                b.setId(rs2.getInt(1));
	                b.setPlayer_type(rs2.getString(2));
	                b.setName(rs2.getString(3));
	                b.setMatches_played(rs2.getInt(4));
	                b.setRuns(rs2.getDouble(5));
	                b.setWickets(rs2.getDouble(6));
	                b.setOut_on_zero(rs2.getInt(7));
	                b.setAvg_score(rs2.getDouble(8));
	                final_team.add(b);
	            }
	        	
	        	
	        }
	        catch (Exception et){
	            et.printStackTrace();
	        }
	        return final_team;
		
	}

	}
