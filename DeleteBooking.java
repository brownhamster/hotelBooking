/**
 * GetBookingIds.java
 * Date - 07-Sep-2021
 * 
 * This java code deletes a given booking ID.
 * The response status code should be 200 OK.
 **/

package deleteBooking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.Test;
import testCasesUtil.ReadRequestBody;
import testCasesUtil.ReadURL;

public class DeleteBooking {
	static ReadRequestBody JSONPayload = new ReadRequestBody();
	static ReadURL baseURL = new ReadURL();

	@Test
	public void deleteMyBooking(String token) throws MalformedURLException, IOException
	{
		String url = baseURL.readUrl_DeleteBooking();
		String DELETE_PARAMS = JSONPayload.readPayLoad_DeleteBooking();
		String base64Credentials = new String(
				org.apache.commons.codec.binary.Base64.encodeBase64   
				(org.apache.commons.codec.binary.StringUtils.getBytesUtf8("admin:password123"))
				);
		URL obj = new URL(url);
		String authorizationHeader = "Basic " + base64Credentials;

		System.out.println("\n\n***Authorization Header***\n");
		System.out.println(authorizationHeader);
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("DELETE");
		postConnection.setRequestProperty("admin", "password123");
		postConnection.setRequestProperty("Content-Type", "application/json");
		postConnection.setRequestProperty("Authorization", authorizationHeader);
		postConnection.setRequestProperty("Cookie", "token="+token);
		postConnection.setRequestProperty("Accept", "text/plain");
		postConnection.setDoOutput(true);
		OutputStream os = postConnection.getOutputStream();
		os.write(DELETE_PARAMS.getBytes());
		os.flush();
		os.close();
		int responseCode = postConnection.getResponseCode();
		System.out.println("\n\n***Response***\n");
		System.out.println("Response Code :  " + responseCode);
		System.out.println("Response Message : " + postConnection.getResponseMessage());
		if (responseCode == HttpURLConnection.HTTP_CREATED) {
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
			System.out.println("DELETE NOT WORKED");
			throw new RuntimeException("HTTP error code : "
					+ postConnection.getResponseCode());
		}
	}

}

