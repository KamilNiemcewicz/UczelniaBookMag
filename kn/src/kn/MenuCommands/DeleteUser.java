package kn.MenuCommands;
import java.util.Scanner;
import kn.User;
import kn.IO.IOUser;

/**
 * 
 * @author Kamil Niemcewicz
 *
 */
public class DeleteUser implements ICommand
{
	@Override
	public void Execute() 
	{
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String login, password;
		System.out.println("Podaj login konta, kt�re chcesz usun��: ");
		login = scanner.nextLine();
		System.out.println("Podaj Has�o: ");
		password = scanner.nextLine();
		User user = new User(login, password);
		IOUser io = new IOUser();
		io.DeleteEntryFromDatabase(io.UsersDatabaseName, user);
	}
}
