package ClientGUI;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;


public class TablePanel extends JPanel implements ActionListener{
	JButton jb1 = new JButton("테이블1");
	JButton jb2 = new JButton("테이블2");
	JButton jb3 = new JButton("테이블3");
	JButton jb4 = new JButton("테이블4");
	JButton jb5 = new JButton("테이블5");
	JButton jb6 = new JButton("테이블6");
	JLabel jl1 = new JLabel("테이블1");
	JLabel jl2 = new JLabel("테이블2");
	JLabel jl3 = new JLabel("테이블3");
	JLabel jl4 = new JLabel("테이블4");
	JLabel jl5 = new JLabel("테이블5");
	JLabel jl6 = new JLabel("테이블6");
	

	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();


	public TablePanel(){

		jp1.setLayout(new GridLayout(4,3));
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		jp1.add(jb4);
		jp1.add(jb5);
		jp1.add(jb6);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		add(jp1);
		setVisible(true);
		setSize(200,100);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()){
		case "테이블1":
			new OrderWindow(1,this);
			break;
		case "테이블2":
			new OrderWindow(2,this);
			break;
		case "테이블3":
			new OrderWindow(3,this);
			break;
		case "테이블4":
			new OrderWindow(4,this);
			break;
		case "테이블5":
			new OrderWindow(5,this);
			break;
		case "테이블6":
			new OrderWindow(6,this);
			break;
		}
	}
	public void setPrice(int price){
		jb1.setText("주문금액 : "+price+"원");
	}

}
