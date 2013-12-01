package fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//저장된 파일에서 주문내역을 읽을때 사용되는 클래스
public class ReadFile{
	FileReader fr;
	String orderList="";
	String filePath;

	public void getOrderListToFile(OrderList _ol){
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
	
	public void setFileDatePath(NowTime _nt){
		filePath = "c:/java/";
		filePath +=_nt.getSaveDate()+".txt";
	}
}

