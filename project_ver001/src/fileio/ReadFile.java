package fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//����� ���Ͽ��� �ֹ������� ������ ���Ǵ� Ŭ����
public class ReadFile{
	FileReader fr;
	String orderList="";
	String filePath;

	public void getOrderListToFile(OrderList _ol){
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
	
	public void setFileDatePath(NowTime _nt){
		filePath = "c:/java/";
		filePath +=_nt.getSaveDate()+".txt";
	}
}

