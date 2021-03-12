import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame implements ActionListener {
	JButton jb;
	About(){
		setBounds(400,200,700,550);
		setLayout(null);
		ImageIcon i1=new ImageIcon("C:/Users/Asus/git/repository/Notepad/pic/windows.png");
		Image i2=i1.getImage().getScaledInstance(400, 80,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel jl1=new JLabel(i3);
		jl1.setBounds(160, 50, 400, 80);
		add(jl1);
		
		ImageIcon l1=new ImageIcon("C:/Users/Asus/git/repository/Notepad/pic/notepad.png");
		Image l2=l1.getImage().getScaledInstance(80, 80,Image.SCALE_DEFAULT);
		ImageIcon l3=new ImageIcon(l2);
		JLabel ji1=new JLabel(l3);
		ji1.setBounds(50, 190, 80, 80);
		add(ji1);
		
		JLabel jll=new JLabel("<html>Hello I'm Sabyasachi Java Developer<br>It is a Notepad here you can write and save your important text<br>It is simple code editor like other code editor <br>so enjoye here to write anything</html>");
		jll.setBounds(160,130, 500, 300);
		jll.setFont(new Font("sans-serif",Font.BOLD,25));
		add(jll);
		
		 jb=new JButton("Close");
		 jb.setFont(new Font("Arial",Font.PLAIN,22));
		 jb.setBackground(Color.black);
		 jb.setForeground(Color.white);
		 jb.setFocusPainted(false);
		jb.setBounds(500, 450, 100, 30);
		add(jb);
		
		jb.addActionListener(this);
		
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new About().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("Close")) {
			this.setVisible(false);
		}
		
	}

}
