import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public class TestPane extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 	private Palya p;
	 	private int columnCount;
	    private int rowCount;
	    private List<Rectangle> cells;
	
	    public TestPane(Palya p){
	    	 this.p = p;
	    	 columnCount = p.n;
	    	 rowCount = p.n;
	    	 cells = new ArrayList<Rectangle>(columnCount*rowCount);
	    }
	    	 
	     @Override
	     protected void paintComponent(Graphics g) {
	         super.paintComponent(g);
	         Graphics2D g2d = (Graphics2D) g.create();
	
	         int width = 700;
	         int height = 700;
	
	         int cellWidth = width / columnCount;
	         int cellHeight = height / rowCount;
	         
	         int xOffset = (width - (columnCount * cellWidth)) / 2;
	         
	         
	         int yOffset = (height - (rowCount * cellHeight)) / 2;
	
	         if (cells.isEmpty()) {
	             for (int row = 0; row < rowCount; row++) {
	                 for (int col = 0; col < columnCount; col++) {
	                     Rectangle cell = new Rectangle(
	                             xOffset + (col * cellWidth),
	                             yOffset + (row * cellHeight),
	                             cellWidth,
	                             cellHeight);
	                     cells.add(cell);
	                 }
	             }
	         }
	         
	         for(int i=0; i<rowCount; i++){
	        	 for (int j=0; j<columnCount; j++){
        			 int index = j  + (i * columnCount);
                     Rectangle cell = cells.get(index);
	        		 if(p.palya[i][j] == 1){
	                     g2d.setColor(Color.GRAY);
	        		 }
	        		 else if(p.palya[i][j] == 2){
	                     g2d.setColor(Color.BLACK);
	        		 } else {
	                     g2d.setColor(Color.BLUE);	        			 
	        		 }
                     g2d.fill(cell);
	        	 }
	         }
	
	         g2d.setColor(Color.BLACK);
	         for (Rectangle cell : cells) {
	             g2d.draw(cell);
	         }
	
	         if (p.lovesvolt){
	        	 int j = p.talalat.x;
	        	 int i = p.talalat.y;
    			 int index = j  + (i * columnCount);
                 Rectangle cell = cells.get(index);
                 g2d.setColor(Color.RED);
                 g2d.fill(cell);
	         }
	         
	        g2d.dispose();
	        
	     }
	     
	     @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 800);
        }
 }
