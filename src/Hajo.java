import java.util.ArrayList;
import java.util.List;

public class Hajo {

	private long ID;
	private int hossz;
	private List<Koordinata> hely;
	private Koordinata[] alak;
	private boolean palyanvan;
	
	public boolean[] kilove; // hanyadik elemek vannak kilőve
	
	public Hajo(){
		
	}
	
	public Hajo(long ID, int hossz) {
		// TODO Auto-generated constructor stub
		this.ID = ID;
		this.hossz = hossz;
		hely = new ArrayList<Koordinata>();
		alak = new Koordinata[2];
		alak[0] = new Koordinata(0, 0);
		alak[1] = new Koordinata(0, 0);
		kilove = new boolean[10];
		for(int i=0; i<10; i++){
			kilove[i] = false;
		}
	}
	
	public Koordinata[] getAlak() {
		return alak;
	}
	public List<Koordinata> getHely() {
		return hely;
	}
	public int getHossz() {
		return hossz;
	}
	public long getID() {
		return ID;
	}
	public boolean getPalyanvan() {
		return palyanvan;
	}
	public void setID(long ID){
		this.ID = ID;
	}
	public void setAlak(Koordinata[] alak) {
		this.alak = alak;
	}
	public void setHely(List<Koordinata> hely) {
		this.hely = hely;
	}
	public void setHossz(int hossz) {
		this.hossz = hossz;
	}
	public void setPalyanvan(boolean palyanvan) {
		this.palyanvan = palyanvan;
	}
	
	public void alakValtoztat(int iregi, int jregi, int iuj, int juj){
		for(int i=0; i<hossz; i++){
			if(hely.get(i).x == iregi && hely.get(i).y == jregi){
				hely.get(i).setKoordianata(iuj, juj);
				break;
			}
		}
	}
	
	// lehet még hatékonyabbra, ha koordinátákat rendezve tároljuk
	int[] getSzelsohelyek(int n){
		int[] szelsok = new int[4];
		int xmin=n, xmax=0, ymin=n, ymax=0;
		for(Koordinata k : hely){
			if(k.x<xmin) xmin = k.x;
			if(k.y<ymin) ymin = k.y;
			if(k.x>xmax) xmax = k.x;
			if(k.y>ymax) ymax = k.y;
		}
		szelsok[0] = xmin;
		szelsok[1] = xmax;
		szelsok[2] = ymin;
		szelsok[3] = ymax;
		return szelsok;	
	}
	
	int[] getSzelsohelyek(){
		return getSzelsohelyek(100);
		
	}
	
	///////////
	////345////
	////206////
	////187////
	///////////
	public void mozgat(int merre){
		for(Koordinata k : hely){
			k.mozgat(merre);
		}
	}
}
