import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;


public class SaveFile {
	private String filePath;
	private String orderList;
	private String orderDate;
	private String orderTime;
	private int idxNum;
	
	FileWriter fw = null;
	NowTime nt;
	ReadFile rf;
	// 파일에 주문내역 기록
	public void writeFileIO(String msg){
		nt = new NowTime();
		rf = new ReadFile();
		orderDate = nt.getSaveDate();
		orderTime = nt.getOrderTime();
		filePath = "c:/java/"+orderDate+".txt";
		idxNum = rf.getIndexNum(filePath);
		File f1 = new File(filePath);
		
		try {
			// 파일이 존재하지 않을시 생성하여 인덱스 1부터 주문내역 기록
			if(!f1.exists())
			{
				//f1.mkdirs();
				String firstlist = "1/"+orderTime+"/"+msg+"#!"; 
				fw = new FileWriter(f1);
				System.out.println("파일생성 : "+firstlist);
				fw.write(firstlist);
				fw.close();
			}
			// 파일이 존재하면 추가적으로 주문내역 저장
			else
			{
				System.out.println("파일존재");
				RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
			    raf.seek(raf.length());
			    orderList = idxNum+"/"+orderTime+"/"+msg;
			    raf.writeBytes("\r\n"+orderList+"#!");
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
