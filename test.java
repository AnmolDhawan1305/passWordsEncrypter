class test{
   static void ok(String t){
	   t="Hello";
   }
   public static void main(String args[]){
	   String r=new String();
	   r="";
	   test.ok(r);
	   System.out.println(r);
   }
}