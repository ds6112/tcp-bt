//Name: Yang J. Ren
//Assignment 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	//Start of socket function
	public static void createSocket(String hostName, int port) throws IOException {
		Socket echoSocket;
		try {
			 //Open Socket
			 echoSocket = new Socket(hostName, port);
			 //Read Until End of Input
			 BufferedReader cIn = new BufferedReader(new InputStreamReader(System.in));
			 System.out.print("Client: ");
			 String input = cIn.readLine();
			 //Open IO stream on Socket
			 PrintWriter out =new PrintWriter(echoSocket.getOutputStream(), true);
	         out.println(input);
	         BufferedReader in =new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
	         String serverResponse;
	         //Loop Stream Read Until # or $
	         while (true){
	        	 if (input.equals("#") ||input.equals("$")){
	        		 out.println(input);
	        		 System.out.println("Connection Closed");
	        		 break;
	        	 }
	        	 //Print Server Response
	        	 serverResponse = in.readLine();
	        	 System.out.println("Server: " + serverResponse);
	        	 System.out.print("Client: ");
	        	 input = cIn.readLine();
	        	 out.println(input);
	         	}
	         
	         //Close Socket and IO
	         echoSocket.close();
	         cIn.close();
	         in.close();
	 		return;
	         } catch (UnknownHostException e) {
			System.out.println(
				"Please enter a valid hostName.\n");
			
		}
		
	}
	//End socket function
	
	//Start of main function
	public static void main(String[] args) throws IOException {
		//HostName and port initialization
		String hostName;
		int port;
		
		//Check if the arguments are valid
		if ( args.length < 2 || args.length > 2){
			System.out.println("Usage: EchoClient hostip port\n");
			return;
		}
		else {
			
			// Check if first argument is a valid host
			hostName = args[0];
			// Check if second argument is a valid port number
			try {
				port = Integer.parseInt(args[1]);
				//Check port number to see if port is in a suitable range, port should not need admin
				if (port < 1024 || port > 32000){
					System.out.println("Port number should be between 1024 and xxxxxx");
					return;
				}
			}
			catch (NumberFormatException e) {
                System.out.println(
                        "Please enter a valid port for the second argument.\n");
                    return;
			}
		System.out.print("Host: " + hostName + "\n" + "Port: " + port + "\n");
		}
		//End argument check
		
		//Create socket with the given arguments
		createSocket(hostName, port);
	}
	//End main function
}
