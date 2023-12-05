package controller;
/* Megan Chun
 * 
 * External Source: //https://stackoverflow.com/questions/5652344/how-can-i-use-a-custom-font-in-java
 */

import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.awt.Font;

import javax.swing.JFrame;

public class FontClass extends JFrame {

	//graphics environment 
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	
	//fonts
	public static Font regular16;
	public static Font medium16;
	public static Font medium25;
	public static Font medium50;
	public static Font semibold50;
	
	public FontClass() {
		
		//create the font

		try {
		    //create regular size 25 
			regular16 = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/DMSans.ttf")).deriveFont(16f);
		    ge.registerFont(regular16); //register the font
		    
		    //create regular size 25 
		    medium16 = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/DMSansMedium.ttf")).deriveFont(16f);
		    ge.registerFont(medium16); //register the font
		    
		    //create regular size 25 
		    medium25 = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/DMSansMedium.ttf")).deriveFont(25f);
		    ge.registerFont(medium25); //register the font
		    
		    //create regular size 25 
		    medium50 = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/DMSansMedium.ttf")).deriveFont(50f);
		    ge.registerFont(medium50); //register the font
		    
		    //create regular size 25 
		    semibold50 = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/DMSansSemiBold.ttf")).deriveFont(50f);
		    ge.registerFont(semibold50); //register the font
		     
		    
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}


	}
}
