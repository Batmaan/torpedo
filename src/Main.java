import java.awt.BorderLayout;
import java.awt.Canvas;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

public class Main extends Canvas {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]){

		JFrame frame0 = new JFrame("torpedo0");
		frame0.setBounds(0, 0, 1000, 750);
		frame0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame0.setLayout(new BorderLayout());

		Palya p0 = new Palya();
        frame0.add(new TestPane(p0));
        frame0.setLocationRelativeTo(null);
        frame0.setVisible(true);

        Flotta f0 = new MyFlotta0(p0);
        p0.setFlotta(f0);
        f0.init();
         
         
        for(int i=0; i<100; i++){
        	f0.flottaMozgat(p0);
        	frame0.repaint();
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	f0.lo();
        	frame0.repaint();
        	try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
		/*Scanner s = new Scanner(System.in);
		String line;
		System.out.println("addj meg egy parancsot!");
		System.out.println("[uj ID db]");
		System.out.println("[mozgat ID merre(1-8)]");
		System.out.println("[ujalak ID iregi jregi iuj juj]");
		
		//teszt
		Hajo h0 = new Hajo(1234567, 5);
		List<Koordinata> kord0 = new ArrayList<Koordinata>();
		kord0.add(new Koordinata(0, 0));
		kord0.add(new Koordinata(0, 2));
		kord0.add(new Koordinata(0, 3));
		kord0.add(new Koordinata(0, 4));
		kord0.add(new Koordinata(0, 1));
		h0.setHely(kord0);
		p.addHajo(h0);
		
		// parancsfeldolgozó
		while(true){
			line = s.nextLine();
			if (line==null) break;
			String[] words = line.split(" ");
			if (words[0].equals("uj")){
				Hajo h = new Hajo(Long.parseLong(words[1]), Integer.parseInt(words[2]));
				List<Koordinata> kord = new ArrayList<Koordinata>();
				for(int i=0; i<Integer.parseInt(words[2]); i++){
					System.out.println(i+1 + ". koordinata: sor oszlop ");
					int x = s.nextInt();
					int y = s.nextInt();
					Koordinata k = new Koordinata(x, y);
					kord.add(k);					
				}
				h.setHely(kord);
				p.addHajo(h);
			} else if (words[0].equals("mozgat")){
				p.hajoMozgat(Long.parseLong(words[1]), Integer.parseInt(words[2]));
			} else if (words[0].equals("ujalak")){
				p.hajoUjAlak(Long.parseLong(words[1]), Integer.parseInt(words[2]), Integer.parseInt(words[3]), Integer.parseInt(words[4]), Integer.parseInt(words[5]));
				// uj alakot rosszul mozgatja!!
			}
			frame.repaint();
		}*/
	}
}
