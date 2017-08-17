package kn.Menu;

import java.util.Scanner;
import kn.MenuCommands.*;

/**
 * 
 * @author Kamil Niemcewicz
 *
 */
public class MenuProgram implements IMenu
{
	public void ShowMenu()
	{
		ICommand command = null;
				
		while (true)
		{
			System.out.println(System.lineSeparator() +
					   "1. Wyúwietl dane."  + System.lineSeparator() +
					   "2. Wyúwietlaj wiersz po wierszu."  + System.lineSeparator() +
					   "3. Dodaj wiersz."  + System.lineSeparator() +
					   "4. Modyfikuj wybrany wiersz. "  + System.lineSeparator() +
					   "5. Wyjdü z aplikacji.");
			
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			switch (scanner.nextInt())
			{
				case 1: command = new ShowData(); break;
				case 2: command = new ShowDataByRecord(); break;
				case 3: command = new AddRowToDatabase(); break;
				case 4: command = new ModifyRow(); break;
				case 5: command = new QuitApplication(); break;
			}
			command.Execute();
		}		
	}
}


