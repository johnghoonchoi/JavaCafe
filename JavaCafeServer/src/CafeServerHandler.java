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
					System.out.println("�ֹ����� :"+message);
					String sm = message.substring(0, 1);
					System.out.println("�ĺ����� :"+sm);
					if(sm.equals("@")){
						SaveFile sF = new SaveFile();
						sF.writeFileIO(message);
					}
					else if(sm.equals("%")){
						System.out.println(message.substring(1, 9));
						readOrderList(message.substring(1, 9));
					}
					
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
	
	public void readOrderList(String readDate){
		ReadFile rF = new ReadFile();
		rF.getOrderListToFile(this,readDate);
	}
	public void sendOrderList(String _orderlist){
		System.out.println("�ֹ��������"+_orderlist);
		try {
			System.out.println("�ֹ����� ����");
			dataOut.writeUTF(_orderlist);
			dataOut.flush();
			System.out.println("���۳�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

