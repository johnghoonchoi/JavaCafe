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
	// ���Ͽ� �ֹ����� ���
	public void writeFileIO(String msg){
		nt = new NowTime();
		rf = new ReadFile();
		orderDate = nt.getSaveDate();
		orderTime = nt.getOrderTime();
		filePath = "c:/java/"+orderDate+".txt";
		idxNum = rf.getIndexNum(filePath);
		File f1 = new File(filePath);
		
		try {
			// ������ �������� ������ �����Ͽ� �ε��� 1���� �ֹ����� ���
			if(!f1.exists())
			{
				//f1.mkdirs();
				String firstlist = "1/"+orderTime+"/"+msg+"#!"; 
				fw = new FileWriter(f1);
				System.out.println("���ϻ��� : "+firstlist);
				fw.write(firstlist);
				fw.close();
			}
			// ������ �����ϸ� �߰������� �ֹ����� ����
			else
			{
				System.out.println("��������");
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
