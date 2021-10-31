package OOPS;

import java.util.*;

class Deck {
	int total = 52;
	boolean deck[][] = new boolean[4][13];

	public void remove(int card, char c) {
		this.deck[c-'a'][card] = true;
		this.total-=1;
	}

	public int probability(int num) {
		int pcount=0;
		for(int i=0; i<4; i++) {
			if(deck[i][num]==false) {
				pcount++;
			}
		}
		return (int)(pcount*1000)/total;
	}
}

public class probabilityOfCards {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Deck d = new Deck();
		int x = s.nextInt();
		while (x != -1) {
			if (x == 1) {
				int card = s.nextInt();
				char suite = s.next().charAt(0);
				d.remove(card, suite);
			} else {
				int card = s.nextInt();
				System.out.println(d.probability(card));
			}
			x = s.nextInt();
		}
	}
}
