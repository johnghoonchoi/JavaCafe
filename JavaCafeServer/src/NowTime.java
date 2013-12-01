import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//시스템의 현재시각 호출 클래스
public class NowTime{
	SimpleDateFormat orderTimeFormat;
	Date currentTime = new Date ();
	String mTime;
	
	// 주문내역에 주문시간저장할 Format 지정
	public String getOrderTime(){
		orderTimeFormat = new SimpleDateFormat ( "HHmmss", Locale.KOREA );
		mTime = orderTimeFormat.format (currentTime);
		
		return mTime;
	}
	// 일일판매내역 저장시 파일명 년월일로 기록하기 위한 Format 지정
	public String getSaveDate(){
		orderTimeFormat = new SimpleDateFormat ( "yyyyMMdd", Locale.KOREA );
		mTime = orderTimeFormat.format(currentTime);
		
		return mTime;
	}
}