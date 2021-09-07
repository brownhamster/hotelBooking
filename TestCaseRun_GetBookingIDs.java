/**
 * TestCaseRun_GetBookingIDs.java
 * Date - 07-Sep-2021
 * 
 * This java code runs the test case step by step to return all the Booking IDs.
 **/

package testCasesUtil;

import getBookingIds.GetBookingIds;

public class TestCaseRun_GetBookingIDs {

	public static void main (String[] args) throws Exception
	{
		GetBookingIds gbi = new GetBookingIds();
		gbi.allBookingIDs();

	}
}
