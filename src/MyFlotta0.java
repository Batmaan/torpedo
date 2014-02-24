import java.util.ArrayList;
import java.util.Random;


public class MyFlotta0 extends Flotta {
		
	public MyFlotta0(Palya p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	public void init(){
		Hajo e = new Hajo(1, 5);
		ArrayList<Koordinata> hely = new ArrayList<Koordinata>();
		for (int i=0; i<5; i++){
			hely.add(new Koordinata(100+i, 50));
		}
		e.setHely(hely);
		flotta.add(e);
		for (Hajo h : flotta){
			p.addHajo(h);
		}
		Hajo e2 = new Hajo(2, 5);
		ArrayList<Koordinata> hely2 = new ArrayList<Koordinata>();
		for (int i=0; i<5; i++){
			hely2.add(new Koordinata(100+i, 20));
		}
		e2.setHely(hely2);
		flotta.add(e2);
		for (Hajo h : flotta){
			p.addHajo(h);
		}
	}
	
	public void flottaMozgat(Palya p) {
		for(Hajo h : flotta){
			p.hajoMozgat(h.getID(), 2);
		}
		
	}

	public void lo() {
		/*Random rand = new Random(); 
		int x = rand.nextInt(100);  
		int y = rand.nextInt(100); 
		p.lottek(new Koordinata(x, y));*/
		p.lottek(new Koordinata(95, 50));
	}
	


}
