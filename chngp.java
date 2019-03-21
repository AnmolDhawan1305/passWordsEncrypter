import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
class chngp extends JFrame implements ActionListener{
	JLabel l=new JLabel("Enter old password");
	JLabel L=new JLabel("Enter new Password");
	JPasswordField p1=new JPasswordField();
	JPasswordField p2=new JPasswordField();
	JButton jb1=new JButton("Change");
	JButton jb2=new JButton("Cancel");
	chngp(){
		setSize(400,275);
		setTitle("Change password");
		setLayout(null);
		l.setBounds(25,25,200,50);
		L.setBounds(25,100,200,50);
		p1.setBounds(250,25,100,50);
		p2.setBounds(250,100,100,50);
		jb1.setBounds(75,175,100,25);
		jb2.setBounds(200,175,100,25);
		add(l);
		add(L);
		add(p1);
		add(p2);
		add(jb1);
		add(jb2);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		directx dx=new directx();
		if(e.getSource()==jb1){
			try{
		FileInputStream f=new FileInputStream("work.txt");
		BufferedReader br=new BufferedReader(new InputStreamReader(f));
		String r,p,st="";
		Date d=new Date();
		String s[]=new String[4];
		while(true){
			r=br.readLine();
			if(!r.contains("^")) continue;
			else if(r==null) break;
			else break;
		}
		 f.close();
			s=dx.decode(r);
			if(s[0].equals(p1.getText())){
				int a[]=new int[p2.getText().length()];
			    a=dx.encode(p2.getText()); 
				st+=d.getHours()+d.getMinutes()+d.getSeconds()+"^"+dx.t+" ";
				int k;
				for(int i=0;i<a.length;i++){
			     k=dx.sum(Integer.parseInt(d.getHours()+d.getMinutes()+d.getSeconds()+""));
				 k=k+a[i];
			     st+="!"+k;
				}
				st+=" ";
				st+="!\n";
              p=dx.buff();
              p=p.replace(r,st);
              st=dx.writebuff(p);
			  JOptionPane.showMessageDialog(null,"Updated Successfully");
			  this.dispose();
			  new gui().show();
			}
			else JOptionPane.showMessageDialog(null,"Wrong password");
			}catch(IOException ex){
                  System.out.println(ex);
			}
		}
        else{ 
		this.hide();
		new gui().show();
	}
}	
}
				
		
	