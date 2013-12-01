package fileio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RequestToServer{
	private Socket socket;
	private DataInputStream dataIn;
	private DataOutputStream dataOut;
	OrderList ol = new OrderList();
	
	public RequestToServer(){
		try {
			socket = new Socket("192.168.0.4", 7070);
			dataIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			dataOut = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		} catch (IOException ie) {
			stop();
		}
	}
	public void sendOrder(String msg){
		try {
			dataOut.writeUTF(msg);
			dataOut.flush();
		} catch (Exception e) {
		}
	}
	public void requestMsg(String msg){
		try {
			dataOut.writeUTF(msg);
			dataOut.flush();
			String message = dataIn.readUTF();
			System.out.println("받은 메시지"+message);
			String typeMsg = message.substring(0, 1);
			if(!typeMsg.equals("*")){
				ol.lineTokenizer(message);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
	}
	public void stop() {
		try {
			dataIn.close();
			dataOut.close();
			socket.close();

		} catch (IOException e) {
		}
	}
}