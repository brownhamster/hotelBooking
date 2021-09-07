/**
 * CheckBookingID.java
 * Date - 07-Sep-2021
 * 
 * This java code checks if a specific Booking ID is present.
 **/

package getBookingIds;

import java.util.ArrayList;

public class CheckBookingId {

	GetBookingIds id = new GetBookingIds();
	public boolean checkIfBookingIdIsPresent(String fetchId)
	{
		boolean flag = false;
		String[] myids = fetchId.split("null");
		String checkId ="{\"bookingid\":" + myids[1] + "}";
		System.out.println(checkId);
		try
		{
			ArrayList<String> bookingDetails = GetBookingIds.fetchBookingDetails();
			for(int i=0; i<bookingDetails.size(); i++)
			{
				String bookingId = bookingDetails.get(i);
				if(bookingId.equals(bookingId))
				{
					flag = true;
					break;
				}
				else 
					flag = false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

}
