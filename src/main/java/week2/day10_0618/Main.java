package week2.day10_0618;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
	
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		int count = 0;
		
		for(int i=0; i<n; i++) {
			int start=0;
			int end=n-1;
			while(start<end) {
				int sum = arr[start] + arr[end];
				if (start == i)start++;
				else if(end == i )end--;
				else if(sum == arr[i]) {
					count ++;
					break;
				}
				else if(sum>arr[i]) end--;
				else if(sum<arr[i]) start++;
			}
		}
		System.out.println(count);
	}

}
