package kn.MenuCommands;

import java.util.ArrayList;

import kn.User;
import kn.IO.IOUser;

/**
 * 
 * @author Kamil Niemcewicz
 *
 */
public class ShowUsers implements ICommand
{
	@Override
	public void Execute() 
	{
		IOUser io = new IOUser();
		ArrayList<User> users = new ArrayList<User>();
		for(String[] s : io.ReadDatabase(io.UsersDatabaseName)){
			users.add(new User(s));
		}
		
		for (User u : users)
		{
			System.out.println("Login: " + u.GetLoginName());
		}
	}
}
