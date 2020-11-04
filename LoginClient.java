package cn.bmdsj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class LoginClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		try {
			Socket socket =new Socket("localhost",2000);
			System.out.println("Connection...");
			OutputStream os =socket.getOutputStream();
			PrintWriter out =new PrintWriter(os);
			

			
			InputStream is =socket.getInputStream();
			BufferedReader br =new BufferedReader(new InputStreamReader(is));
			Scanner input =new Scanner(System.in);
			for(int i=0;i<10;i++) {
				String outMessage=input.next();
				out.println(outMessage);
				out.flush();
				 String message=br.readLine();
				  System.out.println(message);
			}

			  
			 br.close();
			 is.close();
			out.close();
			os.close();
			socket.close();
			
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}