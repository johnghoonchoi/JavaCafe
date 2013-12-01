package fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class textFileSave {
	public static void main(String[] args) {
		nowTime nt = new nowTime();
		saveFile sf = new saveFile();
		readFile rf = new readFile();
		orderList ol = new orderList();
		
		Scanner sc = new Scanner(System.in);
		
		int selectMenuNum;
		
		while (true) {
			System.out.println("�޴� �� �����ϼ���");
			System.out.println("1: �ֹ�����/2:����Ʈ���");
			selectMenuNum = sc.nextInt();
			
			switch (selectMenuNum) {
			case 1:	
				sf.writeFileIO(nt,rf);
				break;
			case 2:
				rf.setFileDatePath(nt);
				rf.getOrderListToFile(ol);
				break;

			default:
				break;
			}
	
		}
		//rf.getOrderList();
	}
}
// �ý����� ����ð� ȣ�� Ŭ����
class nowTime{
	SimpleDateFormat orderTimeFormat;
	Date currentTime = new Date ();
	String mTime;
	// �ֹ������� �ֹ��ð������� Format ����
	public String getOrderTime(){
		orderTimeFormat = new SimpleDateFormat ( "HHmmss", Locale.KOREA );
		mTime = orderTimeFormat.format (currentTime);
		
		return mTime;
	}
	// �����Ǹų��� ����� ���ϸ� ����Ϸ� ����ϱ� ���� Format ����
	public String getSaveDate(){
		orderTimeFormat = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		mTime = orderTimeFormat.format(currentTime);
		
		return mTime;
	}
}
// �ֹ������� �����ϱ� ���� Ŭ����
class saveFile{
	String filePath;
	String selllist;
	FileWriter fw = null;
	// ���Ͽ� �ֹ����� ���
	public void writeFileIO(nowTime _nt,readFile _rf){
		filePath = "c:/java/"+_nt.getSaveDate()+".txt";
		
		File f1 = new File(filePath);
		
		try {
			// ������ �������� ������ �����Ͽ� �ε��� 1���� �ֹ����� ���
			if(!f1.exists())
			{
				String firstlist = "1/"+_nt.getOrderTime()+"/#01:1#!"; 
				fw = new FileWriter(f1);
				System.out.println("���ϻ��� : "+firstlist);
				fw.write(firstlist);
				fw.close();
			}
			// ������ �����ϸ� �߰������� �ֹ����� ����
			else
			{
				System.out.println("��������");
				_rf.setFileDatePath(_nt);
				selllist = _rf.getIndexNum()+"/";
				selllist += _nt.getOrderTime()+"/"+"#01:1#02:2"+"#!";
				RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
			    raf.seek(raf.length());
			    raf.writeBytes("\r\n"+selllist);
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
// ����� ���Ͽ��� �ֹ������� ������ ���Ǵ� Ŭ����
class readFile{
	FileReader fr;
	String orderList="";
	String filePath;

	// 
	public void getOrderListToFile(orderList _ol){
		try{
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			String s;
			
			while ((s = in.readLine()) != null) {
				System.out.println("�ֹ���� �ε���++"+s);
				_ol.indexTokenizer(s);
			}
			in.close();
		}catch (IOException e) {
	        System.err.println(e); // ������ �ִٸ� �޽��� ���
	    }
	}
	public int getIndexNum(){
		int indexNum=1;
		try{
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			String s;	
			while ((s = in.readLine()) != null) {
				indexNum++;
			}
			in.close();
		}catch (IOException e) {
	        System.err.println(e); // ������ �ִٸ� �޽��� ���
	    }
		return indexNum;
	}
	public void setFileDatePath(nowTime _nt){
		filePath = "c:/java/";
		filePath +=_nt.getSaveDate()+".txt";
	}
}
// �ֹ������� �ҷ��ͼ� index / �ð� / �ֹ��޴� ���� �з�
class orderList{
	String idxNum;
	String date;
	String orderlist;
	
	// �ε��� ���� �ֹ������� ������
	public void indexTokenizer(String _indexlist){
		StringTokenizer stk = new StringTokenizer(_indexlist, "/");
		
		idxNum = stk.nextToken();
		date = stk.nextToken();
		orderlist = stk.nextToken();
		
		System.out.println("�ε����ѹ� : "+idxNum);
		System.out.println("�ֹ��ð� : "+date.substring(0, 2)+"��"+date.substring(2, 4)+"��"+date.substring(4, 6)+"��");
		orderTokenizer(orderlist);
	}
	// �ֹ������� �ֹ��޴����� ������
	public void orderTokenizer(String _orderlist){
		StringTokenizer stk = new StringTokenizer(_orderlist, "#");
		
		while(true){
			String menuValue;
			menuValue = stk.nextToken();
			
			if(menuValue.equals("!")){
				break;
			}
			
			System.out.println(menuValue);			
		}
	}
}