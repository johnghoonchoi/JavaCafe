package CafeServer;


import java.io.*;
import java.net.*;
import java.util.*;

public class CafeServerHandler implements Runnable {
	protected Socket socket;

	public CafeServerHandler(Socket socket) {
		this.socket = socket;
	}

	protected DataInputStream dataIn;
	protected DataOutputStream dataOut;
	protected Thread listener;

	public synchronized void init() {
		if (listener == null) {
			try {
				dataIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				dataOut = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
				listener = new Thread(this);
				listener.start();
			} catch (IOException ignored) {
			}
		}

	}

	public synchronized void stop() {
		if (listener != null) {
			try {
				if (listener != Thread.currentThread())
					listener.interrupt();
				listener = null;
				dataOut.close();
			}
			 catch (IOException ignored) {
			}
		}
	}

	private Date pdate;

	public void run() {
		try {
			while (!Thread.interrupted()) {
				String message = dataIn.readUTF();
				try {
					pdate = new Date();
					System.out.println(pdate.toString());
					System.out.println("���޹��� �޽���"+message);
					
					saveFile tmpSF = new saveFile();
					tmpSF.writeFileIO(message);
				} catch (NoSuchElementException e) {
					stop();
				}
			}
		} 
		catch (EOFException ignored) {
				System.out.println( "������ �����ϼ̽��ϴ�.");
		}
		catch (IOException ie) {
				if (listener == Thread.currentThread())
					ie.printStackTrace();
		}finally{
				stop();
		}
	}
}

class saveFile{
	String filePath;
	String selllist;
	FileWriter fw = null;
	// ���Ͽ� �ֹ����� ���
	public void writeFileIO(String msg){
		filePath = "c:/java/"+msg+".txt";
		
		File f1 = new File(filePath);
		
		try {
			// ������ �������� ������ �����Ͽ� �ε��� 1���� �ֹ����� ���
			if(!f1.exists())
			{
				String firstlist = "1/"+msg+"/#01:1#!"; 
				fw = new FileWriter(f1);
				System.out.println("���ϻ��� : "+firstlist);
				fw.write(firstlist);
				fw.close();
			}
			// ������ �����ϸ� �߰������� �ֹ����� ����
			else
			{
				System.out.println("��������");
				RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
			    raf.seek(raf.length());
			    raf.writeBytes("\r\n"+msg);
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
