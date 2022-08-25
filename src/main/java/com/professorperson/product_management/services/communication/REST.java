package com.professorperson.product_management.services.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class REST extends Communication  {
	
	@Override
	public String send(String url, String method, String contentType, String data) {
		return restService(url, method, contentType, data);
	}


	private static String restService(String _url, String method, String contentType, String data) {
		try {
			URL url = new URL(_url);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod(method);

			if (contentType.equals("text/plain")) {
				//data type
				con.setRequestProperty("Content-Type", contentType);
			} else {
				//data type
				con.setRequestProperty("Content-Type", contentType);
				//response
				con.setRequestProperty("Accept", contentType);
			}

			//body
			if (data != "" && data != null) {
				con.setDoOutput(true);
				try (OutputStream os = con.getOutputStream()) {
					byte[] input = data.getBytes("utf-8");
					os.write(input);
					os.flush();
				}
			}

			if (con.getResponseCode() != 200) {
				return Integer.toString(con.getResponseCode());
			}

			//reads REST stream
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String out = "";
			String tempOut = br.readLine();

			while (tempOut != null) {
				out += tempOut;
				tempOut = br.readLine();
			}

			return out;

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "";
	}
}
