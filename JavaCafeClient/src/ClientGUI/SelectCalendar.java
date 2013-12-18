package ClientGUI;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.io.*;

import javax.swing.*;

 

class SelectCalendar extends JFrame implements ActionListener
{
	String [] days = {"일","월","화","수","목","금","토"};
	int year ,month,day,todays,memoday=0;
	Calendar today;
	Calendar cal;
	JButton btnBefore = new JButton("이전달");
	JButton btnAfter = new JButton("다음달");
	JButton[] calBtn = new JButton[49];
	JButton btnCancel = new JButton("취소");
	JPanel jp1= new JPanel();
	JPanel jp2 = new JPanel();     
	JLabel jlMonth = new JLabel();
	JLabel jlYear = new JLabel();
	CalculatePanel cp;
	
	public SelectCalendar(CalculatePanel cp){
		this.cp =cp;
		today = Calendar.getInstance(); //디폴트의 타임 존 및 로케일을 사용해 달력을 가져옵니다.
		cal = new GregorianCalendar();
		year = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH)+1;//1월의 값이 0
		jlMonth.setText(month+"월");
		jlYear.setText(year+"년");
		jp2.setLayout(new FlowLayout());
		jp2.add(btnBefore);      
		jp2.add(jlYear);
		jp2.add(jlMonth);
		jp2.add(btnAfter);
		jp1.setLayout(new GridLayout(7, 7));
		add(jp2,"North");
		gridInit();
		calSet();
		hideInit();
		add(jp1,"West");
		add(btnCancel,"South");
		btnBefore.addActionListener(this);
		btnAfter.addActionListener(this);
		btnCancel.addActionListener(this);
		
		setTitle("조회날짜선택");
		setBounds(100,100,350,300);
		setVisible(true);  
	}
	public void calSet(){
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH,(month-1));
		cal.set(Calendar.DATE,1);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int j=0;
		int hopping=0;
		calBtn[0].setForeground(new Color(255,0,0));//일요일 "일"
		calBtn[6].setForeground(new Color(0,0,255));//토요일 "토"
		for(int i=cal.getFirstDayOfWeek();i<dayOfWeek;i++){
			j++;  
		}
		hopping=j;
		for(int kk=0;kk<hopping;kk++){
			calBtn[kk+7].setText("");
		}
		for(int i=cal.getMinimum(Calendar.DAY_OF_MONTH);i<=cal.getMaximum(Calendar.DAY_OF_MONTH);i++){
			cal.set(Calendar.DATE,i);
			if(cal.get(Calendar.MONTH) !=month-1){
                   break;
            }
            todays=i;
            
            calBtn[i+6+hopping].setForeground(new Color(0,0,0));
            if((i+hopping-1)%7==0){
            	calBtn[i+6+hopping].setForeground(new Color(255,0,0));
            }
            if((i+hopping)%7==0){
            	calBtn[i+6+hopping].setForeground(new Color(0,0,255));
            }
            calBtn[i+6+hopping].setText((i)+"");
		}
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==btnBefore){
			jp1.removeAll();
			calInput(-1);
			gridInit();
			panelInit();  
			calSet();
			hideInit();
			jlYear.setText(year+"년");
			jlMonth.setText(month+"월");
		}else if(ae.getSource()==btnAfter){
			jp1.removeAll();
			calInput(1);
			gridInit();
			panelInit();
			calSet();
			hideInit();
			jlYear.setText(year+"년");
			jlMonth.setText(month+"월");
		}else if(ae.getSource()==btnCancel){
			setVisible(false);
			dispose();
		}else if(Integer.parseInt(ae.getActionCommand()) >= 1 && Integer.parseInt(ae.getActionCommand()) <=31){
			day = Integer.parseInt(ae.getActionCommand());
			System.out.println(year);
			System.out.println(month);
			System.out.println(day);
			
			cp.setDate(year, month, day);
			setVisible(false);
			dispose();
			//calSet();
		}
	}
	public void hideInit(){
		for(int i = 0 ; i < calBtn.length;i++){
			if((calBtn[i].getText()).equals("")){
				calBtn[i].setEnabled(false);
			}
		}
	}
	public void gridInit(){
		for(int i = 0 ; i < days.length;i++)
			jp1.add(calBtn[i] = new JButton(days[i])); 
		for(int i = days.length ; i < 49;i++){
			jp1.add(calBtn[i] = new JButton(""));
			calBtn[i].addActionListener(this);
		}
	}
	public void panelInit(){
		GridLayout gridLayout1 = new GridLayout(7,7);
		jp1.setLayout(gridLayout1); 
	}
	public void calInput(int gap){
		month+=(gap);
		if (month<=0){
			month = 12;
			year  =year- 1;
		}else if (month>=13){
			month = 1;
			year =year+ 1;
		}
	}
}

