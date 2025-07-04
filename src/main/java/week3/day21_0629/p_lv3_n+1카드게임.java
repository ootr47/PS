import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int round = 1;
        int n = cards.length;

        ArrayList<Integer> cardList = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        int drawRound = 0;

        for(int i=0; i<n; i++) {
            int cardNum = cards[i];
            if(cardNum <= n/2) cardNum = n+1-cardNum;
        
            if(i >= n/3 && i%2==0) drawRound++;
            
            if(cardList.contains(cardNum)){
                int useCoin = 0;
                int index = cardList.indexOf(cardNum);
                
                if((index - n/3) >= 0) useCoin++;
                if(drawRound>0) useCoin++;  
                
                queue.add(useCoin);
            }
            cardList.add(cardNum);
            
            if(i%2==1 && round == drawRound && !queue.isEmpty()) {
                int useCoin = queue.poll();
                coin-=useCoin;
                if(coin<0) break;
                round++;
            }
            if(round <= drawRound && i%2 == 1) break;
        }
        if(round >= n/2) round = n/2 - 1;
        return round;
    }
}