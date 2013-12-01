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
			System.out.println("메뉴 를 선택하세요");
			System.out.println("1: 주문저장/2:리스트출력");
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
// 시스템의 현재시각 호출 클래스
class nowTime{
	SimpleDateFormat orderTimeFormat;
	Date currentTime = new Date ();
	String mTime;
	// 주문내역에 주문시간저장할 Format 지정
	public String getOrderTime(){
		orderTimeFormat = new SimpleDateFormat ( "HHmmss", Locale.KOREA );
		mTime = orderTimeFormat.format (currentTime);
		
		return mTime;
	}
	// 일일판매내역 저장시 파일명 년월일로 기록하기 위한 Format 지정
	public String getSaveDate(){
		orderTimeFormat = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		mTime = orderTimeFormat.format(currentTime);
		
		return mTime;
	}
}
// 주문내역을 저장하기 위한 클래스
class saveFile{
	String filePath;
	String selllist;
	FileWriter fw = null;
	// 파일에 주문내역 기록
	public void writeFileIO(nowTime _nt,readFile _rf){
		filePath = "c:/java/"+_nt.getSaveDate()+".txt";
		
		File f1 = new File(filePath);
		
		try {
			// 파일이 존재하지 않을시 생성하여 인덱스 1부터 주문내역 기록
			if(!f1.exists())
			{
				String firstlist = "1/"+_nt.getOrderTime()+"/#01:1#!"; 
				fw = new FileWriter(f1);
				System.out.println("파일생성 : "+firstlist);
				fw.write(firstlist);
				fw.close();
			}
			// 파일이 존재하면 추가적으로 주문내역 저장
			else
			{
				System.out.println("파일존재");
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
// 저장된 파일에서 주문내역을 읽을때 사용되는 클래스
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
				System.out.println("주문목록 인덱스++"+s);
				_ol.indexTokenizer(s);
			}
			in.close();
		}catch (IOException e) {
	        System.err.println(e); // 에러가 있다면 메시지 출력
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
	        System.err.println(e); // 에러가 있다면 메시지 출력
	    }
		return indexNum;
	}
	public void setFileDatePath(nowTime _nt){
		filePath = "c:/java/";
		filePath +=_nt.getSaveDate()+".txt";
	}
}
// 주문내역을 불러와서 index / 시간 / 주문메뉴 별로 분류
class orderList{
	String idxNum;
	String date;
	String orderlist;
	
	// 인덱스 별로 주문내역을 나눈다
	public void indexTokenizer(String _indexlist){
		StringTokenizer stk = new StringTokenizer(_indexlist, "/");
		
		idxNum = stk.nextToken();
		date = stk.nextToken();
		orderlist = stk.nextToken();
		
		System.out.println("인덱스넘버 : "+idxNum);
		System.out.println("주문시각 : "+date.substring(0, 2)+"시"+date.substring(2, 4)+"분"+date.substring(4, 6)+"초");
		orderTokenizer(orderlist);
	}
	// 주문내역중 주문메뉴별로 나눈다
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