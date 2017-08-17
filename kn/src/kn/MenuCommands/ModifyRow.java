package kn.MenuCommands;

import java.util.Scanner;
import kn.Book;
import kn.IO.IODatabase;

/**
 * 
 * @author Kamil Niemcewicz
 *
 */
public class ModifyRow implements ICommand
{
	@Override
	public void Execute() 
	{
		IODatabase db = new IODatabase();
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String name, author, isbn, paperBack, paperSize, id;
		
		System.out.println("Podaj ID: ");
		id = scanner.nextLine();
		
		System.out.println("Podaj nazw� ksi��ki: ");
		name = scanner.nextLine();
		
		System.out.println("Podaj autora: ");
		author = scanner.nextLine();
		
		System.out.println("Podaj nr ISBN: ");
		isbn = scanner.nextLine();
		
		System.out.println("Podaj rodzaj ok�adki: ");
		paperBack = scanner.nextLine();
		
		System.out.println("Podaj rozmiar ksi��ki: ");
		paperSize = scanner.nextLine();
		
		Book book = new Book(id, name, author, isbn, paperBack, paperSize);	
		db.UpdateRow(db.DatabaseName, book);
		
	}
}
