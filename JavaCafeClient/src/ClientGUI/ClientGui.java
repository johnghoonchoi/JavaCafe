package ClientGUI;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;


public class ClientGui extends JFrame{
	JTabbedPane jtp = new JTabbedPane();
	
	TablePanel tp = new TablePanel();
	CalculatePanel ccp = new CalculatePanel();
	public ClientGui(){
		
		jtp.addTab("���̺�", tp);
		jtp.addTab("����", ccp);
		
		getContentPane().add(jtp);
		
		setVisible(true);
		setSize(385,400);
		setResizable(false);
		
	}
}
