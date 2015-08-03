package matrix.util;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class Graphics {
	
	public static void main(String [] args) {
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    Font[] fonts = e.getAllFonts(); // Get the fonts
	    for (Font f : fonts) {
	      System.out.println(f.getFontName());
	    }
	}
}