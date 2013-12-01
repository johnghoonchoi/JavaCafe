/*** 2013.07.25.
 * 작성자 최종훈
 * 자바 스윙 버튼 이벤트 통해서
 * 버튼 2개 만듬. 버튼 하나는 경고창, 하나는 프로그램 종료
 * 
 * 마우스 이벤트로 하려했는데 그냥 액션이벤트로 하는게 나은거같아서
 * 액션이벤트로하ㅓㅁ..ㅇ.ㅇ..
 * 
/
 * 
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


class ActionEventHandler implements ActionListener{
	public void actionPerformed(ActionEvent e){
		
		//확인이랑 같은 문자열이 나오면 경고창뜨는거
		if(e.getActionCommand().equals("확인"))
		{
			JOptionPane.showMessageDialog(null, "ㅇㅇㅇ.");
		}
		if(e.getActionCommand().equals("닫기"))
		{
			System.exit(0); //이건 프로그램 종료 
		}

	}
	
}


public class BtnTime {
	static JButton btn1;

	
	public static void main(String[] args) {

		
		Timer tm = new Timer();

		
		
		JFrame frm = new JFrame("hihihi");
		frm.setBounds(120,120,400,100);
		frm.setLayout(new FlowLayout());

		
		btn1 = new JButton("");
		
		JButton btn2 = new JButton("닫기");
//		btn2.setBackground(Color.red);


		ActionListener actionHandler= new ActionEventHandler();
		btn1.addActionListener(actionHandler);
		btn2.addActionListener(actionHandler);
		
		
		frm.add(btn1);
		frm.add(btn2);
		frm.setVisible(true);

		
		tm.run();
		
		
		
	}
	
	public void btnSetText(String timerBuffer){
		btn1.setText(timerBuffer);

	}
	// Timer에서 호출 시 버튼1의 색상을 빨갓객으로 변
	public void btnSetTextColor(){
		btn1.setForeground(Color.red);
	}
	
}


