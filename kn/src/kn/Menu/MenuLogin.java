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
			System.out.println("Czeœæ! Ten program przyda Ci siê do stworzenia magazynu Twoich ksi¹¿êk!"  + System.lineSeparator() +
					   "1. Zaloguj siê. "  + System.lineSeparator() + 
					   "2. Stwórz u¿ytkownika. " + System.lineSeparator() + 
					   "3. Poka¿ aktualnych u¿ytkowników. " + System.lineSeparator() + 
					   "4. Usuñ u¿ytkownika. " + System.lineSeparator() + 
					   "5. WyjdŸ z aplikacji."  + System.lineSeparator());
			
			
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
