package project_ver001;

public class MenuList {
	int categoryNum;
	public void printCategoryList(){
		System.out.println("카테고리목록");
		System.out.println("1: 커피메뉴  2: 논커피메뉴  3: 스무디메뉴  4: 과일쥬스메뉴 51: 빵메뉴  ");
	}
	public void printMenu(int caNum){
		switch (caNum) {
		case 1:
			System.out.println("커피메뉴");
			break;
		case 2:
			System.out.println("논커피메뉴");
			break;
		case 3:
			System.out.println("스무디메뉴");
			break;
		case 4:
			System.out.println("과일쥬스메뉴");
			break;
		case 5:
			System.out.println("빵메뉴");
			break;
		}
	}
	public void getMenuList(){
		System.out.println("메뉴목록 출력");
	}
	public void setMenuNum(){
		
	}
	public void setOptionLIst(){
		
	}
}
