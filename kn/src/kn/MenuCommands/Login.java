package kn.MenuCommands;
import java.util.Scanner;
import kn.User;
import kn.IO.IOUser;

/**
 * 
 * @author Kamil Niemcewicz
 *
 */
public class Login implements ICommand {
	
	@Override
	public void Execute()
	{
		this.LoginUser();
	}
	
	public boolean LoginUser()
	{
		IOUser io = new IOUser();
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String login, password;
		System.out.println("Podaj Login: ");
		login = scanner.nextLine();
		System.out.println("Podaj Has³o: ");
		password = scanner.nextLine();
		
		User user = new User(login,password);
		boolean exist = io.CheckIfUserExist(io.UsersDatabaseName, user);
		
		if (exist == false)
		{
			System.out.println("Bledny login lub haslo.");
			System.exit(0);
		}
		return false;	
	}
}
