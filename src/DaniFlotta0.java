import java.util.ArrayList;
import java.util.Random;


public class DaniFlotta0 extends Flotta {
		
	public DaniFlotta0(Palya p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	int lepes;
	
	public void init(){
		lepes = 0;
		
		/*   00000
		 * 	 00100
		 *   03X20
		 *   00400
		 */
		
		/*
		Random rand = new Random(); 
		//hajo e1
		Koordinata uj = new Koordinata(0,0);
		Hajo e1 = new Hajo(1, 8);
		ArrayList<Koordinata> hely = new ArrayList<Koordinata>();
		hely.add(new Koordinata(100, 50));
		
		for (int i=0; i<(e1.getHossz()-1); i++){
			merre = rand.nextInt(4)+1;
			
			while (flag == 0){
				if (merre == 1){
					uj.x = hely.get(i).x; 
					uj.y = hely.get(i).y+1;
					for(int j = 0;j<i;j++){
						if () 
					} 
				}
			}
			hely.add(new Koordinata(100+i, 50));
		}
		e1.setHely(hely);
		flotta.add(e1);
		for (Hajo h : flotta){
			p.addHajo(h);
		}
		
		//hajo e2
		
		Hajo e2 = new Hajo(2, 8);
		ArrayList<Koordinata> hely2 = new ArrayList<Koordinata>();
		hely2.add(new Koordinata(100, 20));
		for (int i=1; i<e2.getHossz(); i++){
			hely2.add(new Koordinata(100+i, 20));
		}
		e2.setHely(hely2);
		flotta.add(e2);
		for (Hajo h : flotta){
			p.addHajo(h);
		}*/
		
		
	}
	
	public void generHajo(int HajoID, int HajoHossz){
		Random rand = new Random();
		Hajo pr = new Hajo(HajoID, HajoHossz);
		hajogyart(pr, rand.nextInt(p.n), 100);
		
	}
	
	public void hajogyart(Hajo ph, int xkezd, int ykezd){
		
		Random rand = new Random();
		 
		int merre0 = 0;
		Koordinata uj = new Koordinata(0,0);
		
		ArrayList<Koordinata> hely = new ArrayList<Koordinata>();
		hely.add(new Koordinata(xkezd,ykezd));
		
		
		for (int i=1; i<ph.getHossz(); i++){
			int flag = 1;
			while(flag!=0){
				flag = 0;
				merre0 = rand.nextInt(6)+1;
				if (merre0 == 1){
					uj.x = hely.get(hely.size()-1).x; 
					uj.y = hely.get(hely.size()-1).y-1;
					for(int j = 0; j<i; j++){
						if( (uj.x == hely.get(j).x) && (uj.y == hely.get(j).y) ){ flag = 1; }	
					}					
				}
				if (merre0 == 2 || merre0 == 5){
					uj.x = (hely.get(hely.size()-1).x)+1; 
					uj.y = hely.get(hely.size()-1).y;
					for(int j=0; j<i; j++){
						if( (uj.x == hely.get(j).x) && (uj.y == hely.get(j).y) ){ flag = 1; }
					}
				}
				if (merre0 == 3){
					uj.x = hely.get(hely.size()-1).x; 
					uj.y = hely.get(hely.size()-1).y+1;
					for(int j=0; j<i; j++){
						if( (uj.x == hely.get(j).x) && (uj.y == hely.get(j).y) ){ flag = 1; }
					}
				}
				if (merre0 == 4 || merre0 == 6){
					uj.x = hely.get(hely.size()-1).x-1; 
					uj.y = hely.get(hely.size()-1).y;
					for(int j=0; j<i; j++){
						if( (uj.x == hely.get(j).x) && (uj.y == hely.get(j).y) ){ flag = 1; }
					}
				}

			}
			hely.add(new Koordinata(uj.x,uj.y));
			
			
		}//forvege
		
		ph.setHely(hely);
		flotta.add(ph);
		p.addHajo(ph);
		
		
		
	}
	
	public void flottaMozgat(Palya p) {
		for(Hajo h : flotta){
			p.hajoMozgat(h.getID(), 2);
		}
		
	}

	public void lo() {
		lepes++;
		Random rand = new Random();
		int x = 0;
		if (lepes == 1) {x = 99;}
		else if ((lepes<100) && (lepes >= 2))  {x = 101-lepes;}
		else  {x = rand.nextInt(100);}
		int y = rand.nextInt(100); 
		p.lottek(new Koordinata(x, y));
		
	}
	


}
