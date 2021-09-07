/**
 * TestCaseRun_DeleteBooking.java
 * Date - 07-Sep-2021
 * 
 * This java code runs the test case step by step for Deleting a Booking.
 **/

package testCasesUtil;

import java.io.IOException;
import deleteBooking.DeleteBooking;

public class TestCaseRun_DeleteBooking {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, InterruptedException
	{
		try
		{
			CreateToken token = new CreateToken();
			String[] tokenElements = token.createAuthToken().split(":\"");
			String[] tokenElements2 = tokenElements[1].split("\"}");
			String authToken = tokenElements2[0];
			DeleteBooking deleteBooking = new DeleteBooking();
			deleteBooking.deleteMyBooking(authToken);
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



