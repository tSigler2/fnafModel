package fnafModel;

public class walkingAround {
	public static void main(String[] args) throws InterruptedException{
		int outcome = 0;
		int powerAmount = 100, powerCount = 0;
		int FredCount = 0, BonCount = 0, ChicCount = 0, FoxyCount = 0; 
		int rJamCount = 0, lJamCount = 0;
		
		int[] posArray = new int[4];
		
		window w = new window(posArray);
		
		w.startGame(posArray);
		
		while(!window.game) Thread.sleep(1);
		
		animatronics Freddy = new animatronics(0, window.aLevel[0]); Freddy.FredDefine();
		animatronics Bonny = new animatronics(0, window.aLevel[0]); Bonny.BonDefine();
		animatronics Chica = new animatronics(0, window.aLevel[0]); Chica.ChicDefine();
		Foxy Foxy = new Foxy(window.aLevel[0]);
		
		w.run(posArray);
		
		for(int i = 0; i < 1070; i++) {
			if(FredCount == 5) {
				Freddy.walk(window.rC, window.lC);
				FredCount = 0;
			}
			if(BonCount == 8) {
				Bonny.walk(window.rC, window.lC);
				if(Bonny.aRoom.next2 == Chica.office) {
					window.lJam = Bonny.doorJam();
					lJamCount = 20;
				}
				BonCount = 0;
			}
			if(ChicCount == 8) {
				Chica.walk(window.rC, window.lC);
				if(Chica.aRoom.next2 == Chica.office) {
					window.rJam = Chica.doorJam();
					rJamCount = 20;
				}
				ChicCount = 0;
			}
			if(FoxyCount == 8 || (FoxyCount%2 == 0 && Foxy.onProwl == true)) {
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
			
			if(window.rJam) {
				rJamCount--;
			}
			if(window.lJam) {
				lJamCount--;
			}
			
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
			
			if(window.rJam && rJamCount == 0) {
				window.rJam = false;
			}
			if(window.lJam && lJamCount == 0) {
				window.lJam = false;
			}
		}
		
		w.endOfGame(outcome);
	}
}