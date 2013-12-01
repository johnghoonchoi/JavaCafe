package CafeServer;

import java.io.*;
import java.net.*;

public class CafeServer {

	public static void main(String args[]) throws IOException {
		int port = 7070;
		
		ServerSocket server = new ServerSocket(port);
		System.out.println("CafeServer Start!!");
		
		while(true){
			Socket client = server.accept();
			System.out.println("접속 아이피 : "+client.getInetAddress());
			CafeServerHandler csh = new CafeServerHandler(client);
			csh.init();
		}
	}
}
