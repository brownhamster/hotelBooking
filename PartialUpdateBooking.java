/**
 * PartialUpdateBooking.java
 * Date - 07-Sep-2021
 * 
 * This java code updates the booking already present. The booking ID is passed in the URL.
 * The response status code should be 200 OK. The response body should display the updated details of the Booking.
 **/

package partialUpdateBooking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import testCasesUtil.ReadRequestBody;
import testCasesUtil.ReadURL;

import java.io.*;

public class PartialUpdateBooking {

	static ReadRequestBody JSONPayload = new ReadRequestBody();
	static ReadURL baseURL = new ReadURL();
	
	public void updateRequest(String token) throws IOException, InterruptedException 
	{
		try 
		{
			String url = baseURL.readUrl_PartialUpdate();
			String PATCH_PARAMS = JSONPayload.readPayLoad_PartialUpdate();
			String base64Credentials = new String(
					org.apache.commons.codec.binary.Base64.encodeBase64   
					(org.apache.commons.codec.binary.StringUtils.getBytesUtf8("admin:password123"))
					);
			URL obj = new URL(url);
			String authorizationHeader = "Basic " + base64Credentials;
			System.out.println(authorizationHeader);
			HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
			postConnection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
			postConnection.setRequestMethod("POST");
			postConnection.setRequestProperty("admin", "password123");
			postConnection.setRequestProperty("Content-Type", "application/json");
			postConnection.setRequestProperty("Authorization", authorizationHeader);
			postConnection.setRequestProperty("Cookie", "token="+token);
			postConnection.setRequestProperty("Accept", "text/plain");
			postConnection.setDoOutput(true);
			OutputStream os = postConnection.getOutputStream();
			os.write(PATCH_PARAMS.getBytes());
			os.flush();
			os.close();
			int responseCode = postConnection.getResponseCode();
			System.out.println("\n\n***Response***\n");
			System.out.println("Response Code :  " + responseCode);
			System.out.println("Response Message : " + postConnection.getResponseMessage());
			if (responseCode == HttpURLConnection.HTTP_OK) { //success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						postConnection.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in .readLine()) != null) 
				{
					response.append(inputLine);
				} 
				in .close();
				System.out.println("\n\n***SUCCESS Response***\n");
				System.out.println(response.toString());
			} 
			else 
			{
				System.out.println("\n\n***ERROR Response***\n");
				System.out.println("PATCH NOT WORKED");
				throw new RuntimeException("HTTP error code : "
						+ postConnection.getResponseCode());
			}
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
