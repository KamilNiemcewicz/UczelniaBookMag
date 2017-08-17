package kn;

import java.io.IOException;

import kn.IO.IODatabase;
import kn.Menu.IMenu;
import kn.Menu.MenuLogin;
import kn.Menu.MenuProgram;

/** This program provides very simple magazine of your books you want have in one place.
 *
 * @author Kamil Niemcewicz
 * @version 1.0
 */

public class Main {
	public static void main(String[] args) throws IOException 
	{
		

		IODatabase io = new IODatabase();
		io.CreateDatabaseIfNotExist(io.DatabaseName);
		io.CreateDatabaseIfNotExist(io.UsersDatabaseName);

		IMenu menu = new MenuLogin();
		menu.ShowMenu();
		
		
		menu = new MenuProgram();
		while (true)
		{
			menu.ShowMenu();
		}
	}
}
