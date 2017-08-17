package kn.MenuCommands;

import java.util.Scanner;
import kn.Book;
import kn.IO.IODatabase;

/**
 * 
 * @author Kamil Niemcewicz
 *
 */
public class AddRowToDatabase implements ICommand {

	@Override
	public void Execute() {
		IODatabase db = new IODatabase();
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		String name, author, isbn, paperBack, paperSize;
		
		System.out.println("Podaj nazwê ksi¹¿ki: ");
		name = scanner.nextLine();
		
		System.out.println("Podaj autora: ");
		author = scanner.nextLine();
		
		System.out.println("Podaj nr ISBN: ");
		isbn = scanner.nextLine();
		
		System.out.println("Podaj rodzaj ok³adki: ");
		paperBack = scanner.nextLine();
		
		System.out.println("Podaj rozmiar ksi¹¿ki: ");
		paperSize = scanner.nextLine();
		
		Book book = new Book(name, author, isbn, paperBack, paperSize);	
		db.SaveEntryToDatabase(db.DatabaseName, book);
		
	}
}
