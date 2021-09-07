/**
 * GetBookingIds.java
 * Date - 07-Sep-2021
 * 
 * This java code retrieves all the Booking IDs.
 * The response status code should be 200 OK.
 **/

package getBookingIds;

import org.json.JSONArray;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import org.testng.annotations.Test;

import testCasesUtil.ReadURL;

import org.testng.annotations.*;

public class GetBookingIds
{
	static JSONArray receivedResponse;
	static ReadURL baseURL = new ReadURL();

	@Test
	public void allBookingIDs() throws MalformedURLException, IOException
	{
		String url = baseURL.readUrl_getBookingID();
		try {
			URL obj = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				System.out.println("Response Code: " + conn.getResponseCode() + " " +
						conn.getResponseMessage());
				System.out.println("\n\n***ERROR Response***\n");
				throw new RuntimeException("HTTP error code : "
						+ conn.getResponseCode());
			}
			Scanner scan = new Scanner(obj.openStream());
			String entireResponse = new String();
			while (scan.hasNext())
				entireResponse += scan.nextLine();
			System.out.println("\n\n***SUCCESS Response***\n");
			System.out.println("Response Code: " + conn.getResponseCode() + " " +
					conn.getResponseMessage());
			JSONArray resArray = new JSONArray(entireResponse);
			for(int i=0; i<resArray.length(); i++)
				System.out.println(resArray.getJSONObject(i));
			scan.close();
			conn.disconnect();
			receivedResponse = resArray;	
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@AfterTest
	public static ArrayList<String> fetchBookingDetails()
	{
		ArrayList<String> resData = new ArrayList<String>();
		try
		{
			if (receivedResponse!= null)
			{
				for(int i=0; i<receivedResponse.length(); i++)
					resData.add(receivedResponse.getJSONObject(i).toString());
			}
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}
		return resData;
	}

}
