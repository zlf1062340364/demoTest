package cn.bmdsj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class LoginSever {
	public static void main(String[]args) {
		try {
			ServerSocket seversocket = new ServerSocket(2000);
			System.out.println("server is start...");
			Socket socket =seversocket.accept();
			System.out.println("client connect server...");
			InputStream is =socket.getInputStream();
			BufferedReader br =new BufferedReader(new InputStreamReader(is));

			  
			  OutputStream os =socket.getOutputStream();
			  PrintWriter out =new PrintWriter(os);
			  Scanner input =new Scanner(System.in);
			  for(int i=0;i<10;i++) {
				 String message=br.readLine();
				 System.out.println(message);
				 
				 String outMessage=input.next();
				 out.println(outMessage);
		         out.flush();
		     
			  }
			// ·µ»Ø½£µ´ËÄ·½
		         out.close();
		         os.close();
			br.close();
			is.close();
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
