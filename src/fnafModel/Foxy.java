package fnafModel;

import java.util.Random;


public class Foxy {
	int phase = 0;
	int level;
	boolean triedEntry, onProwl;
	
	Node place;
	Random r = new Random();
	
	Foxy(int level){
		this.phase = 0;
		this.level = level;
		triedEntry = false;
		this.onProwl = false;
		
		place = new Node(10);
		place.next1 = new Node(4);
		place.next1.next1 = new Node(5);
		place.next1.next1.next1 = place;
	}
	
	protected void move(boolean closedL) {
		int k = r.nextInt(20);
		
		if(k < this.level && phase < 4) {
			phase++;
		}
		
		else if(phase == 4 && this.place.spot != 5) {
			place = place.next1;
			this.onProwl = true;
			
		}
		
		else if(this.place.spot == 5) {
			if(triedEntry) {
				phase = 0;
				place = place.next1;
				triedEntry = false;
				this.onProwl = false;
			}
			else {
				triedEntry = true;
				if(!closedL) {
					place.spot = 9;
				}
			}
		}
	}
	
	public int powerYoink(int p) {
		p -= r.nextInt(7)+1;
		return p;
	}
	
}

class Node {
	Node next1;
	Node next2;
	Node next3;
	int spot;
	
	Node(int d){
		this.spot = d;
		this.next1 = null;
		this.next2 = null;
		this.next3 = null;
	}
}