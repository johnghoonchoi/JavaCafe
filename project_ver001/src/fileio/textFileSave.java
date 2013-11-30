package fileio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class textFileSave {
	public static void main(String[] args) {
		String savePath;
		savePath = "c:/java/test.txt";
		String selllist ="test";
		char input[] = new char[selllist.length()];
		selllist.getChars(0, selllist.length(), input, 0);
		FileWriter fw = null;
		File f1 = new File(savePath);
		
		try {
			if(!f1.exists())
			{
				fw = new FileWriter(f1);
				fw.write(input);
				fw.close();
			}
			else
			{
				RandomAccessFile raf = new RandomAccessFile(savePath, "rw");
			    raf.seek(raf.length());
			    raf.writeBytes("\r\n append");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
