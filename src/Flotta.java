import java.util.ArrayList;

// flotta ősosztály, ebből származtassátok a saját logikátokat
// pl MyFlotta extends Flotta
// a lényeg, hogy valósítsa meg az absztrakt függvényeket
abstract public class Flotta {

	ArrayList<Hajo> flotta;
	Palya p;
	
	public Flotta(Palya p) {
		// TODO Auto-generated constructor stub
		flotta = new ArrayList<Hajo>();
		this.p = p;
	}
	
	public void removeHajo(Long ID){
		int index;
		for (int i=0; i<flotta.size(); i++){
			if(flotta.get(i).getID() == ID){
				index = i;
				flotta.remove(index);
				break;
				}
			}
		
	}

	// ebben kell inicializálni a flottát
	// még nincs szabály, de max annyi hajót tegyetek bele, amennyit a kiírás alapján az elején kapunk
	public abstract void init();
	
	// melyik hajókat és hogyan mozgassa a pálya az egyes körökben
	// nem kötelező minden hajót mozgatni
	// a hajókat egyesével lehet mozgatni a p.hajoMozgat(long ID, int merre) fg-nyel lehet
	// implementációja: Palya.java 118.sor (jelenleg)
	///////////
	////345////
	////206////
	////187////
	///////////
	public abstract void flottaMozgat(Palya p);

	// hová szeretnétek lőni
	// lőni a p.lottek() fg meghívásával tudtok
	// implementációja: Palya.java 216.sor (jelenleg)
	// 0 : nem talált
	// 1 : talált
	// 2 : süllyedt
	public abstract void lo();
	
	// ezt a függvényt fogja meghívni a main, majd vmilyen algoritmus szerint (pl 10 körönként)
	// azt jelenti, h kaptál egy új Hajót, a megadott ID-val és hosszal
	// te döntöd el, hogy hova teszed, vagy h leteszed-e
	public abstract void getNewHajo(long ID, int hossz);
	
}
