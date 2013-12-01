import java.awt.Color;


public class Timer extends Thread{
	private int i=0;
	public String timerBuffer; // 04:11:15 등의 경과 시간 문자열이 저장될 버퍼 정의
	BtnTime bt = new BtnTime();
	int mm=0;
	int ss=0;
	public void run(){
		while(true){
			try{
				showSec();
				sleep(1000);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}

	}
	public String timerBuffermethod(){
		System.out.format("[%s]", timerBuffer);
		return timerBuffer;
	}
	public void showSec(){

		ss = ++i;
		if(ss>=10){
			mm++;
			ss=0;
			i=0;
		}


		//일정시간이상되면 btntime에 btn setTextcolor호출 ㅇ.ㅇ 전달해서 btn1버튼 폰트 색 변
		if(mm>=1){
			bt.btnSetTextColor();
		} 
		
		
		timerBuffer = String.format("%02d:%02d", mm, ss);
		// 경과 시간 화면에 출력
		bt.btnSetText(timerBuffer);


	}
}
