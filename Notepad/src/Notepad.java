import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Notepad extends JFrame implements ActionListener {
	JTextArea txtarea;
	JScrollPane jsp;
	String text;
	public Notepad() {
		setBounds(0,0,1450,950);
		//its for declare menubar
		JMenuBar menubar=new JMenuBar();
		menubar.setBackground(Color.DARK_GRAY);
	
		//its for declaring menu
		JMenu file=new JMenu("File");
		JMenu help=new JMenu("Help");
		JMenu edit=new JMenu("Edit");
	
		file.setForeground(Color.white);
		help.setForeground(Color.white);
		edit.setForeground(Color.white);
		file.setFont(new Font("arial",Font.BOLD,18));
		help.setFont(new Font("arial",Font.BOLD,18));
		edit.setFont(new Font("arial",Font.BOLD,18));
		
		//its for declaring menuitem
		//these menuitems for file menu
		JMenuItem newtxt=new JMenuItem("New");
		newtxt.setFont(new Font("arial",Font.BOLD,15));
		newtxt.setForeground(Color.white);
		newtxt.setBackground(Color.black);
		newtxt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
	
		
		JMenuItem open=new JMenuItem("Open");
		open.setFont(new Font("arial",Font.BOLD,15));
		open.setForeground(Color.white);
		open.setBackground(Color.black);
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		
		JMenuItem print=new JMenuItem("Print");
		print.setFont(new Font("arial",Font.BOLD,15));
		print.setForeground(Color.white);
		print.setBackground(Color.black);
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		
		JMenuItem save=new JMenuItem("Save");
		save.setFont(new Font("arial",Font.BOLD,15));
		save.setForeground(Color.white);
		save.setBackground(Color.black);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		
		JMenuItem exit=new JMenuItem("Exit");
		exit.setFont(new Font("arial",Font.BOLD,14));
		exit.setForeground(Color.white);
		exit.setBackground(Color.black);
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,ActionEvent.SHIFT_MASK));
		
		//these menu items for edit
		JMenuItem copy=new JMenuItem("Copy");
		copy.setFont(new Font("arial",Font.BOLD,15));
		copy.setForeground(Color.white);
		copy.setBackground(Color.black);
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		
		JMenuItem paste=new JMenuItem("Paste");
		paste.setFont(new Font("arial",Font.BOLD,15));
		paste.setForeground(Color.white);
		paste.setBackground(Color.black);
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		
		JMenuItem cut=new JMenuItem("Cut");
		cut.setFont(new Font("arial",Font.BOLD,15));
		cut.setForeground(Color.white);
		cut.setBackground(Color.black);
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		
		JMenuItem selectall=new JMenuItem("SelectAll");
		selectall.setFont(new Font("arial",Font.BOLD,15));
		selectall.setForeground(Color.white);
		selectall.setBackground(Color.black);
		selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		
		//these menu item for help menu
		JMenuItem about=new JMenuItem("About Us");
		about.setFont(new Font("arial",Font.BOLD,15));
		about.setForeground(Color.white);
		about.setBackground(Color.black);
		
		
		//adding menuitem in menu
		//its for filemenu
		file.add(newtxt);
		file.add(open);
		file.add(print);
		file.add(save);
		file.add(exit);
		
		//its for edit menu
		edit.add(copy);
		edit.add(paste);
		edit.add(cut);
		edit.add(selectall);
		
		//its for help menu
		help.add(about);
		
		//adding menu in menubar
		menubar.add(file);
		menubar.add(help);
		menubar.add(edit);
		
		//set menubar on jframe
		setJMenuBar(menubar);
		
		//this is for text area
		txtarea=new JTextArea();
		txtarea.setLineWrap(true);
		txtarea.setWrapStyleWord(true);
		txtarea.setFont(new Font("sans-serif",Font.PLAIN,20));
		jsp=new JScrollPane(txtarea);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		add(jsp,BorderLayout.CENTER);
		
		//and here we add actionlistener for every button;
		newtxt.addActionListener(this);
		open.addActionListener(this);
		print.addActionListener(this);
		save.addActionListener(this);
		exit.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		cut.addActionListener(this);
		selectall.addActionListener(this);
		about.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent et) {
		if(et.getActionCommand().equals("New")) {
			txtarea.setText("");
		}
		else if(et.getActionCommand().equals("Open")) {
			JFileChooser openas=new JFileChooser();
			openas.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter restrict=new FileNameExtensionFilter("only txt files","txt");
			openas.addChoosableFileFilter(restrict);
			
			int action=openas.showOpenDialog(this);
			if(action!=JFileChooser.APPROVE_OPTION) {
				return;
			}
			File openfile=openas.getSelectedFile();
			try {
				BufferedReader reader=new BufferedReader(new FileReader(openfile));
				txtarea.read(reader, null);
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		else if(et.getActionCommand().equals("Save")) {
			JFileChooser saveas=new JFileChooser();
			saveas.setApproveButtonText("Save");
			int action=saveas.showOpenDialog(this);
			if(action!=JFileChooser.APPROVE_OPTION) {
				return;
			}
			File filename=new File(saveas.getSelectedFile()+" .txt");
			BufferedWriter outFile=null;
			try {
				outFile=new BufferedWriter(new FileWriter(filename));
				txtarea.write(outFile);
				
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			
		}
		else if(et.getActionCommand().equals("Print")) {
			try {
				txtarea.print();
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(et.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
		else if(et.getActionCommand().equals("Copy")) {
			text=txtarea.getSelectedText();
		}
		else if(et.getActionCommand().equals("Paste")) {
			txtarea.insert(text, txtarea.getCaretPosition());
		}
		else if(et.getActionCommand().equals("Cut")) {
			text=txtarea.getSelectedText();
			txtarea.replaceRange("", txtarea.getSelectionStart(), txtarea.getSelectionEnd());
		}
		else if(et.getActionCommand().equals("SelectAll")) {
			txtarea.selectAll();
		}
		else if(et.getActionCommand().equals("About Us")) {
			new About().setVisible(true);
		}
	}
	
	public static void main(String args[]) {
		new Notepad().setVisible(true);
	}

}
