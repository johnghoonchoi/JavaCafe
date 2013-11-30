package project_ver001;

import java.util.Scanner;

public class ClientPC{
	int selmenuNum;
	int categoryNum;
	public void clientmain(){
		Scanner sc =new Scanner(System.in);
		MenuList mlist = new MenuList();
		while(true){
			printFirstMenu();
			selmenuNum = sc.nextInt();
			switch(selmenuNum){
			case 1:
				mlist.printCategoryList();
				categoryNum = sc.nextInt();
				mlist.printMenu(categoryNum);
				
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				break;
			}
		}	
	}
	
	public void printFirstMenu(){
		System.out.println("원하시는 메뉴를 선택하세요");
		System.out.println("1: 메뉴보기   2: 주문목록 출력  3: 주문목롟각제  4: 문의사항기록  5: 주문");
	}
	
}
