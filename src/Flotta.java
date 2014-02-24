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
	
	public abstract void init();
	
	public abstract void flottaMozgat(Palya p);

	public abstract void lo();
}
