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
		
		Hajo e1 = new Hajo(1, 5);
		hajogyart(e1,90,10);
		Hajo e2 = new Hajo(2, 7);
		hajogyart(e2,90,25);
		Hajo e3 = new Hajo(3, 4);
		hajogyart(e3,90,40);
		Hajo e4 = new Hajo(4, 6);
		hajogyart(e4,90,55);
		Hajo e5 = new Hajo(5, 5);
		hajogyart(e5,90,70);
		Hajo e6 = new Hajo(6, 4);
		hajogyart(e6,90,85);
		
		Hajo f1 = new Hajo(11, 5);
		hajogyart(f1,70,10);
		Hajo f2 = new Hajo(12, 7);
		hajogyart(f2,70,25);
		Hajo f3 = new Hajo(13, 4);
		hajogyart(f3,70,40);
		Hajo f4 = new Hajo(14, 6);
		hajogyart(f4,70,55);
		Hajo f5 = new Hajo(15, 5);
		hajogyart(f5,70,70);
		Hajo f6 = new Hajo(16, 4);
		hajogyart(f6,70,85);
		
		Hajo g1 = new Hajo(21, 5);
		hajogyart(g1,50,10);
		Hajo g2 = new Hajo(22, 7);
		hajogyart(g2,50,25);
		Hajo g3 = new Hajo(23, 4);
		hajogyart(g3,50,40);
		Hajo g4 = new Hajo(24, 6);
		hajogyart(g4,50,55);
		Hajo g5 = new Hajo(25, 5);
		hajogyart(g5,50,70);
		Hajo g6 = new Hajo(26, 4);
		hajogyart(g6,50,85);
		
		Hajo h1 = new Hajo(31, 5);
		hajogyart(h1,30,10);
		Hajo h2 = new Hajo(32, 7);
		hajogyart(h2,30,25);
		Hajo h3 = new Hajo(33, 4);
		hajogyart(h3,30,40);
		Hajo h4 = new Hajo(34, 6);
		hajogyart(h4,30,55);
		Hajo h5 = new Hajo(35, 5);
		hajogyart(h5,30,70);
		Hajo h6 = new Hajo(36, 4);
		hajogyart(h6,30,85);
		
		Hajo j1 = new Hajo(41, 5);
		hajogyart(j1,10,10);
		Hajo j2 = new Hajo(42, 7);
		hajogyart(j2,10,25);
		Hajo j3 = new Hajo(43, 4);
		hajogyart(j3,10,40);
		Hajo j4 = new Hajo(44, 6);
		hajogyart(j4,10,55);
		Hajo j5 = new Hajo(45, 5);
		hajogyart(j5,10,70);
		Hajo j6 = new Hajo(46, 4);
		hajogyart(j6,10,85);
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
