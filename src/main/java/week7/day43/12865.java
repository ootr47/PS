package week7.day43;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	
	static int n;
	static int k;
	static int maxValue = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] _input = br.readLine().split(" ");
		n = Integer.parseInt(_input[0]);
		k = Integer.parseInt(_input[1]);
		
		int[] weights = new int[n+1];
		int[] profits = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			String[] input = br.readLine().split(" ");
			
			weights[i] = Integer.parseInt(input[0]);
			profits[i] = Integer.parseInt(input[1]);	
		}
		
		int[][] D = new int[n+1][k + 1];
		
		for (int item = 1; item <= n; item++) {
			
			int itemWeight = weights[item]; 
			int itemProfit = profits[item]; 
			
			for (int weight = 1; weight <= k; weight++) {	
				if (itemWeight <= weight) {
					D[item][weight] = Math.max(D[item - 1][weight], D[item - 1][weight - itemWeight] + itemProfit);
				}
				else {
					D[item][weight] = D[item - 1][weight];
				}
			}
		}


		
		System.out.println(D[n][k]);
	}
	
}
