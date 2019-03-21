import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
class addp2 extends JFrame implements FocusListener,ActionListener,ItemListener{
	JLabel l1=new JLabel("Enter your name");
	JLabel l2=new JLabel("select account type");
	JLabel l3=new JLabel("Enter username");
	JLabel l4=new JLabel("Enter password");
	JLabel l5=new JLabel("Please Mention here");
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JPasswordField p=new JPasswordField();
	Choice c=new Choice();
	JButton j1=new JButton("Remember");
	JButton j2=new JButton("Cancel");
	addp2(String s1,String s2,String s3){
		setSize(450,650);
		setTitle("Add password");
		setLayout(null);
		t1.setText(s1);
		t2.setText(s2);
		p.setText(s3);
		l5.setForeground(Color.RED);
		c.addItem("select..");
		
		c.addItem("Facebook");
		c.addItem("Instagram");
		c.addItem("Snapchat");
		c.addItem("Google Acoount");
		c.addItem("Other");
		c.select("Other");
		l1.setBounds(50,50,150,50);
		l2.setBounds(50,150,150,50);
		l5.setBounds(50,250,150,50);
		l3.setBounds(50,350,150,50);
		l4.setBounds(50,450,150,50);
		t1.setBounds(250,50,150,50);
		c.setBounds(250,150,150,50);
		t3.setBounds(250,250,150,50);
		t2.setBounds(250,350,150,50);
		p.setBounds(250,450,150,50);
		j1.setBounds(100,550,100,50);
		j2.setBounds(250,550,100,50);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(t1);
		add(c);
		add(t3);
		add(t2);
		add(p);
		add(j1);
		add(l5);
		add(j2);
		t1.addFocusListener(this);
		t2.addFocusListener(this);
		t3.addFocusListener(this);
		p.addFocusListener(this);
		c.addItemListener(this);
		j1.addActionListener(this);
		j2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==j1){
		Date d=new Date();
		directx dx=new directx();
		String t=dx.buff();
		int a[][]=new int[4][];
		a[0]=new int[t1.getText().length()];
        a[1]=new int[t3.getText().length()];
		a[2]=new int[t2.getText().length()];
		a[3]=new int[p.getText().length()];
		String r[]=new String[4];
		for(int j=0;j<4;j++) r[j]="";
		a[0]=dx.encode(t1.getText().toLowerCase()); r[0]=dx.t;
		a[1]=dx.encode(t3.getText().toLowerCase()); r[1]=dx.t;
		a[2]=dx.encode(t2.getText()); r[2]=dx.t;
		a[3]=dx.encode(p.getText()); r[3]=dx.t;
		t+="\n"+d.getHours()+d.getMinutes()+d.getSeconds()+"^"+r[0]+" "+r[1]+" "+r[2]+" "+r[3]+" ";
		for(int k=0;k<a.length;k++){
			for(int l=0;l<a[k].length;l++){
				int f=dx.sum(Integer.parseInt((d.getHours()+"")+(d.getMinutes()+"")+(d.getSeconds()+"")));
				f=f+a[k][l];
			   t+="!"+f;
			}
		   t+=" ";
		}
		t+="!\n";
		String y=dx.writebuff(t);
		JOptionPane.showMessageDialog(this,y);
		t1.setText("");
		t2.setText("");
		t3.setText("");
		p.setText("");
	}
	else{
		this.hide();
		new gui().show();
	}
	
	}
	public void focusGained(FocusEvent e){
		JTextField t=(JTextField)e.getSource();
		t.setBackground(Color.cyan);
	}
	public void focusLost(FocusEvent e){
		
		JTextField t=(JTextField)e.getSource();
		t.setBackground(Color.white);
	}
	public void itemStateChanged(ItemEvent e){
		Choice c=(Choice)e.getSource();
		if(!(c.getSelectedItem().equals("Other"))){
			this.hide();
			new addp(t1.getText(),t2.getText(),p.getText(),c.getSelectedItem()).show();
		}
	}
	}
		