package fileio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
//주문내역을 저장하기 위한 클래스
public class SaveFile{
	String filePath;
	String selllist;
	FileWriter fw = null;
	// 파일에 주문내역 기록
	public void writeFileIO(NowTime _nt,ReadFile _rf){
		filePath = "c:/java/"+_nt.getSaveDate()+".txt";
		
		File f1 = new File(filePath);
		
		try {
			// 파일이 존재하지 않을시 생성하여 인덱스 1부터 주문내역 기록
			if(!f1.exists())
			{
				String firstlist = "1/"+_nt.getOrderTime()+"/#01:1#!"; 
				fw = new FileWriter(f1);
				System.out.println("파일생성 : "+firstlist);
				fw.write(firstlist);
				fw.close();
			}
			// 파일이 존재하면 추가적으로 주문내역 저장
			else
			{
				System.out.println("파일존재");
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