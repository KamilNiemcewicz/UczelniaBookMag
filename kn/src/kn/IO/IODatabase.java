package kn.IO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kn.Book;
import kn.ToCSVable;
import kn.User;

/**
 * 
 * @author Kamil Niemcewicz
 *
 */
public final class IODatabase extends IOBase {
	
	/**
	 * Save entry to end of database file (appending db)
	 * @param databaseName 
	 * @param bookToSave 
	 */
	public void SaveEntryToDatabase(String databaseName, Book bookToSave) 
	{
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(databaseName, true); 
		}
		catch (Exception FileNotFoundException)
		{
			System.err.println("B³¹d otwarcia pliku.");
		}
		
		try
		{		
			if (CheckIfBookExist(databaseName, bookToSave))
			{
				System.out.println("Ksi¹¿ka ju¿ istnieje w bazie danych.");
			}
			else
		    {
				writer.write(bookToSave.ToCSV() + "\n");
		    	System.out.println("Pomyœlnie dodano ksi¹zkê: " + bookToSave.GetName() + ".");
		    }
		}
		catch (IOException e)
		{
			System.err.print("Wyst¹pi³ b³ad: " + e);
		}
		finally 
		{
			try 
			{
				writer.close();
			}	
			catch (IOException e)
			{
				System.err.print("Dane zosta³y utracone, nie uda³o siê zapisaæ pliku!!!");
			}
		}
	}
	
	/**
	 * Delete one entry from database
	 * @param databaseName
	 * @param bookToRemove
	 */
	public void DeleteEntryFromDatabase(String databaseName,  Book bookToRemove) 
	{
		if (CheckIfBookExist(databaseName, bookToRemove))
		{
			List<ToCSVable> books = new ArrayList<ToCSVable>();
			for(String[] s : ReadDatabase(databaseName))
			{
				User u = new User(s);
				if (!u.GetLoginName().equals(bookToRemove.GetISBN()))
					books.add(u);
			}
			SaveDatabase(books, databaseName);

			System.out.println("Ksi¹¿ka " + bookToRemove.GetName() + " usuniêta.");
		}
		else
	    {
	    	System.out.println("Nieznaleziono ksi¹¿ki o nazwie " + bookToRemove.GetName() + " w bazie danych " + databaseName + ".");
	    }
	}
	
	/**
	 * Checks if user exist in database
	 * @param databaseName
	 * @param bookToCheck
	 * @return
	 */
	private boolean CheckIfBookExist(String databaseName, Book bookToCheck) 
	{
		ArrayList<Book> books = new ArrayList<Book>();
		for(String[] s : ReadDatabase(databaseName)){
			books.add(new Book(s));
		}

		for (Book u : books)
		{
			if (bookToCheck.GetISBN().equals(u.GetISBN()))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Updates one row with given book replacing it.
	 * @param databaseName
	 * @param bookToUpdate
	 */
	public void UpdateRow(String databaseName, Book bookToUpdate) 
	{
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(databaseName, true); 
		}
		catch (Exception FileNotFoundException)
		{
			System.err.println("B³¹d otwarcia pliku.");
		}
		
		try
		{		
			if (CheckIfBookExist(databaseName, bookToUpdate))
			{
				System.out.println("Ksi¹¿ka ju¿ istnieje w bazie danych.");
			}
			else
		    {
				List<ToCSVable> books = new ArrayList<ToCSVable>();
				for(String[] s : ReadDatabase(databaseName))
				{
					Book b = new Book(s);
					if (!b.GetID().equals(bookToUpdate.GetID()))
						books.add(b);
					else
						books.add(bookToUpdate);
				}
				SaveDatabase(books, databaseName);
				
		    	System.out.println("Pomyœlnie zaktualizowano ksi¹zkê: " + bookToUpdate.GetName() + ".");
		    }
		}
		finally 
		{
			try 
			{
				writer.close();
			}	
			catch (IOException e)
			{
				System.err.print("Dane zosta³y utracone, nie uda³o siê zapisaæ pliku!!!");
			}
		}
	}
	
}
