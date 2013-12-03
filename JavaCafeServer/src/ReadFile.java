

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// 저장된 파일을 읽어오는 클래스
public class ReadFile{
	FileReader fr;
	String orderList="";
	String filePath;
	String sendMsg="";

	public void getOrderListToFile(CafeServerHandler csh,String readDate){
		try{
			String readFilePath;
			readFilePath = "c:/java/"+readDate+".txt";
			BufferedReader in = new BufferedReader(new FileReader(readFilePath));
			String s;
			
			while ((s = in.readLine()) != null) {
				System.out.println("주문목록++"+s);
				sendMsg += s;
				sendMsg += "[EOOL]";
				//_ol.indexTokenizer(s);
			}
			sendMsg+="END[EOOL]";
			csh.sendOrderList(sendMsg);
			in.close();
		}catch (IOException e) {
	        System.err.println(e); // ������ �ִٸ� �޽��� ���
	    }
	}
	public int getIndexNum(String _filePath){
		int indexNum=1;
		try{
			BufferedReader in = new BufferedReader(new FileReader(_filePath));	
			while ((in.readLine()) != null) {
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

