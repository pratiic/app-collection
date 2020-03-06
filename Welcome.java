import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Welcome implements ActionListener {
	public static String name;
	JFrame f1;
	JLabel l1, l2, error;
	JTextField t1;
	JButton b1;

	Welcome() {
		f1 = new JFrame("App Collection");
		f1.setSize(450, 400);

		l1 = new JLabel("App Collection");

		l2 = new JLabel("Your Name");

		error = new JLabel("dont leave this blank");


		t1 = new JTextField();
		t1.setMaximumSize( new Dimension(Integer.MAX_VALUE, t1.getPreferredSize().height)); //looked up from the internet

		b1 = new JButton("Get In");
		b1.addActionListener(this);

		f1.setLayout(new BoxLayout(f1.getContentPane(), BoxLayout.Y_AXIS));
		
		f1.add(l1);
		f1.add(Box.createRigidArea(new Dimension(0, 50)));

		f1.add(l2);
		f1.add(Box.createRigidArea(new Dimension(0, 20)));

		f1.add(t1);
		f1.add(Box.createRigidArea(new Dimension(0, 10)));
		
		f1.add(b1);
		f1.add(Box.createRigidArea(new Dimension(0, 10)));
		
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public void actionPerformed(ActionEvent e) {
		if (t1.getText().equals("")) {
			t1.setText("please dont leave this empty");
		}
		else {
			name = t1.getText();
			f1.dispose();
			Menu m = new Menu();

		}
	}
	public static void main(String [] args) {
		Welcome w = new Welcome();
	}
}