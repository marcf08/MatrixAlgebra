import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.*;


/**
 * The linear algebra GUI creates the GUI and its methods
 * for the linear algebra application.
 * 
 * @author Marcus
 *
 */
public class LinearAlgebraGUI extends JFrame {
	/**
	 * The main window is for the main components.
	 */
	private Container mainWindow = getContentPane();
	/**
	 * The secondary window is for displaying any other options,
	 * items, etc. 
	 */
	private JFrame secondaryWindow;
	/**
	 * The controls panels will be reset according to the options.
	 * It will set matrix controls, calculator buttons, etc.
	 */
	private JPanel pnlControls;
	/**
	 * The other JPanel is for the answer/working field.
	 */
	private JPanel pnlWorkArea;
	/**
	 * The text area is the area for the calculations and user work.
	 */
	private JTextArea workingPane;
	/**
	 * The card layout is for showing the different controls.
	 */
	private FlowLayout layoutControls;
	/**
	 * Width of container
	 */
	private final int FRAME_WIDTH = 800;
	/**
	 * Height of container
	 */
	private final int FRAME_HEIGHT = 600;
	/**
	 * Name of program
	 */
	private final String PRG_NAME = "Linear Calculator";
	/**
	 * Constant for work sheet
	 */
	private final String WRK_SHT = "Worksheet";
	/**
	 * Default text for work area
	 */
	private final String DEF_MSG = "Linear Calculator 1.0";
	/**
	 * The main panel holds the components.
	 */
	private JPanel pnlMain;
	/**
	 * Label for work sheet area
	 */
	private JLabel lblWksht;
	/**
	 * Menu bar for file, save, settings, etc
	 */
	private JMenuBar menuBar;
	/**
	 * Menu bar items
	 */
	 private JMenuItem newItem, openItem, closeItem, saveItem, saveAsItem, printItem;
	
	
	
	/**
	 * Add components to their respective containers, set up the GUI.
	 */
	public void setupGUI() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
		setTitle(PRG_NAME);
		mainWindow.setLayout(new BorderLayout());
		setupWorkArea();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}
	
	/**
	 * The main panel holds the work related components.
	 *  
	 */
	public void setupWorkArea() {
		lblWksht = new JLabel(WRK_SHT);
		workingPane = new JTextArea(DEF_MSG);
		pnlWorkArea = new JPanel();
		
		//Draw work area panel
		pnlWorkArea.setLayout(new BoxLayout(pnlWorkArea, BoxLayout.Y_AXIS));
		
		
		//Add to main panel
		pnlWorkArea.add(lblWksht);
		pnlWorkArea.add(workingPane);
		pnlWorkArea.setVisible(true);
		
		//Add the work area to the main layout
		mainWindow.add(pnlWorkArea, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	
	/**
	 * Set up the JMenu bar for file, settings, save, etc.
	 */
	public void 
	
	
	
	/**
	 * Call methods, register listeners, set up the GUI.
	 */
	public LinearAlgebraGUI() {
		setupGUI();
		
		
	}
	
	/**
	 * Start the GUI
	 * @param args an array of command line arguments
	 */
	public static void main(String[] args) {
		new LinearAlgebraGUI();
	}
	
	
	
	
}