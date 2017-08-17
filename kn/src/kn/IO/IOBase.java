package kn.IO;

/** Program is a very simple magazine of books.
 *
 * @author Kamil Niemcewicz
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import kn.ToCSVable;

/**
 * 
 * @author Kamil Niemcewicz
 *
 */
public abstract class IOBase {

	Charset charset = Charset.forName("UTF-8");
	public String DatabaseName = "";
	public String UsersDatabaseName = "";
	public String SettingsDatabaseName = "";
	public Path BookDatabasePath = FileSystems.getDefault().getPath("", DatabaseName);
	public Path UserDatabasePath = FileSystems.getDefault().getPath("", UsersDatabaseName);
	public Path SettingsPath = FileSystems.getDefault().getPath("", UsersDatabaseName);

	
	File file = null;
	
	/**
	 * Standard constructor provides standard filenames
	 */
	public IOBase() 
	{
		DatabaseName = "database.db";
		UsersDatabaseName = "users.db";
		SettingsDatabaseName = "settings.db";
	}
	
	/**
	 * Creates Database for the first time. If the file exist, does nothing.
	 */
	public void CreateDatabaseIfNotExist(String dbName) 
	{
		file = new File(dbName);
		try 
		{
			file.createNewFile(); 
		}
		catch (IOException e)
		{
			System.err.println("Wyst¹pi³ b³ad: " + e);
		}
	}
	
	/**
	 * * Saves database file.
	 * @param data list of objects that inherent from ToCSVable interface
	 * @param databaseName database file name
	 */
	public void SaveDatabase(List<ToCSVable> data, String databaseName) 
	{
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(databaseName); 
		}
		catch (Exception FileNotFoundException)
		{
			System.err.println("B³¹d otwarcia pliku.");
		}
		
		try
		{		
			for (ToCSVable row : data)
			{
				writer.write(row.ToCSV() + "\n");	
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
	
	public void Nadwaga(File f) throws IOException
	{
		FileWriter nadwagaWriter = new FileWriter("plik"); 
		FileWriter niedowagaWriter = new FileWriter("plik2"); 
		
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line; String[] lineS;
			while ((line = br.readLine()) != null) {
				lineS = line.split("-");
				if (Integer.parseInt(lineS[2]) < 18.5) {
					niedowagaWriter.write(lineS[0] + "- nadwaga\r\n");
				}
				if (Integer.parseInt(lineS[2]) >= 25.0) {
					nadwagaWriter.write(lineS[1] + "-niedowaga\r\n");
				}}}
		catch (IOException e){
			System.err.println(e);
		}
		finally {
			nadwagaWriter.close();
			niedowagaWriter.close();
		}
	}
	
	
	
	
	/**
	 * Read all lines from database and saves into List<Book> variable
	 * @param databaseName database file name
	 * @return returns ArrayList<String[]> of splited by "," strings
	 */
	public ArrayList<String[]> ReadDatabase(String databaseName)
	{

		ArrayList<String[]> data = new ArrayList<String[]>();
		try (BufferedReader br = new BufferedReader(new FileReader(databaseName))) 
		{
		    String line;
		    while ((line = br.readLine()) != null) {
		    	data.add(line.split(","));
		    }
		
		} catch (IOException e) {
		    System.err.print("Wyst¹pi³ b³¹d: " + e);
		}
		return data;
	}
	
	
	
}
