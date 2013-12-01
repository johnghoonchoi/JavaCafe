package chat;


import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
	private ServerSocket socket = null;
	private Vector v = new Vector();
	public void message(String msg) {
		System.out.println(msg);
		for (int i = 0; i < v.size(); i++) {
			((Client) v.elementAt(i)).sendMessage(msg);
		}
	}
	public void addClient(Client c) {
		v.addElement(c);
	}
	public void removeClient(Client c) {
		String userId = c.getUserId();
		c.closeSocket();
		boolean b = v.remove(c);
		System.out.println(userId + "님이 나가셨습니다.");
	}
	public void setServerSocket(int port) {
		try {
			socket = new ServerSocket(port);
			System.out.println("대기중");
		}
		catch (IOException e) {
			System.out.println("서버 소켓 생성 실패");
		}
		while (true) {
			try {
				Socket server = socket.accept();
				Client c = new Client(server, this);
				addClient(c);
				c.start();
			}
			catch (IOException e) {
				System.out.println("클라이언트 접속 실패");
			}
		}
	}
	public static void main(String args[]) {
		int port = 5000;
		ChatServer cs = new ChatServer();
		cs.setServerSocket(port);
	}
}
class Client extends Thread {
	private Socket server = null;
	private ChatServer cs = null;
	private BufferedReader br = null;
	private BufferedWriter bw = null;
	private String userId = "";
	public Client(Socket s, ChatServer cs) {
		this.server = s;
		this.cs = cs;
		try {
			br =
				new BufferedReader(
					new InputStreamReader(
						server.getInputStream()));
			bw =
				new BufferedWriter(
					new OutputStreamWriter(
						server.getOutputStream()));
			userId = br.readLine();
		}
		catch (IOException e) {
		}
	}
	public void run() {
		String msg = "";
		cs.message(userId + "님 환영합니다!");
		while (true) {
			try {
				msg = br.readLine();
				cs.message(userId + ":" + msg);
			}
			catch (IOException e) {
				cs.removeClient(this);
				break;
			}
		}
	}
	public void sendMessage(String msg) {
		try {
			bw.write(msg + "\n");
			bw.flush();
		}
		catch (IOException e) {
		}
	}
	public String getUserId() {
		return userId;
	}
	public void closeSocket() {
		try {
			br.close();
			bw.close();
			server.close();
		}
		catch (IOException e) {
		}
	}
}

