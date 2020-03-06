import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.text.*;


class TextEditor implements ActionListener {
	JPanel p;
	JTextField count;
	JFrame f;
	JMenuBar menubar;
	JMenu file, edit, tools;
	JMenuItem /*open, save, */ exit, copy, cut, paste, selectAll, uppercase, lowercase, capitalise;
	JTextArea a;
	JButton word, character;

	TextEditor() {
		f = new JFrame("Text Editor");
		f.setSize(800, 450);

		p = new JPanel();

		count = new JTextField("word count / character count");
		count.setPreferredSize(new Dimension(500, 35));

		word = new JButton("word");
		character = new JButton("character");

		menubar = new JMenuBar();

		file = new JMenu("File");
		edit = new JMenu("Edit");
		tools = new JMenu("Tools");

		/*open = new JMenuItem("open");
		save = new JMenuItem("save");*/
		exit = new JMenuItem("exit");
		copy = new JMenuItem("copy");
		cut = new JMenuItem("cut");
		paste = new JMenuItem("paste");
		selectAll = new JMenuItem("select all");
		uppercase = new JMenuItem("uppercase");
		lowercase = new JMenuItem("lowercase");
		capitalise = new JMenuItem("capitalise");

		a = new JTextArea();

		f.setVisible(true);
		/*f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));*/

		f.setJMenuBar(menubar);
		menubar.add(file);
		menubar.add(edit);
		menubar.add(tools);
		/*file.add(open);
		file.add(save);*/
		file.add(exit);
		edit.add(copy);
		edit.add(cut);
		edit.add(paste);
		edit.add(selectAll);
		tools.add(uppercase);
		tools.add(lowercase);
		tools.add(capitalise);
		f.add(a);

		p.add(count);
		p.add(word);
		p.add(character);
		f.add(p, BorderLayout.NORTH);


		copy.addActionListener(this);
		cut.addActionListener(this);
		paste.addActionListener(this);
		selectAll.addActionListener(this);
		exit.addActionListener(this);
		/*save.addActionListener(this);
		open.addActionListener(this);*/
		word.addActionListener(this);
		character.addActionListener(this);
		uppercase.addActionListener(this);
		lowercase.addActionListener(this);
		capitalise.addActionListener(this);


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
		if (e.getSource() == word) {
			String[] words = a.getText().split(" ");
			count.setText("words = " + String.valueOf(words.length));
		}
		if (e.getSource() == character) {
			String[] characters = a.getText().split("");
			count.setText("characters = " + String.valueOf(characters.length));
		}
		if (e.getSource() == uppercase) {
			a.setText(a.getText().toUpperCase());
		}
		if (e.getSource() == lowercase) {
			a.setText(a.getText().toLowerCase());
		}
		if (e.getSource() == capitalise) {
			String [] value = a.getText().split(" ");
			String capitalisedValue = "";
			for (int i = 0; i < value.length; i++) {
				capitalisedValue += value[i].substring(0, 1).toUpperCase() + value[i].substring(1) + " ";
			}
			a.setText(capitalisedValue);
		}


		/*if (e.getSource() == save) {
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
		}*/
	}

	public static void main(String [] args) {
		//TextEditor t = new TextEditor();
		Welcome w = new Welcome();
	}

}