import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;

class DrawIt implements ActionListener, MouseMotionListener {
	JFrame f;
	/*JMenuBar menubar;
	JMenu color;
	JRadioButtonMenuItem red, green, yellow, blue, orange;*/
	JLabel x, y, w, h, str, strt, startAngle, arcAngle;
	JTextField xpos, ypos, width, height, stringValue, startangle, arcangle;
	JButton rect, oval, clear, stringg, arc;

	DrawIt() {
		f = new JFrame("paint");
		f.setSize(800, 750);

		/*menubar = new JMenuBar();
		color = new JMenu("color");
		red = new JRadioButtonMenuItem("red");
		green = new JRadioButtonMenuItem("green");
		yellow = new JRadioButtonMenuItem("yellow");
		blue = new JRadioButtonMenuItem("blue");
		orange = new JRadioButtonMenuItem("orange");*/

		xpos = new JTextField("0");
		ypos = new JTextField("0");
		width = new JTextField("0");
		height = new JTextField("0");
		stringValue = new JTextField("0");
		startangle = new JTextField("0");
		arcangle = new JTextField("0");

		x = new JLabel("x-pos");
		y = new JLabel("y-pos");
		w = new JLabel("width");
		h = new JLabel("height");
		str = new JLabel("string");
		startAngle = new JLabel("start angle");
		arcAngle = new JLabel("arc angle");


		rect = new JButton("rectangle");
		rect.setBounds(30, 70, 100, 20);
		oval = new JButton("oval");
		oval.setBounds(150, 70, 100, 20);
		clear = new JButton("clear");
		clear.setBounds(670, 30, 100, 20);
		stringg = new JButton("string");
		stringg.setBounds(270, 70, 100, 20);
		arc = new JButton("arc");
		arc.setBounds(390, 70, 100, 20);


		x.setBounds(10, 10, 40, 20);
		xpos.setBounds(50, 10, 100, 20);

		y.setBounds(170, 10, 40, 20);
		ypos.setBounds(210, 10, 100, 20);

		w.setBounds(330, 10, 40, 20);
		width.setBounds(370, 10, 100, 20);

		h.setBounds(500, 10, 40, 20);
		height.setBounds(550, 10, 100, 20);

		str.setBounds(10, 40, 100, 20);
		stringValue.setBounds(50, 40, 100, 20);

		startAngle.setBounds(170, 40, 70, 20);
		startangle.setBounds(250, 40, 100, 20);

		arcAngle.setBounds(370, 40, 70, 20);
		arcangle.setBounds(440, 40, 100, 20);

		
	
		f.add(x);
		f.add(xpos);
		f.add(y);
		f.add(ypos);
		f.add(w);
		f.add(width);
		f.add(h);
		f.add(height);
		f.add(str);
		f.add(stringValue);
		f.add(startAngle);
		f.add(startangle);
		f.add(arcAngle);
		f.add(arcangle);
		f.add(rect);
		f.add(oval);
		f.add(stringg);
		f.add(arc);
		f.add(clear);
		
		
		
		
		
		
		
		


		//f.setLayout(new FlowLayout(FlowLayout.LEFT));
		f.setLayout(null);
		f.setVisible(true);

		/*red.addActionListener(this);
		green.addActionListener(this);
		yellow.addActionListener(this);
		blue.addActionListener(this);
		orange.addActionListener(this);*/

		f.addMouseMotionListener(this);

		rect.addActionListener(this);
		oval.addActionListener(this);
		clear.addActionListener(this);
		stringg.addActionListener(this);
		arc.addActionListener(this);


		drawLine();
		

	}

	public void drawLine() {
		Graphics g = f.getGraphics();
		g.drawLine(200, 200, 300, 300);
	}

	public void mouseDragged(MouseEvent e) {
		Graphics g = f.getGraphics();
		g.fillRect(e.getX(), e.getY(), 4, 4);
	}

	public void actionPerformed(ActionEvent e) {
		int xPos = Integer.parseInt(xpos.getText());
		int yPos = Integer.parseInt(ypos.getText());
		int wdth = Integer.parseInt(width.getText());
		int hgt = Integer.parseInt(height.getText());
		String value = stringValue.getText();
		int sa = Integer.parseInt(startangle.getText());
		int aa = Integer.parseInt(arcangle.getText());


		if (/*xPos > 600 || yPos < 150 || yPos > 600 || wdth > 500 || hgt > 500*/yPos < 150) {
			//xpos.setText("xpos < 600");
			ypos.setText("ypos > 150");
			//width.setText("widht < 500");
			//height.setText("height < 500");
		} else {
			if (e.getSource() == rect) {
			Graphics g = f.getGraphics();
			g.setColor(Color.BLACK);
			g.drawRect(xPos, yPos, wdth, hgt);
			}


			if (e.getSource() == oval) {
				Graphics g = f.getGraphics();
				g.setColor(Color.BLACK);
				g.drawOval(xPos, yPos, wdth, hgt);
			}

			if (e.getSource() == arc) {
			Graphics g = f.getGraphics();
			g.setColor(Color.BLACK);
			g.drawArc(xPos, yPos, wdth, hgt, sa, aa);
			}

			if (e.getSource() == stringg) {
				Graphics g = f.getGraphics();
				g.setColor(Color.BLACK);
				g.drawString(value, xPos, yPos);
			}
		}


		

		if (e.getSource() == clear) {
			String empty = "0";
			xpos.setText(empty);
			ypos.setText(empty);
			width.setText(empty);
			height.setText(empty);
			stringValue.setText(empty);
			startangle.setText(empty);
			arcangle.setText(empty);

		}
	}

	public void mouseMoved(MouseEvent e) {

	}

	public static void main(String [] args) {
		DrawIt d = new DrawIt();
	}
}