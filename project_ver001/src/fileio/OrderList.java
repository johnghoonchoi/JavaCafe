package fileio;


import java.util.StringTokenizer;
//주문내역을 불러와서 index / 시간 / 주문메뉴 별로 분류

public class OrderList{
	String idxNum;
	String date;
	String orderlist;
	String orderLine;
	public void lineTokenizer(String _line){
		StringTokenizer stk = new StringTokenizer(_line, "[EOOL]");
		
		while(stk.hasMoreTokens()){
			String lineEndValue;
			lineEndValue = stk.nextToken();
			if(lineEndValue.equals("ND")){
				break;
			}
			System.out.println(lineEndValue);
			indexTokenizer(lineEndValue);
		}
	}
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