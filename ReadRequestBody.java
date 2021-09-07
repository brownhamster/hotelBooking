/**
 * ReadRequestBody.java
 * Date - 07-Sep-2021
 * 
 * This java code reads the JSON payload from a .txt file.
 * The expected output is to correctly read and display the payload passed via .txt file.
 **/

package testCasesUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadRequestBody {

	File testData = new File("C:\\Users\\Tuhinanshu\\eclipse-workspace\\HotelBooking\\src\\testCasesUtil\\"
			+ "TestData.txt");	

	@SuppressWarnings("unused")
	public String readPayLoad_PartialUpdate() throws FileNotFoundException
	{
		String payloadData = new String();
		Scanner scan = new Scanner(testData);
		try
		{
			while (scan.hasNextLine())
			{
				for(int i=0;scan.hasNextLine();i++)
					payloadData += (String)scan.nextLine();
			}
			scan.close();
			System.out.println("\n\n***JSON Request Payload***\n");
			System.out.println(payloadData);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return payloadData;
	}




	@SuppressWarnings("unused")
	public String readPayLoad_getBookingID() throws FileNotFoundException
	{
		String bookingID = null;
		Scanner scan = new Scanner(testData);
		try
		{
			while (scan.hasNextLine())
			{
				for(int i=0;scan.hasNextLine();i++)
					bookingID += (String)scan.nextLine();
			}
			scan.close();
			System.out.println("\n\n***Boking ID to check - " + bookingID + " ***");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return bookingID;

	}


	@SuppressWarnings("unused")
	public String readPayLoad_DeleteBooking() throws FileNotFoundException
	{
		String payloadData = new String();
		Scanner scan = new Scanner(testData);
		try
		{
			while (scan.hasNextLine())
			{
				for(int i=0;scan.hasNextLine();i++)
					payloadData += (String)scan.nextLine();
			}
			scan.close();
			System.out.println("\n\n***JSON Request Payload***\n");

			System.out.println(payloadData);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return payloadData;
	}


}
