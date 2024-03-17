package practise;

public class StaticTest {

	static int test = 2;
	int test1 = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  String a = "aabbccd";
	  String s  =a.charAt(0)+"";
	  int count=1;
	  for(int i=1;i<a.length();i++)
	  {
		  char cur = a.charAt(i);
		  char pre = a.charAt(i-1);
		  if(cur==pre)
		  {
			  count++;
		  }
		  else
		  {
			  if(count>1)
			  {
				  s=s+count;
				  count=1;
			  }
			  s=s+cur;
		  }
	  }
	  if(count>1)
	  {
		  s=s+count;
		  count=1;
	  }
	  System.out.println(s);
	
	}
	

}
