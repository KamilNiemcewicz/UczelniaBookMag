package kn.IO;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kn.ToCSVable;
import kn.User;

/**
 * 
 * @author Kamil Niemcewicz
 *
 */
public final class IOUser extends IOBase {

	/**
	 * Save entry to end of database file
	 * @param databaseName
	 * @param userToSave
	 */
	public void SaveEntryToDatabase(String databaseName, User userToSave) 
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
			if (CheckIfUserExist(databaseName, userToSave))
			{
				System.out.println("U¿ytkownik istnieje w bazie danych.");
			}
			else
		    {
				writer.write(userToSave.ToCSV() + "\n");
		    	System.out.println("Pomyœlnie utworzono konto dla u¿ytkownika: " + userToSave.GetLoginName() + ".");
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
	 * Delete one user from database
	 * @param databaseName
	 * @param lineToRemove
	 */
	public void DeleteEntryFromDatabase(String databaseName,  User userToRemove) 
	{
		if (CheckIfUserExist(databaseName, userToRemove))
		{
			List<ToCSVable> users = new ArrayList<ToCSVable>();
			for(String[] s : ReadDatabase(databaseName))
			{
				User u = new User(s);
				if (!u.GetLoginName().equals(userToRemove.GetLoginName()))
					users.add(u);
			}
			SaveDatabase(users, databaseName);

			System.out.println("U¿ytkownik " + userToRemove.GetLoginName() + " usuniêty.");
		}
		else
	    {
	    	System.out.println("Nieznaleziono u¿ytkownika o nazwie " + userToRemove.GetLoginName() + " w bazie danych " + databaseName + ".");
	    }
	}
	
	/**
	 * Checks if user exist in database
	 * @param databaseFile
	 * @param userToRemove
	 * @return
	 */
	public boolean CheckIfUserExist(String databaseName,  User userToRemove) 
	{
		ArrayList<User> users = new ArrayList<User>();
		for(String[] s : ReadDatabase(databaseName)){
			users.add(new User(s));
		}

		for (User u : users)
		{
			if (userToRemove.GetPassword().equals(u.GetPassword()) && (userToRemove.GetLoginName()).equals(u.GetLoginName()))
			{
				return true;
			}
		}
		return false;
	}
}




