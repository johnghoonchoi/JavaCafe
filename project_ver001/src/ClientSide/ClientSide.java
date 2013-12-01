package ClientSide;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSide {
	public static void main(String[] args) {
		String server = "127.0.0.1";
		int port =Integer.parseInt("9000");
		
		try {
			Socket c = new Socket(server,port);
			
			InputStream is = c.getInputStream();
			
			DataInputStream dis = new DataInputStream(is);
			for(int i =1;i<=10;i++){
				int j = dis.readInt();
				System.out.println("서버로부터 받은 데이터"+j);
			}
			c.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
