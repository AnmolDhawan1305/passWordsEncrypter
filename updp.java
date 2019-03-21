import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
class updp extends JFrame implements FocusListener,ActionListener,ItemListener{
	JLabel l1=new JLabel("Enter your name");
	JLabel l2=new JLabel("select account type");
	JLabel l3=new JLabel("Enter username");
	
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JPasswordField p=new JPasswordField();
	Choice c=new Choice();
	JButton j1=new JButton("View");
	JButton j2=new JButton("Cancel");
	viewp(String s1,String s2,String s4){
		setSize(450,450);
		setTitle("view password");
		setLayout(null);
		t1.setText(s1);
		t2.setText(s2);
		
		
		c.addItem("select..");
		c.addItem("Facebook");
		c.addItem("Instagram");
		c.addItem("Snapchat");
		c.addItem("Google Acoount");
		c.addItem("Other");
		c.select(s4);
		l1.setBounds(50,50,150,50);
		l2.setBounds(50,150,150,50);
		l3.setBounds(50,250,150,50);
		
		t1.setBounds(250,50,150,50);
		c.setBounds(250,150,150,50);
		t2.setBounds(250,250,150,50);
		
		j1.setBounds(100,350,100,50);
		j2.setBounds(250,350,100,50);
		add(l1);
		add(l2);
		add(l3);
		
		add(t1);
		add(c);
		add(t2);
		add(j1);
		add(j2);
		t1.addFocusListener(this);
		t2.addFocusListener(this);
		c.addItemListener(this);
		j1.addActionListener(this);
		j2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){ //name~account_type~username~password
	//first sumof hrs,min,secs and sum of its digits + random no.
	  directx dx=new directx();
	  boolean bo=false;
	 if(e.getSource()==j1){
	   try{
		FileInputStream f=new FileInputStream("work.txt");
		BufferedReader br=new BufferedReader(new InputStreamReader(f));
		String r;
		String s[]=new String[4];
		while(true){
			r=br.readLine();
			if(r==null){
				JOptionPane.showMessageDialog(this,"no such account added");
				bo=true;
				break;
			}
			else if(!r.contains("^")) { 
				
				continue;
			}
			s=dx.decode(r);

			if(s[0].equals(t1.getText().toLowerCase()) && s[1].equals(c.getSelectedItem().toLowerCase()) && s[2].equals(t2.getText())){
				JOptionPane.showMessageDialog(this,"Your password is: "+s[3]);
				break;
			}
		}
		f.close();
		if(!bo){
		t1.setText("");
		t2.setText("");
		c.select("select..");
		}
	   }catch(IOException ex){
		   JOptionPane.showMessageDialog(this,ex.getMessage());
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
		if(c.getSelectedItem().equals("Other")){
			this.hide();
			new viewp2(t1.getText(),t2.getText()).show();
		}
	}
	
}
		