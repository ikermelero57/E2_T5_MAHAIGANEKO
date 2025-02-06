package controler;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JLabel;

public class ServerControl extends Thread {
	
	public static final int PORT = 54321;
	public static Boolean exit = false;
	
	public void run(){

		
		ServerSocket myService;
		Socket client;
	

		try {
			myService = new ServerSocket(PORT);
			
			do {
				System.out.println("Waiting for client");
				client = myService.accept();
				System.out.println("Client accepted");
				ServerThread thread = new ServerThread(client);
				thread.start();

			} while(!exit);
			
			System.out.println("Server closed");
			client.close();
			myService.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	
}
