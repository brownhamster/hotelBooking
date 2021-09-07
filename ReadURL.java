/**
 * ReadURL.java
 * Date - 07-Sep-2021
 * 
 * This java code reads the URLs to work on from a .txt file.
 **/

package testCasesUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadURL {
	File urlFile = new File("C:\\Users\\Tuhinanshu\\eclipse-workspace\\HotelBooking\\src\\testCasesUtil\\"
			+ "URL.txt");	

	@SuppressWarnings("unused")
	public String readUrl_PartialUpdate() throws FileNotFoundException
	{
		String url = new String();
		Scanner scan = new Scanner(urlFile);
		try
		{
			while (scan.hasNextLine())
			{
				for(int i=0;scan.hasNextLine();i++)
					url += (String)scan.nextLine();
			}
			scan.close();
			System.out.println("\n\n***Base URL***\n");
			System.out.println(url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return url;
	}




	@SuppressWarnings("unused")
	public String readUrl_getBookingID() throws FileNotFoundException
	{
		String url = new String();
		Scanner scan = new Scanner(urlFile);
		try
		{
			while (scan.hasNextLine())
			{
				for(int i=0;scan.hasNextLine();i++)
					url += (String)scan.nextLine();
			}
			scan.close();
			System.out.println("\n\n***Base URL***\n");
			System.out.println(url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return url;

	}


	@SuppressWarnings("unused")
	public String readUrl_DeleteBooking() throws FileNotFoundException
	{
		String url = new String();
		Scanner scan = new Scanner(urlFile);
		try
		{
			while (scan.hasNextLine())
			{
				for(int i=0;scan.hasNextLine();i++)
					url += (String)scan.nextLine();
			}
			scan.close();
			System.out.println("\n\n***Base URL***\n");
			System.out.println(url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return url;
	}


}

