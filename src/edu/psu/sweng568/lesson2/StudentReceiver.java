package edu.psu.sweng568.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This is a simple
 * @author John O'Hara
 *
 */
public class StudentReceiver {

	private static final int PORT_NUMBER = Integer.getInteger("port", 12345);

	/**
	 * This is a simple example of receiving data on a socket.  This process doesn't do anything with the data, it 
	 * just prints out what was received
	 * @param args not used.
	 * @throws IOException  if anything goes wrong during this process, we throw an IOException for easier debugging.
	 * Note that in a production application, more care would need to be taken to handle these exceptions and recover
	 * gracefully.
	 */
	public static void main(String[] args) throws IOException {

		// Step One; We create a server socket, which listens on a given port.
		// Notice we don't give it a hostname, like we do in the sender, because
		// a server socket always listens on this machine
		System.out.println("Creating a server socket");
		ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);

		
		//Step Two:  We wait for someone to connect to us (this will wait indefinitely)...
		System.out.println("Waiting for a client to connect . . . ");
		Socket clientSocket = serverSocket.accept();

		System.out.println("Client connected, echoing received data");
		//Step Three:  Now, we simply repeat anything that was send to us out to the console.  In a real world
		//Application, we would obviously do something more useful with the data.
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String s;
		while ((s = in.readLine()) != null) {
			System.out.println(s);
		}
		
		//Step Four:  We could listen indefinitely, but we will shutdown after talking to one client
		System.out.println("Client disconnected, shutting down");
		in.close();
		clientSocket.close();
		serverSocket.close();

	}
}
