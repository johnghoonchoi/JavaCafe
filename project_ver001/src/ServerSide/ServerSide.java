package ServerSide;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {
	public static void main(String[] args) {
		int port = Integer.parseInt("9000");
		int times = Integer.parseInt("10");
		
		try {
			ServerSocket ss = new ServerSocket(port);
			
			int i = 1;
			
			while(i <= times){
				Socket s = ss.accept();
				OutputStream os = s.getOutputStream();
				
				DataOutputStream dos = new DataOutputStream(os);
				
				for(int j =1; j<= 10; j++)
					dos.writeInt(j);
				s.close();
				++i;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
