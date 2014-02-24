
public class Koordinata {
	int x;
	int y;
	
	public Koordinata() {
		x = 0;
		y = 0;
	}
	public Koordinata(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	public void setKoordianata(int x, int y){
		this.x = x;
		this.y = y;
	}

	///////////
	////345////
	////206////
	////187////
	///////////
	void mozgat(int merre){
		switch(merre){
		case 0: 
			break;
		case 1: 
			y++; x--;
			break;
		case 2:
			x--;
			break;
		case 3: 
			y--; x--;
			break;
		case 4: 
			y--;
			break;
		case 5:
			y--; x++;
			break;
		case 6:
			x++;
			break;
		case 7: 
			y++; x++;
			break;
		case 8: 
			y++;
			break;
		default: break;
		}
	}
}
