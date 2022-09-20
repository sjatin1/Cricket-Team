package cricket.data;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface CricketMenu extends Remote {
public Player display() throws RemoteException ;
    
public void update_by_name() throws RemoteException;
public void display_final_team() throws RemoteException;



}
