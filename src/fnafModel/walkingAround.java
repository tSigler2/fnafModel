package fnafModel;

public class walkingAround {
	public static void main(String[] args) throws InterruptedException{
		int outcome = 0;
		int powerAmount = 100, powerCount = 0;
		int FredCount = 0, BonCount = 0, ChicCount = 0, FoxyCount = 0; 
		boolean rJam = false, lJam = false; int rJamCount = 0, lJamCount = 0;
		
		animatronics Freddy = new animatronics(0, 4); Freddy.FredDefine();
		animatronics Bonny = new animatronics(0, 5); Bonny.BonDefine();
		animatronics Chica = new animatronics(0, 7); Chica.ChicDefine();
		Foxy Foxy = new Foxy(5);
		
		int[] posArray = new int[4];
		
		GraphClass g = makeMap();
		window w = new window(g.edges, posArray);
		w.run(g.edges, posArray);
		
		for(int i = 0; i < 1070; i++) {
			if(FredCount == 5) {
				Freddy.walk(g.edges, window.rC, window.lC);
				FredCount = 0;
			}
			if(BonCount == 8) {
				Bonny.walk(g.edges, window.rC, window.lC);
				BonCount = 0;
			}
			if(ChicCount == 8) {
				Chica.walk(g.edges, window.rC, window.lC);
				ChicCount = 0;
			}
			if(FoxyCount == 8) {
				Foxy.move(window.lC);
				FoxyCount = 0;
			}
			
			if(Freddy.pos == 9 || Bonny.pos == 9 || Chica.pos == 9 || Foxy.place.spot == 9) {
				outcome++;
				break;
			}
			
			posArray[0] = Freddy.pos;
			posArray[1] = Bonny.pos;
			posArray[2] = Chica.pos;
			posArray[3] = Foxy.place.spot;
			w.updateA(posArray, powerAmount);
			w.changeTime(i);
			
			powerCount++;
			
			if(powerCount == 20 && powerAmount > 0) {
				powerAmount -= window.bar;
				powerCount = 0;
			}
			
			if(powerAmount < 0) {
				powerAmount = 0;
			}
			
			System.out.println("F: " + Freddy.pos + " B: " + Bonny.pos + " C: " + Chica.pos + " Foxy: " + Foxy.place.spot + " Current Tick: " + i);
			Thread.sleep(500);
			FredCount++; BonCount++; ChicCount++; FoxyCount++;
			
			if(i == 358) {
				Bonny.level++;
			}
			if(i == 536) {
				Bonny.level++;
				Chica.level++;
				Foxy.level++;
			}
			if(i == 714) {
				Bonny.level++;
				Chica.level++;
				Foxy.level++;
			}
			
			if(Foxy.triedEntry) {
				powerAmount = Foxy.powerYoink(powerAmount);
			}
		}
		
		w.endOfGame(outcome);
	}
	
	private static GraphClass makeMap() {
		GraphClass map = new GraphClass(11);
		map.addEdges(0, 1);
		map.addEdges(1, 2);
		map.addEdges(1, 3);
		map.addEdges(1, 4);
		map.addEdges(1, 7);
		map.addEdges(4, 5);
		map.addEdges(4, 6);
		map.addEdges(5, 9);
		map.addEdges(7, 8);
		map.addEdges(8, 9);
		map.addEdges(1, 10);
		
		return map;
	}
}
