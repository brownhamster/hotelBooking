/**
 * CreateToken.java
 * Date - 07-Sep-2021
 * 
 * This java code creates the Basic authorization Token using CreateToken API.
 * The response status code should be 200 OK and the response body should contain the generated token.
 **/

package testCasesUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class CreateToken {


	//Creates an AuthToken
	public static String createAuthToken() throws IOException{

		String tokenResponse = null;
		try
		{
			final String POST_PARAMS = "{" + "\"username\":\"admin\"," +
					"\"password\":\"password123\"" + "}";
			System.out.println("\n\n***JSON Payload for Token***\n");
			System.out.println(POST_PARAMS);
			URL obj = new URL("https://restful-booker.herokuapp.com/auth");
			HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
			postConnection.setRequestMethod("POST");
			postConnection.setRequestProperty("Content-Type", "application/json");
			postConnection.setDoOutput(true);
			OutputStream os = postConnection.getOutputStream();
			os.write(POST_PARAMS.getBytes());
			os.flush();
			os.close();
			int responseCode = postConnection.getResponseCode();
			System.out.println("\n\n***Response from Token***\n");
			System.out.println("Response Code :  " + responseCode);
			System.out.println("Response Message : " + postConnection.getResponseMessage());
			if (responseCode == HttpURLConnection.HTTP_OK) { //success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						postConnection.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in .readLine()) != null) {
					response.append(inputLine);
				} in .close();
				tokenResponse = response.toString();
				System.out.println(tokenResponse);
			} 
			else 
			{
				System.out.println("POST NOT WORKED");
				System.exit(0);
			}

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return tokenResponse;

	}
}

