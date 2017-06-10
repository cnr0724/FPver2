package card;
import java.util.Random;

import inter.ArrayHash;

public class cards {
	ArrayHash<card> deck=new ArrayHash<card>();
	String[] suits={"Heart", "Spade", "Club","Diamond"};
	
	public void newDeck(){
		int i;
		for(i=0;i<4;i++){
			deck.newKey(suits[i]);
		}
		for(i=0;i<4;i++){
			for(int j=0;j<13;j++){
				card c=new card();
				c.setCard(suits[i],j+1);
				
				deck.newValue(suits[i], c);
			}
		}
	}
	
	public card cardSelect(){
		card c=new card();
		while(true){
			Random random=new Random();
			int i=random.nextInt(3);
			int j=random.nextInt(12);
			if(deck.get(suits[i], j).getCardUsed()!=true){
				c=deck.get(suits[i],j);
				deck.get(suits[i], j).cardSelected();
				return c;
			}
		}
	}
	
	public void cardAdd(card c){
		deck.newValue(c.getSuit(),c);
	}
}
