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
		System.out.println("���Ͻô� �޴��� �����ϼ���");
		System.out.println("1: �޴�����   2: �ֹ���� ���  3: �ֹ���ᰢ��  4: ���ǻ��ױ��  5: �ֹ�");
	}
	
}
