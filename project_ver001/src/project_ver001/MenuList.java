package project_ver001;

public class MenuList {
	int categoryNum;
	public void printCategoryList(){
		System.out.println("ī�װ����");
		System.out.println("1: Ŀ�Ǹ޴�  2: ��Ŀ�Ǹ޴�  3: ������޴�  4: �����꽺�޴� 51: ���޴�  ");
	}
	public void printMenu(int caNum){
		switch (caNum) {
		case 1:
			System.out.println("Ŀ�Ǹ޴�");
			break;
		case 2:
			System.out.println("��Ŀ�Ǹ޴�");
			break;
		case 3:
			System.out.println("������޴�");
			break;
		case 4:
			System.out.println("�����꽺�޴�");
			break;
		case 5:
			System.out.println("���޴�");
			break;
		}
	}
	public void getMenuList(){
		System.out.println("�޴���� ���");
	}
	public void setMenuNum(){
		
	}
	public void setOptionLIst(){
		
	}
}
