package week7.day47;
import java.util.Scanner;

class Main {

	static int count = 0;
	static int[][] arr;
	static int N;
	static int r;
	static int c;  
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		int size = (int) Math.pow(2, N);
		int result = divide(1, size, 1, size, 1, size*size);
		
		System.out.println(result-1);
	}
	
	private static int divide(int startC, int endC, int startR, int endR, int start, int end) {
		
		int size = end-start+1;
		
		if(end-start <= 1) return start;
		
		int midR = (startR+endR)/2;
		int midC = (startC+endC)/2;
		
		if(r < midR) {
			if(c < midC) {
				return divide(startC, midC, startR, midR, start, start+size/4-1);
			}
			else {
				return divide(midC+1, endC, startR, midR, start+size/4, start+size/2-1);
			}
		} 
		else {
			if(c < midC) {
				return divide(startC, midC, midR+1, endR, start+size/2, end-size/4);
			}
			else {
				return divide(midC+1, endC, midR+1, endR, end-size/4+1, end);
			}
		}
	}
	
}
