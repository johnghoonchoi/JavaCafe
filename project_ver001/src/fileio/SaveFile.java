package fileio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
//�ֹ������� �����ϱ� ���� Ŭ����
public class SaveFile{
	String filePath;
	String selllist;
	FileWriter fw = null;
	// ���Ͽ� �ֹ����� ���
	public void writeFileIO(NowTime _nt,ReadFile _rf){
		filePath = "c:/java/"+_nt.getSaveDate()+".txt";
		
		File f1 = new File(filePath);
		
		try {
			// ������ �������� ������ �����Ͽ� �ε��� 1���� �ֹ����� ���
			if(!f1.exists())
			{
				String firstlist = "1/"+_nt.getOrderTime()+"/#01:1#!"; 
				fw = new FileWriter(f1);
				System.out.println("���ϻ��� : "+firstlist);
				fw.write(firstlist);
				fw.close();
			}
			// ������ �����ϸ� �߰������� �ֹ����� ����
			else
			{
				System.out.println("��������");
				_rf.setFileDatePath(_nt);
				selllist = _rf.getIndexNum()+"/";
				selllist += _nt.getOrderTime()+"/"+"#01:1#02:2"+"#!";
				RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
			    raf.seek(raf.length());
			    raf.writeBytes("\r\n"+selllist);
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}