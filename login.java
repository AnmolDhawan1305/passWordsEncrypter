import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
class login{
 public static void main(String []args){
try{
		String h=JOptionPane.showInputDialog(null,"Enter Login password");
		if(h==null) System.exit(0);
		File fi=new File("work.txt");
		if(fi.exists()&&!fi.isDirectory()){
		FileInputStream f=new FileInputStream(fi);
		BufferedReader br=new BufferedReader(new InputStreamReader(f));
		String r;
		directx dx=new directx();
		String s[]=new String[4];
		while(true){
			r=br.readLine();
			if(!r.contains("^")) continue;
			else if(r==null) break;
			else break;
		}
		 f.close();
			s=dx.decode(r);
			if(s[0].equals(h)){
		       JOptionPane.showMessageDialog(null,"Login Successful");
			}
			else{ 
			JOptionPane.showMessageDialog(null,"Wrong password");
			System.exit(0);
			}
		}
		else{
			directx dx=new directx();
			Date d=new Date();
			String p="101610010",st="";
			int a[]=new int[p.length()];
			    a=dx.encode(p); 
				st+=d.getHours()+d.getMinutes()+d.getSeconds()+"^"+dx.t+" ";
				int k;
				for(int i=0;i<a.length;i++){
			     k=dx.sum(Integer.parseInt(d.getHours()+d.getMinutes()+d.getSeconds()+""));
				 k=k+a[i];
			     st+="!"+k;
				}
				st+=" ";
				st+="!\n";
              st=dx.writebuff(st);
		}
		}catch(IOException ex){ JOptionPane.showMessageDialog(null,ex.getMessage()); }
		int a=JOptionPane.showConfirmDialog(null,"Do you want to change login password");
		if(a==0) new chngp().show();
        else  new gui().show();
 }
}