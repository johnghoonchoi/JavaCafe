package CommunicationServer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import ClientGUI.CalculatePanel;
import MsgAnalyze.AnalyzeRequestMsg;

public class RequestToServer {
	private Socket socket;
	private DataInputStream dataIn;
	private DataOutputStream dataOut;

	
	
	public RequestToServer(){
		try {
			socket = new Socket("192.168.0.8", 7070);
			dataIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			dataOut = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		} catch (IOException ie) {
			stop();
		}
	}
	
	public void sendMessage(String msg){
		try {
			System.out.println("메시지전송");
			dataOut.writeUTF(msg);
			dataOut.flush();
		} catch (Exception e) {
		}
		stop();
	}
	public void RequestMsg(String msg,CalculatePanel cp){
		
		try {
			dataOut.writeUTF("%"+msg);
			dataOut.flush();
			
			String replyMsg = dataIn.readUTF();
			AnalyzeRequestMsg arm = new AnalyzeRequestMsg();
			arm.ToknizerMsg(replyMsg,cp);

		} catch (Exception e) {
		}
		stop();
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
