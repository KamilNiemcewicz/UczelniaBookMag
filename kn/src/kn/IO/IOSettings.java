package kn.IO;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Kamil Niemcewicz
 *
 */
public final class IOSettings extends IOBase {
	
	/**
	 * Reads setting and returns it
	 * @param key provide enum setting string value
	 * @return value of setting's key
	 * @throws Exception if the value has not been found
	 */
	public String ReadSetting(String key) throws Exception
	{
		ArrayList<String[]> settings = new ArrayList<String[]>(ReadDatabase(SettingsDatabaseName));
		for (String[] s : settings)
		{
			if (s[0].equals(key))
			{
				return s[1];
			}
		}
		throw new Exception("B��d podczas wczytywania ustawie�.");
	}
	
	/**
	 * Update one setting value
	 * @param key provide enum setting string value 
	 * @param value provide new value for this method
	 */
	public void UpdateSetting(String key, String value)
	{
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(SettingsDatabaseName, false); 
		}
		catch (Exception FileNotFoundException)
		{
			System.err.println("B��d otwarcia pliku.");
		}
		
		try
		{		
			writer.write(key + "," + value + "\n");
		}
		catch (IOException e)
		{
			System.err.print("Wyst�pi� b�ad: " + e);
		}
		finally 
		{
			try 
			{
				writer.close();
			}	
			catch (IOException e)
			{
				System.err.print("Dane zosta�y utracone, nie uda�o si� zapisa� pliku!!!");
			}
		}
	}
	
	
}
