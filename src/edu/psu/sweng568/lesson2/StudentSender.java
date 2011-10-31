package edu.psu.sweng568.lesson2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class StudentSender {

	// An example of loose coupling. We default to sending data to the localhost
	// on port 12345, but either can
	// be overridden on the command line by setting a system property. In Java,
	// this is accomplished by
	// java -Dhostname=<hostname> -Dport=<port> <classname>
	private static final String HOSTNAME = System.getProperty("hostname", "localhost");
	private static final int PORT_NUMBER = Integer.getInteger("port", 12345);

	/**
	 * An example of a program that sends data on a socket. This uses Java
	 * system properties to connect to a specified hostname and port number and
	 * send along several pieces of data about a student.
	 * 
	 * @param args
	 *            not used in this example.
	 * @throws IOException
	 *             Since sockets are a type of interprocess communication,
	 *             IOExceptions are always a possibility. Rather than catch and
	 *             handle each one individually, we simply terminate in the face
	 *             on an I/O exception and print the error information to the
	 *             console.
	 */
	public static void main(String[] args) throws IOException {

		// Step One: We create a socket, attempting to connect to a specific
		// machine, on a specific port.
		System.out.println("Creating a socket to " + HOSTNAME + ":" + PORT_NUMBER);
		Socket socket = new Socket(HOSTNAME, PORT_NUMBER);

		// Step Two: We tie a writer to the socket, so we can write to it
		System.out.println("Opening the output stream");
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

		// Step Three: We create a student object and send that data down the
		// wire to the process listening on the other end.
		System.out.println("Dumping data to the socket");

		Student student = new Student();
		out.println(student.getStudentID());
		out.println(student.getName());
		out.println(student.getSocialSecurityNumber());
		out.println(student.getEmailAddress());
		out.println(student.getHomePhone());

		// Step 4: When we are done, we close the socket and writer
		System.out.println("Closing the socket and shutting down");
		out.close();
		socket.close();
	}

}
