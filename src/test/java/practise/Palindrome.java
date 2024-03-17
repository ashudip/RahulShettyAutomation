package practise;

public class Palindrome {
	public static void main(String[] args) {
		int nm = 121;
		int rev = 0;
		while (nm > 0) {
			int digit = nm%10;
			rev=(rev*10)+digit;
			nm=nm/10;
		}
		System.out.println(rev);
	}
}
