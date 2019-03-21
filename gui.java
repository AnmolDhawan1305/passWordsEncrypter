import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
public class gui extends JFrame implements ActionListener{
	JButton j1=new JButton("Add Password");
	JButton j2=new JButton("Update password");
	JButton j3=new JButton("Delete Password");
	JButton j4=new JButton("View Password");
	JLabel i=new JLabel(new ImageIcon("D:/projects/encryption/give/images.jpg"));
	gui(){
		
		setSize(400,700);
		setLayout(null);
		setTitle("Password Encryption");
		i.setBounds(100,50,200,200);
		j1.setBounds(100,275,200,75);
		j2.setBounds(100,475,200,75);
		j3.setBounds(100,575,200,75);
		j4.setBounds(100,375,200,75);
		add(j1);
		add(j2);
		add(j3);
		add(j4);
		add(i);
		j1.addActionListener(this);
		j4.addActionListener(this);
		j3.addActionListener(this);
		j2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		this.hide();
		Component c=(Component)e.getSource();
		if(c==j1) new addp("","","","").show();
		else if(c==j2) new udtp("","","","").show();
		else if(c==j3) new dellp("","","").show();
		else new viewp("","","").show();
	}
	
}
	