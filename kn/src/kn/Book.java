package kn;

import kn.IO.IOSettings;

/**
 * 
 * @author Kamil Niemcewicz
 *
 */
public class Book implements ToCSVable {
	
	private String ID;
	private String Name;
	private String Author;
	private String ISBN;
	private String Paperback;
	private String PaperSize;
		
	/**
	 * 
	 * @param paperback = hard, soft, 
	 * @param paperSize = i.e. "A4", "B5", etc.
	 */
	public Book(String name, String author, String isbn, String paperback, String paperSize) {
		ID = SetNewID();
		Name = name;
		Author = author;
		ISBN = isbn;
		Paperback = paperback;
		PaperSize = paperSize;
	}
	
	/**
	 * Added to gain ability of using string.split(",") on database file
	 * @param paperback = hard, soft, 
	 * @param paperSize = i.e. "A4", "B5", etc.
	 */
	public Book(String id, String name, String author, String isbn, String paperback, String paperSize) {
		ID = id;
		Name = name;
		Author = author;
		ISBN = isbn;
		Paperback = paperback;
		PaperSize = paperSize;
	}

	/**
	 * Added to gain ability of using string.split(",") on database file
	 * @param data array of strings
	 */
	public Book(String[] data) {
		ID = data[0];
		Name = data[1];
		Author = data[2];
		ISBN = data[3];
		Paperback = data[4];
		PaperSize = data[5];
	}
	
	
	/**
	 * Splits all variables into string
	 */
	public String ToCSV()
	{
		return GetID() + "," + GetName() + "," + GetAuthor() + "," + GetISBN() + "," + GetPaperback() + "," + GetPaperSize();
	}
	
	public String GetID()
	{
		return ID;
	}
	
	public String GetName()
	{
		return Name;
	}
	
	public String GetAuthor()
	{
		return Author;
	}
	
	public String GetISBN()
	{
		return ISBN;
	}
	
	public String GetPaperback()
	{
		return Paperback;
	}
	
	public String GetPaperSize()
	{
		return PaperSize;
	}
	
	/**
	 * Sets new ID based on settings stored in settings file, then updates this file with new ID
	 * @return new ID value
	 */
	public String SetNewID()
	{
		IOSettings io = new IOSettings();
		int nextId = 0;
		try {
			nextId = Integer.parseInt(io.ReadSetting(setting.currentBookID.toString()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		nextId++;
		
		io.UpdateSetting(setting.currentBookID.toString(), Integer.toString(nextId));
		
		return Integer.toString(nextId);
	}
}
