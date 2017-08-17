package kn.Menu;

import java.util.Scanner;
import kn.MenuCommands.CreateUser;
import kn.MenuCommands.DeleteUser;
import kn.MenuCommands.ICommand;
import kn.MenuCommands.Login;
import kn.MenuCommands.QuitApplication;
import kn.MenuCommands.ShowUsers;

/**
 * 
 * @author Kamil Niemcewicz
 *
 */
public class MenuLogin implements IMenu {

	public void ShowMenu() {
		
		ICommand command = null;
		boolean isLogged = false;
		loop: while (!isLogged) //this label is used only once in this switch statement
		{
			System.out.println("Cze��! Ten program przyda Ci si� do stworzenia magazynu Twoich ksi���k!"  + System.lineSeparator() +
					   "1. Zaloguj si�. "  + System.lineSeparator() + 
					   "2. Stw�rz u�ytkownika. " + System.lineSeparator() + 
					   "3. Poka� aktualnych u�ytkownik�w. " + System.lineSeparator() + 
					   "4. Usu� u�ytkownika. " + System.lineSeparator() + 
					   "5. Wyjd� z aplikacji."  + System.lineSeparator());
			
			
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			switch (scanner.nextInt())
			{
				case 1: {
					Login l = new Login(); 
					isLogged = l.LoginUser();
					break loop;
				}
				case 2: command = new CreateUser(); break;
				case 3: command = new ShowUsers(); break;
				case 4: command = new DeleteUser(); break;
				case 5: command = new QuitApplication(); break;
			}
			command.Execute();
		}
	}
}
