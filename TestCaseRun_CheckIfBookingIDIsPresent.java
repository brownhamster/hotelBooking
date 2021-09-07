/**
 * TestCaseRun_CheckIfBookingIDIsPresent.java
 * Date - 07-Sep-2021
 * 
 * This java code runs the test case step by step to check if a Booking ID is present.
 **/

package testCasesUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import getBookingIds.CheckBookingId;
import getBookingIds.GetBookingIds;

public class TestCaseRun_CheckIfBookingIDIsPresent {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException 
	{
		File findBookingID = new File("C:\\Users\\Tuhinanshu\\eclipse-workspace\\HotelBooking\\src\\testCasesUtil\\"
				+ "BookingID.txt");
		boolean flag = false;
		String bookingID = null;
		Scanner scan = new Scanner(findBookingID);
		try
		{
			while (scan.hasNextLine())
			{
				for(int i=0;scan.hasNextLine();i++)
					bookingID += scan.nextLine();
			}
			scan.close();
			System.out.println("\n\n***Base URL***\n");
			System.out.println(bookingID);
			GetBookingIds gbi = new GetBookingIds();
			gbi.allBookingIDs();
			CheckBookingId cbi = new CheckBookingId();
			flag = cbi.checkIfBookingIdIsPresent(bookingID);
			System.out.println(flag);
			if(flag == true)
			{

				System.out.println("\n\n***Result***\n");
				System.out.println("Booking ID is present");
			}
			else
			{
				System.out.println("\n\n***Result***\n");
				System.out.println("Booking ID unavailable");
			}
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
