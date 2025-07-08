import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int t = sc.nextInt();
		
		int[] arr = new int[n+1];
		long [] sum = new long[n+1];
		long [] mod = new long[t];
		
		arr[0]=0;
		sum[0] =0;
		for(int i= 1; i<=n; i++) {
			arr[i]=sc.nextInt();
			sum[i]=sum[i-1]+arr[i];
		}
		long count = 0;
		
		for(int i=1; i<=n; i++) {
			long k =sum[i]%t;
			
			mod[(int)k]++;
		}
		for(int i=0; i<t; i++) {
			if(mod[i]>1) count += mod[i] * (mod[i]-1) / 2;
		}
		System.out.println(count+mod[0]);
	}

}
