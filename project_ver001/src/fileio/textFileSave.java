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
			System.out.println("�޴� �� �����ϼ���");
			System.out.println("1: �ֹ�����/2:����Ʈ���/3:����������/4:������������ȸ");
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
				System.out.println("�˻���¥�� �Է��ϼ��� 20131202");
				searchDate = sc.nextInt();
				rts.requestMsg("%"+searchDate);
			default:
				break;
			}
	
		}
	}
}




