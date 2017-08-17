package kn.MenuCommands;

import java.util.ArrayList;
import kn.Book;
import kn.IO.IODatabase;

/**
 * 
 * @author Kamil Niemcewicz
 *
 */
public class ShowData implements ICommand
{
	@Override
	public void Execute() 
	{
		IODatabase db = new IODatabase();
		ArrayList<String[]> dataRetrieved = new ArrayList<String[]>(db.ReadDatabase(db.DatabaseName));		
		ArrayList<Book> books = new ArrayList<Book>();
		
		for (String[] b : dataRetrieved)
		{
			books.add(new Book(b));
		}
		
		for (Book b : books)
		{
			System.out.println("ID\t\t- " + b.GetID() + System.lineSeparator() + 
					"Nazwa\t\t- " + b.GetName() + System.lineSeparator() +
					"Autor\t\t- " + b.GetAuthor() + System.lineSeparator() + 
					"ISBN\t\t- " + b.GetISBN() + System.lineSeparator() + 
					"Rodzaj okladki  - " + b.GetPaperback() + System.lineSeparator() + 
					"Rozmiar\t\t- " + b.GetPaperSize() + System.lineSeparator() + System.lineSeparator());
		}
			
	}
}
