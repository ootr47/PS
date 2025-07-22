import java.util.*;
import java.io.*;

class Main {
	
	static int[][] arr;
	static int[] visit;
	static int v, e;
	public static void main(String[] args) throws IOException {
	
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(2);
		arr.add(3);
		arr.add(5);
		arr.add(7);
		
		
		dfs(arr, n);
	}
	
	public static void dfs(ArrayList<Integer> arr, int l) {
		if(l<=1) {
			for(int i=0; i<arr.size(); i++) {
				System.out.println(arr.get(i));	
			}
			return;
		}
		l--;
		ArrayList<Integer> al = new ArrayList<>();
		for(int j =0; j<arr.size(); j++) {
			int n=arr.get(j);
	
			for(int i=1; i<=9; i++) {
				String s = Integer.toString(n);
				s+=Integer.toString(i);
			
				int num = Integer.parseInt(s);
				if(isPrimeNum(num)) {
					al.add(num);
				}
			}
		}
		dfs(al, l);
	}
	
	public static boolean isPrimeNum(int n) {
		
		int rt = (int)Math.sqrt(n);
		
		for(int i=2; i<=rt; i++) {
			if(n%i==0) return false;
		}
		return true;
	}

}
