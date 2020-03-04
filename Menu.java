import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Menu implements ActionListener {
	JFrame f1;
	JLabel l1, choose;
	JButton calculator, textEditor, draw;
	String name;
	void setName() {
		Welcome w1 = new Welcome();
		name = w1.name;
	}

	Menu() {
		setName();

		f1 = new JFrame("App Collection");
		f1.setSize(450, 400);

		l1 = new JLabel("WELCOME " + name.toUpperCase());

		choose = new JLabel("CHOOSE AN APP");

		calculator = new JButton("Calculator");

		textEditor = new JButton("Text Editor");

		draw = new JButton("Drawing Board");

		f1.setLayout(new BoxLayout(f1.getContentPane(), BoxLayout.Y_AXIS));
		f1.getContentPane().add(Box.createRigidArea(new Dimension(100, 0)));
		f1.add(l1);
		f1.getContentPane().add(Box.createRigidArea(new Dimension(0, 30)));
		f1.add(choose);
		f1.getContentPane().add(Box.createRigidArea(new Dimension(0, 50)));
		f1.add(calculator);
		f1.getContentPane().add(Box.createRigidArea(new Dimension(0, 50)));
		f1.add(textEditor);
		f1.getContentPane().add(Box.createRigidArea(new Dimension(0, 50)));
		f1.add(draw);

		draw.addActionListener(this);
		textEditor.addActionListener(this);

		f1.setVisible(true);

		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == draw) {
			//f1.dispose();
			DrawIt d = new DrawIt();
		}
		if (e.getSource() == textEditor) {
			//f1.dispose();
			TextEditor t = new TextEditor();
		}
	}

	public static void main(String [] args) {

	}
}