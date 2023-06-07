package fnafModel;
import java.util.Random;
import java.util.LinkedList;

public class animatronics {
	int pos;
	int level;
	boolean open = true;
	Node aRoom, office = new Node(9);
	Random r = new Random();
	
	animatronics(int pos, int level){
		this.pos = pos;
		this.level = level;
		
		this.aRoom = new Node(0);
	}
	
	void walk(LinkedList<Integer>[] l, boolean rC, boolean lC) throws NullPointerException {
		try {
			int k = r.nextInt(20);
			
			int path;
			
			if(k < this.level) {
				path = getPaths(aRoom);
				if(aRoom.next2 == office) {
					if(aRoom.spot == 5 && lC) {
						path--;
					}
					else if(aRoom.spot == 8 && rC) {
						path--;
					}
				}
				k = r.nextInt(path);
				
				if(k == 0) {
					aRoom = aRoom.next1;
					this.pos = aRoom.spot;
				}
				else if(k == 1){
					aRoom = aRoom.next2;
					this.pos = aRoom.spot;
				}
				else if(k == 2) {
					aRoom = aRoom.next3;
					this.pos = aRoom.spot;
				}
			}
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
	}
	
	int getPaths(Node n) {
		if(n.next3 != null) {
			return 3;
		}
		else if(n.next2 != null) {
			return 2;
		}
		else {
			return 1;
		}
	}
	
	boolean doorJam() {
		double h = r.nextDouble();
		if(h < 0.5) {
			return false;
		}
		else {
			return true;
		}
	}
	
	void FredDefine() {
		this.aRoom.next1 = new Node(1); //Stage to Main Dining
		this.aRoom.next1.next2 = new Node(3); //Main Dining to Bathrooms
		this.aRoom.next1.next2.next1 = this.aRoom.next1; //Bathrooms to Main Dining
		this.aRoom.next1.next3 = new Node(11); //Main Dining to Kitchen
		this.aRoom.next1.next3.next1 = this.aRoom.next1; //Kitchen to Main Dining
		this.aRoom.next1.next1 = new Node(7); //Main Dining to Upper E
		this.aRoom.next1.next1.next1 = new Node(8); //Upper E to Lower E
		this.aRoom.next1.next1.next1.next1 = this.aRoom.next1.next1.next1; //Loop from Lower E to Lower E
		this.aRoom.next1.next1.next1.next2 = office; //Lower E to Office
	}
	
	void BonDefine() {
		this.aRoom.next1 = new Node(1); //Stage to Main Dining
		this.aRoom.next1.next1 = new Node(4); //Main Dining to Upper W
		this.aRoom.next1.next1.next1 = new Node(5); //Upper W to Lower W
		this.aRoom.next1.next1.next2 = new Node(6); //Upper W to Closet
		this.aRoom.next1.next1.next2.next1 = this.aRoom.next1.next1.next2; //Closet to Upper W
		this.aRoom.next1.next2 = new Node(2); //Main Dining to Backroom
		this.aRoom.next1.next2.next1 = this.aRoom.next1; //Backroom to Main Dining
		this.aRoom.next1.next1.next2.next2 = this.aRoom.next1; //Closet to Main Dining
		this.aRoom.next1.next1.next1.next1 = this.aRoom.next1; //Lower W to Main Dining
		this.aRoom.next1.next1.next1.next2 = office; //Lower W to Office
		this.aRoom.next1.next1.next2 = this.aRoom.next1; //Upper W to Main Dining
	}
	
	void ChicDefine() {
		this.aRoom.next1 = new Node(1); //Stage to Main Dining
		this.aRoom.next1.next1 = new Node(7); //Main Dining to Upper E
		this.aRoom.next1.next1.next1 = new Node(8); //Upper E to Lower E
		this.aRoom.next1.next1.next2 = this.aRoom.next1; //Upper E to Main Dining
		this.aRoom.next1.next1.next1.next2 = office; //Lower E to Office
		this.aRoom.next1.next1.next1.next1 = this.aRoom.next1.next1; //Lower E to Upper E
		this.aRoom.next1.next2 = new Node(3); //Main Dining to Bathrooms
		this.aRoom.next1.next2.next1 = this.aRoom.next1; //Bathrooms to Main Dining
		this.aRoom.next1.next3 = new Node(11); //Main Dining to Kitchen
		this.aRoom.next1.next3.next1 = this.aRoom.next1; //Kitchen to Main Dining
	}
}