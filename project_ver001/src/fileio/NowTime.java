package fileio;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//�ý����� ����ð� ȣ�� Ŭ����
public class NowTime{
	SimpleDateFormat orderTimeFormat;
	Date currentTime = new Date ();
	String mTime;
	// �ֹ������� �ֹ��ð������� Format ����
	public String getOrderTime(){
		orderTimeFormat = new SimpleDateFormat ( "HHmmss", Locale.KOREA );
		mTime = orderTimeFormat.format (currentTime);
		
		return mTime;
	}
	// �����Ǹų��� ����� ���ϸ� ����Ϸ� ����ϱ� ���� Format ����
	public String getSaveDate(){
		orderTimeFormat = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		mTime = orderTimeFormat.format(currentTime);
		
		return mTime;
	}
}