package fileio;


import java.util.StringTokenizer;
//�ֹ������� �ҷ��ͼ� index / �ð� / �ֹ��޴� ���� �з�

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