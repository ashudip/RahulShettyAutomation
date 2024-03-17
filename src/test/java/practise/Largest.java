package practise;

public class Largest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int []array  = {10,45,-82,19};
		int largest = array[0];
		for(int i=0;i<array.length;i++)
		{
			if(largest<array[i])
			{
				largest=array[i];
			}
		}
		System.out.println(largest);
	}

}
