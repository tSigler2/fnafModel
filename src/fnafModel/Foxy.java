package fnafModel;

import java.util.Random;


public class Foxy {
	int phase = 0;
	int level;
	boolean triedEntry;
	
	Node place;
	Random r = new Random();
	
	Foxy(int level){
		this.phase = 0;
		this.level = level;
		triedEntry = false;
		
		place = new Node(10);
		place.next = new Node(4);
		place.next.next = new Node(5);
		place.next.next.next = place;
	}
	
	protected void move(boolean closedL) {
		int k = r.nextInt(20);
		
		if(k < this.level && phase < 4) {
			phase++;
		}
		
		else if(phase == 4 && this.place.spot != 5) {
			place = place.next;
		}
		
		else if(this.place.spot == 5) {
			if(triedEntry) {
				phase = 0;
				place = place.next;
				triedEntry = false;
			}
			else {
				triedEntry = true;
				if(!closedL) {
					place.spot = 9;
				}
			}
		}
	}
	
}

class Node {
	Node next;
	int spot;
	
	Node(int d){
		this.spot = d;
		this.next = null;
	}
}
