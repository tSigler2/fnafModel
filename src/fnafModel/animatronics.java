package fnafModel;
import java.util.Random;
import java.util.LinkedList;

public class animatronics {
	int pos;
	int level;
	boolean open = true;
	Random r = new Random();
	
	animatronics(int pos, int level){
		this.pos = pos;
		this.level = level;
	}
	
	void changePos(int n) {
		this.pos = n;
	}
	
	void walk(LinkedList<Integer>[] l, boolean rC, boolean lC) {
		int k = r.nextInt(20);
		int path;
		
		if(k < this.level) {
			if((this.pos == 5 && lC) || (this.pos == 8 && rC)) {
				path = r.nextInt(l[pos].size() - 1);
				this.pos = l[pos].get(path);
			}
			else {
				path = r.nextInt(l[pos].size());
				this.pos = l[pos].get(path);
			}
			
			
		}
	}
}
