import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;



public class Palya {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// hányszor hányas pálya
	int n;
	
	// ehhez a pályához tartozó flotta
	Flotta f;
	
	// a TestPane-nek kell, hogy tudja hova milyen színt rajzoljon ki
	// plusz egy egyszerű reprezentálása a pálya tartalmának
	int[][] palya; 	
	
	// egyes koordinátákhoz tárolja az ID-t, hogy ha talált van, be tudja azaonosítani a hajót
	long[][] IDtar;
	
	// ebben tároljuk a hajókat, hogy ID alapján könnyen el tudjuk érni
	Map<Long, Hajo> hajok;
	
	// eltároljuk, hogy egyes hajóknak, hány ép eleme van még
	// ez alapján gyorsan kiszűrjük, hogy kilőttük-e a hajót
	Map<Long, Integer> epdarabok;
	
	// lövés avagy mozgás fázis volt-e
	boolean lovesvolt = false;

	// legutolsó lövés
	Koordinata talalat;
	
	// játékos pontszáma
	int pontszam = 0;
	
	// körök száma
	int korok = 0;
	
	public Palya() {
		// TODO Auto-generated constructor stub
		this(100);
	}

	// ctor, init
	public Palya(int n) {
		// TODO Auto-generated constructor stub
		this.n = n;
		palya = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				palya[i][j] = 0;
			}
		}
		IDtar = new long[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				IDtar[i][j] = 0;
			}
		}
		hajok = new TreeMap<Long, Hajo>();
		epdarabok = new TreeMap<Long, Integer>();
		talalat = new Koordinata(100, 100);
	}
	
	// ehhez a flottához tartozik ez a pálya
	// azért kell, hogy ismerje a flottát, h szóljon ki tudja belőle törölni a kilőtt hajót
	public void setFlotta(Flotta f){
		this.f = f;
	}
	
	// új hajó felvétele 
	public void addHajo(Hajo h){
		hajok.put(h.getID(), h);
		epdarabok.put(h.getID(), h.getHossz());
		for(int i=0; i<h.getHossz();i++){
			Koordinata k = new Koordinata(h.getHely().get(i).x, h.getHely().get(i).y);
			if (k.x < n){
				palya[k.y][k.x] = 1;
				IDtar[k.y][k.x] = h.getID();
			}
		}
	}
	
	// hajó törlése
	public void removeHajo(Hajo h){
		hajok.remove(h.getID());
	}
	
	// alakváltoztatás
	public void hajoUjAlak(long ID, int iregi, int jregi, int iuj, int juj){
		Hajo h = hajok.get(ID);
		h.alakValtoztat(iregi, jregi, iuj, juj);
		palya[iregi][jregi] = 0;
		palya[iuj][juj] = 1;
	}
	

	///////////
	////345////
	////206////
	////187////
	///////////
	//////////////////////
	//szelsok: 0 = xmin;//
	//szelsok: 1 = xmax;//
	//szelsok: 2 = ymin;//
	//szelsok: 3 = ymax;//
	//////////////////////
	// még le kell ellenőrizni, hogy van-e ott hajó
	//
	public void hajoMozgat(long ID, int merre){
		lovesvolt = false;
		boolean valtozott = false;
		Hajo h = hajok.get(ID);
		int[] szelsok = h.getSzelsohelyek();
		int xmin = szelsok[0], xmax = szelsok[1], ymin = szelsok[2], ymax = szelsok[3];
		
		if (lephete(merre, h)){
			switch(merre){
			case 0:
				break;
			case 1:
				if (ymax>=n-1) break;
				else {
					h.mozgat(merre); valtozott = true; ymax++; ymin++; xmax--; xmin--;
				}
				break;
			case 2:
				h.mozgat(merre); valtozott = true; xmax--; xmin--;
				break;
			case 3: 
				if (ymin<=0) break;
				else {
					h.mozgat(merre); valtozott = true; ymax--; ymin--; xmax--; xmin--;
				}
				break;
			case 4:
				if (ymin<=0) break;
				else {
					h.mozgat(merre); valtozott = true; ymax--; ymin--;
				}
				break;
			case 5:
				if (ymin<=0) break;
				else {
					h.mozgat(merre); valtozott = true; ymax--; ymin--; xmax++; xmin++;
				}
				break;
			case 6:
				h.mozgat(merre); valtozott = true; xmax++; xmin++;
				break;
			case 7:
				if (ymax>=n-1) break;
				else {
					h.mozgat(merre); valtozott = true; ymax++; ymin++; xmax++; xmin++;
				}
				break;
			case 8:
				if (ymax>=n) break;
				else {
					h.mozgat(merre); valtozott = true; ymax++; ymin++; 
				}
				break;
			default: break;	
			}
			
			// ha mozgott a hajó
			if (valtozott){
				for(int i=szelsok[0]; i<=szelsok[1]; i++){
					for(int j=szelsok[2]; j<=szelsok[3]; j++){
						if (i >= 0 && i < n && j < n) {
							palya[j][i]=0;
							IDtar[j][i]=0;
						}
					}
				}
				
				// ha épp bevittünk egy hajót
				if (h.beerkezendo == 0){
					int ujpont = (int)Math.pow(2, epdarabok.get(ID));
					pontszam += ujpont;
					h.beerkezendo--;
					epdarabok.put(ID, -1);
					System.out.println("pontszam: " + pontszam);
					
				} else { // ha még nem érkezett be
					
					// hova kell 1-est, és hova 2-est írni
					for(int i=0; i<h.getHossz(); i++){
						Koordinata k = new Koordinata(h.getHely().get(i).x, h.getHely().get(i).y);
						if (k.x >= 0 && k.x < n && k.y < n){
							if(h.kilove[i]){
								palya[k.y][k.x] = 2;
							} else {
								palya[k.y][k.x] = 1;
							}
							IDtar[k.y][k.x] = ID;
						}
					}
					
				}
			
			}
		}
	}
	
	// ha lövés történt, akkor megnézi, hogy talált-e
	public int lottek(Koordinata k){
		
		// eltávolítjuk a flottából és az épdarabokból az előző körben célbaért hajókat 
	    Iterator it = epdarabok.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        if (pairs.getValue().equals(-1)){
	        	f.removeHajo((Long)pairs.getKey());
		        it.remove(); // avoids a ConcurrentModificationException	        	
	        }
	    }		
		korok++;
		lovesvolt = true;
		talalat.setKoordianata(k.x, k.y);
		// ha találat van
		if (palya[k.y][k.x] == 1){
			long id = IDtar[k.y][k.x];
			int ep = epdarabok.get(id) - 1;	
			Hajo h = hajok.get(id);	
			
			// ha kilőttek egy hajót
			if (ep == 0){
				epdarabok.remove(id);
				f.removeHajo(id);
				
				// töröljük a palya és a IDtar tárolókból és a hajónyilvántartásból is
				for(int i=0; i<h.getHossz();i++){
					Koordinata k0 = new Koordinata(h.getHely().get(i).x, h.getHely().get(i).y);
					if (k0.x >= 0 && k0.y >= 0 && k0.x < n && k0.y < n){
						palya[k0.y][k0.x] = 0;
						IDtar[k0.y][k0.x] = 0;
					}
				}
				hajok.remove(id);
				System.out.println("ID = " + id + " hajot kilottek!");
				return 2; // süllyedt
				
			} else {
				
				// csökkentjük az ép darabokat
				epdarabok.put(id, ep);
				
				// bejelöljük, hogy a hajó hányadik elemei vannak kilőve
				for(int i=0; i<h.getHossz(); i++){
					if(h.getHely().get(i).x == k.x && h.getHely().get(i).y == k.y){
						h.kilove[i] = true; // hányadik elem van kilőve
						palya[k.y][k.x] = 2;
						break;
					}
				}
				return 1; // talált
			}			
		}
		return 0; // a pálya 0-s vagy 2-es mezejére lőttünk
	}
	
	// collision detection :D
	public boolean lephete(int merre, Hajo h){
		for(int i=0; i<h.getHossz(); i++){
			Koordinata k = new Koordinata();
			k.setKoordianata(h.getHely().get(i).x, h.getHely().get(i).y);
			k.mozgat(merre);
			if (k.x >=0 && k.y >= 0){
				if(palya[k.y][k.x] != 0 && IDtar[k.y][k.x] != h.getID()){
					return false;
				}				
			}
		}
		return true;
	}
	
	
	// konzolra rajzol
	public void rajzol(){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(palya[i][j]);
			}
			System.out.print("\n");
		}
	}

}
