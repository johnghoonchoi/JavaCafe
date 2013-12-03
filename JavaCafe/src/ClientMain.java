import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;


public class ClientMain {
	public static void main(String[] args) {
		new ClientCalculate();
	}
}

class ClientCalculate extends JFrame{
	public ClientCalculate(){
		JFrame mainf = new JFrame("Á¤»ê");
		mainf.setBounds(50, 50, 435, 428);
		mainf.setLayout(new BorderLayout());
		
		String test[]={"1","2","3","4","5"};
		JButton btn1 = new JButton("B1");
		JButton btn2 = new JButton("B2");
		JButton btn3 = new JButton("B3");
		
		JButton btn4 = new JButton("B4");
		
		JTable jt1 = new JTable(new TableModel());
		
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.add(btn1);
		panel1.add(btn2);
		panel1.add(btn3);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.add(btn4);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.add(jt1);

		
		mainf.add(panel1, BorderLayout.NORTH);
		mainf.add(panel2, BorderLayout.WEST);
		mainf.add(panel3, BorderLayout.CENTER);
		
		
		mainf.setSize(435, 428);
		mainf.setVisible(true);
	}

}