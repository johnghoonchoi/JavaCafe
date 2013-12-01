package chat;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class ChatClient extends Panel {
	private TextField tfMessage = new TextField();
	private TextArea taContent =
		new TextArea("Chatting! (나가시려면 'exit'를 쳐주세요)", 30, 50);
	private Socket client = null;
	private BufferedReader br = null;
	private BufferedWriter bw = null;
	
	public ChatClient(String ip, int port, String id) throws IOException {
		this.setLayout(new BorderLayout());
		this.add("Center", taContent);
		this.add("South", tfMessage);
		taContent.setEditable(false);
		tfMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfMessage_actionPerformed(e);
			}
		});
		
		try {
			client = new Socket(ip, port);
			br =
				new BufferedReader(
					new InputStreamReader(
						client.getInputStream()));
			bw =
				new BufferedWriter(
					new OutputStreamWriter(
						client.getOutputStream()));
			bw.write(id);
			bw.newLine();
			bw.flush();
		}
		catch (IOException e) {
			System.out.println("접속 실패!!");
			throw e;
		}
		SendMessage sm = new SendMessage(br, this);
		sm.start();
	}
	public void tfMessage_actionPerformed(ActionEvent e) {
		String msg = tfMessage.getText().trim();
		if (!msg.equals("")) {
			try {
				if (msg.equalsIgnoreCase("exit"))
					System.exit(0);
				bw.write(msg);
				bw.newLine();
				bw.flush();
				tfMessage.setText("");
			}
			catch (IOException ex) {
			}
		}
	}
	public void message(String msg) {
		taContent.append("\n" + msg);
		tfMessage.requestFocus();
	}

	public static void main(String[] args) {
		int port = 5000;
		String ip = "127.0.0.1";
		String id = "test";
		Frame f = new Frame("Chat Client");
		try {
			f.add(new ChatClient(ip, port, id), BorderLayout.CENTER);
		}
		catch (IOException e) {
			System.exit(-1);
		}
		f.pack();
		f.setVisible(true);
	}

	class SendMessage extends Thread {
		BufferedReader br = null;
		ChatClient cc = null;
		public SendMessage(BufferedReader br, ChatClient cc) {
			this.cc = cc;
			this.br = br;
		}
		public void run() {
			String msg = "";
			while (true) {
				try {
					msg = br.readLine();
					if (msg != null) {
						cc.message(msg);
					}
				}
				catch (IOException e) {
				}
			}
		}
	}
}
