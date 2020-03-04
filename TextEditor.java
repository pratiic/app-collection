import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.text.*;


class TextEditor implements ActionListener {
	JFrame f;
	JMenuBar menubar;
	JMenu file, edit;
	JMenuItem open, save, exit, copy, cut, paste, selectAll;
	JTextArea a;

	TextEditor() {
		f = new JFrame("Text Editor");
		f.setSize(500, 450);

		menubar = new JMenuBar();

		file = new JMenu("File");
		edit = new JMenu("Edit");

		open = new JMenuItem("open");
		save = new JMenuItem("save");
		exit = new JMenuItem("exit");
		copy = new JMenuItem("copy");
		cut = new JMenuItem("cut");
		paste = new JMenuItem("paste");
		selectAll = new JMenuItem("select all");

		a = new JTextArea();

		f.setVisible(true);
		/*f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));*/

		f.setJMenuBar(menubar);
		menubar.add(file);
		menubar.add(edit);
		file.add(open);
		file.add(save);
		file.add(exit);
		edit.add(copy);
		edit.add(cut);
		edit.add(paste);
		edit.add(selectAll);
		f.add(a);

		copy.addActionListener(this);
		cut.addActionListener(this);
		paste.addActionListener(this);
		selectAll.addActionListener(this);
		exit.addActionListener(this);
		save.addActionListener(this);
		open.addActionListener(this);


	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == copy) {
			a.copy();
		}
		if (e.getSource() == cut) {
			a.cut();
		}
		if (e.getSource() == paste) {
			a.paste();
		}
		if (e.getSource() == selectAll) {
			a.selectAll();
		}
		if (e.getSource() == exit) {
			f.dispose();
		}

		if (e.getSource() == save) {
			JFileChooser j = new JFileChooser("e:");
			int r = j.showSaveDialog(null);
			if (r == JFileChooser.APPROVE_OPTION) {
				File fi = new File(j.getSelectedFile().getAbsolutePath());
				try {
					FileWriter wr = new FileWriter(fi, false);
					BufferedWriter w = new BufferedWriter(wr);
					w.write(a.getText());

					w.flush();
					w.close();
				} catch(IOException e1) {
					System.out.println(e1.getMessage());
				}
			}

		}

		if (e.getSource() == open) {
			JFileChooser j = new JFileChooser("f:");
            int r = j.showOpenDialog(null); 
            if (r == JFileChooser.APPROVE_OPTION) {  
                File fi = new File(j.getSelectedFile().getAbsolutePath()); 
  
                try { 
                    String s1 = "", sl = "";  
                    FileReader fr = new FileReader(fi); 
                    BufferedReader br = new BufferedReader(fr); 
                    sl = br.readLine();
                    while ((s1 = br.readLine()) != null) { 
                        sl = sl + "\n" + s1; 
                    }
                    a.setText(sl); 
                } 
                catch (Exception evt) { 
                    JOptionPane.showMessageDialog(f, evt.getMessage()); 
                } 
            }
		}
	}

	public static void main(String [] args) {
		
	}

}