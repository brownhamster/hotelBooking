/**
 * TestCaseRun_PartialUpdateBooking.java
 * Date - 07-Sep-2021
 * 
 * This java code runs the test case step by step for Partial Update on a Booking.
 **/

package testCasesUtil;

import java.io.IOException;

import partialUpdateBooking.PartialUpdateBooking;

public class TestCaseRun_PartialUpdateBooking {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, InterruptedException
	{
		try
		{
			CreateToken token = new CreateToken();
			String[] tokenElements = token.createAuthToken().split(":\"");
			String[] tokenElements2 = tokenElements[1].split("\"}");
			String authToken = tokenElements2[0];
			PartialUpdateBooking updateBooking = new PartialUpdateBooking();
			updateBooking.updateRequest(authToken);
		}

		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}



