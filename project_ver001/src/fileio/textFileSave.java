package fileio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class textFileSave {
	public static void main(String[] args) {
		NowTime nt = new NowTime();
		SaveFile sf = new SaveFile();
		ReadFile rf = new ReadFile();
		OrderList ol = new OrderList();
		RequestToServer rts = new RequestToServer();
		
		Scanner sc = new Scanner(System.in);
		
		int selectMenuNum;
		int searchDate;
		while (true) {
			System.out.println("메뉴 를 선택하세요");
			System.out.println("1: 주문저장/2:리스트출력/3:데이터전송/4:서버데이터조회");
			selectMenuNum = sc.nextInt();
			
			switch (selectMenuNum) {
			case 1:	
				sf.writeFileIO(nt,rf);
				break;
			case 2:
				rf.setFileDatePath(nt);
				rf.getOrderListToFile(ol);
				break;
			case 3:
				rts.sendOrder("@test");
				break;
			case 4:
				System.out.println("검색날짜를 입력하세요 20131202");
				searchDate = sc.nextInt();
				rts.requestMsg("%"+searchDate);
			default:
				break;
			}
	
		}
	}
}




