package com.nextech.dscrm;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SmsUtils {

	public static int sendSMS(String accountID, String email, String password,
			String recipient, String message) throws Exception {
		String requestURL = "http://www.redoxygen.net/sms.dll?Action=SendSMS";
		// build the request message
		StringBuilder data = new StringBuilder();
		data.append("AccountId=" + URLEncoder.encode(accountID, "UTF-8"));
		data.append("&Email=" + URLEncoder.encode(email, "UTF-8"));
		data.append("&Password=" + URLEncoder.encode(password, "UTF-8"));
		data.append("&Recipient=" + URLEncoder.encode(recipient, "UTF-8"));
		data.append("&Message=" + URLEncoder.encode(message, "UTF-8"));
		// prepare HTTP connection
		int result;
		URL address = new URL(requestURL);
		HttpURLConnection connection = (HttpURLConnection) address
				.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoInput(true);
		connection.setDoOutput(true);
		// send data
		DataOutputStream out = new DataOutputStream(
				connection.getOutputStream());
		out.writeBytes(data.toString());
		out.flush();
		out.close();
		// read response
		BufferedReader in = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		StringBuilder response = new StringBuilder();
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
			response.append("\n\n\n");
		}
		// parse response code
		String resultCode = response.substring(0, 4);
		result = Integer.parseInt(resultCode);
		in.close();
		return result;
	}

	public static void main(String[] args) {
		String accountID = "the account id";
		String email = "your email";
		String password = "your password";
		String recipient = "the recipient phone number";
		String message = "the message";
		try {
			sendSMS(accountID, email, password, recipient, message);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
