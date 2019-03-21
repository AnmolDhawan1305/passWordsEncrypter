import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
class dellp2 extends JFrame implements FocusListener,ActionListener,ItemListener{
	JLabel l1=new JLabel("Enter your name");
	JLabel l2=new JLabel("select account type");
	JLabel l3=new JLabel("Enter username");
	String t="";
	JLabel l5=new JLabel("Please Mention here");
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JButton l=new JButton("forget username?");
	Choice c=new Choice();
	JButton j1=new JButton("Delete");
	JButton j2=new JButton("Cancel");
	dellp2(String s1,String s2){
		setSize(450,600);
		setTitle("Delete password");
		setLayout(null);
		t1.setText(s1);
		t2.setText(s2);
		l.setForeground(Color.red);
		l.setBackground(new Color(238,238,238));

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
		l.setBounds(150,425,150,50);
		t1.setBounds(250,50,150,50);
		c.setBounds(250,150,150,50);
		t3.setBounds(250,250,150,50);
		t2.setBounds(250,350,150,50);
		
		j1.setBounds(100,500,100,50);
		j2.setBounds(250,500,100,50);
		add(l1);
		add(l2);
		add(l3);
		
		add(t1);
		add(c);
		add(t3);
		add(t2);
		add(l);
		add(j1);
		add(l5);
		add(j2);
		t1.addFocusListener(this);
		t2.addFocusListener(this);
		t3.addFocusListener(this);
		l.addActionListener(this);
		c.addItemListener(this);
		j1.addActionListener(this);
		j2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		directx dx=new directx();
	  boolean bo=false,bo2=false;
	  String st="";
	 if(e.getSource()==j1){
	   try{
		FileInputStream f=new FileInputStream("work.txt");
		BufferedReader br=new BufferedReader(new InputStreamReader(f));
		String r;
		String s[]=new String[4];
		while(true){
			r=br.readLine();
			if(r==null){
				if(!bo2){
				  JOptionPane.showMessageDialog(this,"no such account added");
				  bo=true;
				}
				else JOptionPane.showMessageDialog(this,"Account information successfully deleted");
				break;
			}
			else if(!r.contains("^")) { 
				
				continue;
			}
		
			s=dx.decode(r);
			if(s[0].equals(t1.getText().toLowerCase()) && s[1].equals(t3.getText().toLowerCase()) && s[2].equals(t2.getText())){
				bo2=true;
				continue;
			}
			else if(s[0].equals(t1.getText().toLowerCase()) && s[1].equals(t3.getText().toLowerCase())){
				 t+=s[2]+"-"; 
			}
				st+=r+"\n\n";
		}
		f.close();
		FileOutputStream f2=new FileOutputStream("work.txt");
		f2.write(st.getBytes());
		f2.close();
		if(!bo){
		t1.setText("");
		t2.setText("");
		t3.setText("");
		}
	   }catch(IOException ex){
		   JOptionPane.showMessageDialog(this,ex.getMessage());
	   }
	}
	else if(e.getSource()==l){
		if(t=="") return;
		String s[]=t.split("-");
		if(s.length==1) {
			t2.setText(s[0].substring(0,s[0].length()));
			t="";
		}
		else{
			JOptionPane.showMessageDialog(this,"Your usernames are:\n"+t.replace("-","\n"));
			t="";
	}
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
			new dellp(t1.getText(),t2.getText(),c.getSelectedItem()).show();
		}
	}
	}
		