import java.io.*;
import java.util.*;
class directx{
    String t;	
	String buff(){
		String r,t="";
		try{
          		FileInputStream f1=new FileInputStream("work.txt");
				BufferedReader br=new BufferedReader(new InputStreamReader(f1));
                while(true){
					r=br.readLine();
					if(r==null) break;
					t+=r+'\n';
				}
				f1.close();
	}catch(FileNotFoundException ex){
		return "";
	}
	catch(IOException e){
		System.out.println(e);
	}
	 return t; 
	}
	String writebuff(String r){
		String t;
	    try{
          		FileOutputStream f1=new FileOutputStream("work.txt");
                f1.write(r.getBytes());
				f1.close();
				t="Added Successfully";
	}catch(Exception e){
		t=e.getMessage();
		System.out.println(e);
	}
	return t;
	}
    int sum(int a){
		        int sum=0;
				String h;
               	String y=Integer.toString(a);
                for(int i=0;i<y.length();i++){
					h="";
					h+=y.charAt(i);
                    sum+=Integer.parseInt(h);
                }
				return sum;
	}				
	int[] encode(String R){
		t="";
		int a;
		int r[]=new int[R.length()];
		for(int i=0;i<R.length();i++){
			a=(int)R.charAt(i);
			r[i]=(int)(33-a+Math.random()*95);
			if((char)r[i]=='!' || (char)r[i]=='^') r[i]++;
			t+=(char)(a+r[i]);
		}
		return r;	
    }
	String[] decode(String t){
		String st;
		int r,k,p=0;
		String h[]=new String[4];
		for(int n=0;n<4;n++) h[n]="";
		int m=t.indexOf("!")+1;
		int a=sum(Integer.parseInt(t.substring(0,t.indexOf("^"))));
		char[] ch=t.toCharArray();
		try{
		for(int i=t.indexOf("^")+1;i<m-2;i++){
			if((int)ch[i]==32) {
				p++;
				i++;
			}
			k=(int)ch[i];
			st="";
			while(ch[m]!='!' && ch[m]!=' '){
				st+=ch[m];
				m++;
			}
			r=Integer.parseInt(st)-a;
			h[p]+=""+(char)(k-r);
			if(ch[m]==' ' && m!=ch.length-2) m++;
			m++;
		}
		return h;
	}catch(NumberFormatException exc){ return h;}
	}
}
