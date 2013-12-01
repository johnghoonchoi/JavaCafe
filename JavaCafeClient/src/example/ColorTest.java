package example;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class MyPanel extends JPanel implements ActionListener {
	JButton button;
	Color color = new Color(0, 0, 0);
	int width;
	int height;

	public MyPanel() {
		setLayout(new BorderLayout());
		button = new JButton("색상 변경");
		button.addActionListener(this);
		add(button, BorderLayout.SOUTH);
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(10, 10, width, height);
	}

	public void actionPerformed(ActionEvent e) {
		color = new Color((int) (Math.random() * 255.0),
				(int) (Math.random() * 255.0), (int) (Math.random() * 255.0));
		width = (int) (Math.random() * 220.0);
		height = (int) (Math.random() * 230.0);

		repaint();
	}
}

public class ColorTest extends JFrame {
	public ColorTest() {
		setSize(240, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Color Test");
		setVisible(true);
		JPanel panel = new MyPanel();
		add(panel);
	}

	public static void main(String[] args) {
		ColorTest s = new ColorTest();
	}

}