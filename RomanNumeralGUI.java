import javax.swing.*;
import java.awt.*;
import java.util.*;

public class RomanNumeralGUI extends JFrame{
	
	public RomanNumeralGUI(String title, int height, int width) {
		setTitle(title);
		setSize(height,width);
		setLocation(400,200);
		createMenu();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	private void createMenu() {
	    JMenuItem   item;
	    JMenuBar    menuBar  = new JMenuBar();
	    JMenu       fileMenu = new JMenu("File");
	    JMenu		convertMenu = new JMenu("Convert");
	    FileMenuHandler fmh  = new FileMenuHandler(this);
	    FileMenuHandler cmh = new FileMenuHandler(this);

	    item = new JMenuItem("Open");
	    item.addActionListener(fmh);
	    fileMenu.add(item);

	    fileMenu.addSeparator();
	    
	    item = new JMenuItem("Quit");
	    item.addActionListener(fmh);
	    fileMenu.add(item);
	    
	    item = new JMenuItem("Roman to Arabic");
	    item.addActionListener(cmh);
	    convertMenu.add(item);

	    setJMenuBar(menuBar);
	    menuBar.add(fileMenu);
	    menuBar.add(convertMenu);
	    
	   }
	
}