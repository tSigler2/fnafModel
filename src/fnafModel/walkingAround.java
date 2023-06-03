package fnafModel;

public class walkingAround {
	public static void main(String[] args) throws InterruptedException{
		int outcome = 0;
		
		animatronics Freddy = new animatronics(0, 7);
		animatronics Bonny = new animatronics(0, 12);
		animatronics Chica = new animatronics(0, 3);
		Foxy Foxy = new Foxy(15);
		
		int[] posArray = new int[4];
		
		GraphClass g = makeMap();
		window w = new window(g.edges, posArray);
		w.run(g.edges, posArray);
		
		for(int i = 0; i < 400; i++) {
			Freddy.walk(g.edges, w.rC, w.lC);
			Bonny.walk(g.edges, w.rC, w.lC);
			Chica.walk(g.edges, w.rC, w.lC);
			Foxy.move(w.lC);
			
			posArray[0] = Freddy.pos;
			posArray[1] = Bonny.pos;
			posArray[2] = Chica.pos;
			posArray[3] = Foxy.place.spot;
			w.updateA(posArray);
			
			System.out.println("F: " + Freddy.pos + " B: " + Bonny.pos + " C: " + Chica.pos + " Foxy: " + Foxy.place.spot);
			Thread.sleep(500);
			if(Freddy.pos == 9 || Bonny.pos == 9 || Chica.pos == 9 || Foxy.place.spot == 9) {
				outcome++;
				break;
			}
		}
		
		if(outcome == 1) {
			System.out.println("You Lose");
		}
		else {
			System.out.println("You Win");
		}
	}
	
	private static GraphClass makeMap() {
		GraphClass map = new GraphClass(10);
		map.addEdges(0, 1);
		map.addEdges(1, 2);
		map.addEdges(1, 3);
		map.addEdges(1, 4);
		map.addEdges(1, 8);
		map.addEdges(4, 5);
		map.addEdges(4, 6);
		map.addEdges(5, 9);
		map.addEdges(7, 8);
		map.addEdges(8, 9);
		
		return map;
	}
}
